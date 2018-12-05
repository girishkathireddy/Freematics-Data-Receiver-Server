package com.lpr.track;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.lpr.track.entity.Clients;
import com.lpr.track.entity.Data;
import com.lpr.track.entity.ServerFeeds;
import com.lpr.track.entity.Servers;
import com.lpr.track.service.DataService;
import com.lpr.track.service.ServerFeedService;
import com.lpr.track.service.ServersService;
import com.lpr.track.utility.Helper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lpr.track.config.AppConfig;
import com.lpr.track.service.ClientService;

/**
 * @author Girish
 *
 */
public class MainApp {

   public static final String EVENT = "EV";
   public static final String TIME_STAMP_COUNTER = "TS";
   public static final String VIN = "VIN";
   public static final String SERVER_KEY = "SK";


   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      ClientService clientService = context.getBean(ClientService.class);
      ServersService serversService= context.getBean(ServersService.class);
      ServerFeedService serverFeedService= context.getBean(ServerFeedService.class);
      DataService dataService= context.getBean(DataService.class);

      List<Clients> clients = clientService.listClients();
      List<Servers> servers = serversService.listServerDetails();
      List<ServerFeeds> serverFeeds = serverFeedService.listServerFeedidDetails();




      try {
         int port = 443;
         DatagramSocket dsocket = new DatagramSocket(port);
         byte[] buffer = new byte[2048];
         System.out.println("Post-process begins.");
         DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

         while(true){
            dsocket.receive(packet);

            String msg = new String(buffer, 0, packet.getLength());
            System.out.println(packet.getAddress().getHostName() + ": "
                    + msg);
            packet.setLength(buffer.length);


            if (!msg.isEmpty() && msg != null) {
               String[] feedidIdnty = msg.trim().split("#");
               int feedId = Integer.parseInt(feedidIdnty[0]);
               int i = 10;
               InetAddress address = packet.getAddress();
               int portToSend = packet.getPort();


               if(feedId==0) {
//                  0#EV=1,TS=67538,VIN=1A1JC5444R7252367,SK=LPR01*E8
                  String event="";
                  String serverKey="";
                  String timeStampCounter="";
                  String vin="";
                  int minFeedid=0;
                  int maxFeedid=0;
                  int sendFeedid=0;
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                  Date date = new Date();
                  boolean clientExist= false;
                  List<String> elementsList = Arrays.asList(msg.split(","));

                  if(elementsList.size() !=0) {

                     for (String element : elementsList) {

                           String[] eachElement = element.trim().split("=");
                      //    System.out.println(eachElement[0]+" "+eachElement[1]);
                           if (eachElement[0].equalsIgnoreCase( EVENT)) {
                              event = eachElement[1];
                           } else if (eachElement[0].equalsIgnoreCase(TIME_STAMP_COUNTER)) {
                              timeStampCounter = eachElement[1];
                           } else if (eachElement[0].equalsIgnoreCase(VIN)) {
                               vin= eachElement[1];
                           } else if (eachElement[0].equalsIgnoreCase(SERVER_KEY)){
                              String[] ServerElement = eachElement[1].trim().split("\\*");
                              serverKey= ServerElement[0];
                           }

                     }
                     System.out.println("Server Key "+serverKey);
                     for (Servers server : servers) {
                        if(server.getSerkey().equalsIgnoreCase(serverKey)){
                             minFeedid=server.getSfeedidmin();
                             maxFeedid=server.getSfeedidmax();
                             clientExist= true;
                             break;

                        }
                     }
                     if(clientExist) {
                        String dateNow1 = sdf.format(date);
                        java.util.Date dn = sdf.parse(dateNow1);
                        ServerFeeds sf;
                        List<ServerFeeds> serverFeedsList= serverFeedService.getInfobyDateandKey(serverKey,vin,dn);
                        if(serverFeedsList.size() !=0){
                           System.out.println("Printing server feed details");
                           String fvin= vin;
                           ServerFeeds sf1 = serverFeedsList.stream()
                                   .filter(sf2 -> sf2.getSfvin().equals(fvin))
                                   .findAny()
                                   .orElse(null);
                           if(sf1 !=null){
                              sendFeedid = sf1.getSffeedid();
                           }else{
                              sf =  Collections.max(serverFeedsList, Comparator.comparing(s -> s.getSffeedid()));
                              sendFeedid = sf.getSffeedid()+1;
                              //later we need to throw exception if it exceeds max feed id
                              sf= new ServerFeeds();
                              sf.setSffeedid(sendFeedid);
                              sf.setSfdate(dn);
                              sf.setSfskey(serverKey);
                              sf.setSfvin(vin);
                              serverFeedService.add(sf);
                           }

                        }else{
                              //update
                           System.out.println("Adding todays feed info");
                           sf= new ServerFeeds();
                           sf.setSffeedid(minFeedid);
                           sf.setSfdate(dn);
                           sf.setSfskey(serverKey);
                           sf.setSfvin(vin);
                           serverFeedService.add(sf);
                           sendFeedid=minFeedid;
                        }
                      //feedId=sendFeedid;
                     }
                      System.out.println("Trasmiting feed id:"+sendFeedid);
                  }

                  while (feedId == 0 && i > 0 && clientExist) {
                     String sendString = sendFeedid+"#EV=1,RX=1000,VIN=1A1JC5444R7252367";
                     byte[] sendData = sendString.getBytes(StandardCharsets.US_ASCII);
                     System.out.println(portToSend + " PORT: address " + address);
                     DatagramPacket packet1 = new DatagramPacket(sendData, sendData.length, address, portToSend);
                     dsocket.send(packet1);
                     i--;
                  }
               } else {

                  List<String> dataList = Arrays.asList(msg.split(","));
                  Data data= Helper.splitData(dataList);
                  data.setDfeedId(feedId);
                  dataService.add(data);

               }

            }
         }

      } catch (Exception e) {
         System.err.println(e);
      }



      context.close();
   }
}
