# Freematics-Data-Receiver-Server
Java application server built using Spring, JPA, Hibernate to receive and store UDP data from Freematics One Plus Device
 ```
 Technologies:Java 1.8.0_151, Spring, JPA, Hibernate, MySQL
 ```
 The server authenticates the Freematics Devices and receives the UDP data continuously in the format as observed below. The data is processed and stored in the MySQL database.
 ```
<Feed ID>#<PID 1>:<value 1>,<PID 2>:<value 2>,<PID 3>:<value 3>,...$<Checksum>
```
Example:
```
1#0:68338,10D:79,30:1010,105:199,10C:4375,104:56,111:62,20:0;-1;95,10:6454200,A:-32.727482,B:150.150301,C:159,D:0,F:5,24:1250*7A
```
Instructions to run:
1. Export the database dump into MySQL database.
2. Edit the persistence configuration file with your database credentials
3. Build the application with the command 'mvn package'
4. Run the jar file with the command 'java -jar track-server-0.0.1-SNAPSHOT.jar'


