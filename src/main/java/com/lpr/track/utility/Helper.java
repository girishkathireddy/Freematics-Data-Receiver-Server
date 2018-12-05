package com.lpr.track.utility;

import com.lpr.track.entity.Data;

import java.util.List;

public class Helper {

    public static Data splitData(List<String> dataList){
        Data data = new Data();
        for (String element : dataList) {

            String[] eachElement = element.trim().split(":");
        //    System.out.println(eachElement[0]+" "+eachElement[1]);
            if (eachElement[0].equalsIgnoreCase( HelperConstants.GPSA)) {
                data.setGpsA(eachElement[1]);
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.GPSB)) {
                data.setGpsB(eachElement[1]);
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.GPSC)) {
                data.setGpsC(eachElement[1]);
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.GPSD)) {
                data.setGpsD(eachElement[1]);
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.GPSF)) {
                data.setGpsF(eachElement[1]);
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.ONEZEROFIVE)) {
                data.setOneZeroFive(Integer.parseInt(eachElement[1]));
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.ONEZEROFOUR)) {
                data.setOneZeroFour(Integer.parseInt(eachElement[1]));
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.TEN)) {
                data.setTen(Long.parseLong(eachElement[1]));
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.TENA)) {
                data.setTenA(Integer.parseInt(eachElement[1]));
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.TENC)) {
                data.setTenC(Integer.parseInt(eachElement[1]));
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.TEND)) {
                data.setTenD(Integer.parseInt(eachElement[1]));
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.TENE)) {
                data.setTenE(Integer.parseInt(eachElement[1]));
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.TENF)) {
                data.setTenF(Integer.parseInt(eachElement[1]));
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.TEWENTYFOUR)) {
                String[] ele = eachElement[1].trim().split("\\*");
                data.setTewentyFour(Integer.parseInt(ele[0]));
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.THIRTY)) {
                String[] ele = eachElement[1].trim().split("\\*");
                data.setThirty(Integer.parseInt(ele[0]));
            } else if (eachElement[0].equalsIgnoreCase(HelperConstants.THRIBBLEONE)) {
                data.setThribbleOne(Integer.parseInt(eachElement[1]));
            }




        }

        return data;
    }

}
