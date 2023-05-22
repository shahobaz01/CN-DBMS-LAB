//   Q. Socket Program to obtain date and time from server

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class server {

  public static void main(String a[]) throws Exception {
    try {
      ServerSocket serversocket = new ServerSocket(6000);
      Boolean flag = true;
      while (flag) {
        Socket connectionsocket = serversocket.accept();

        DataInputStream streamIn = new DataInputStream(
          new BufferedInputStream(connectionsocket.getInputStream())
        );

        DataOutputStream streamOut = new DataOutputStream(
          connectionsocket.getOutputStream()
        );

        System.out.println("The client is connected");

        Date date = Calendar.getInstance().getTime();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        String strDate = dateFormat.format(date);

        streamOut.writeUTF("Connected to server at port 6000");

        streamOut.writeUTF("Server Date and Time:" + strDate);
      }
    } catch (Exception e) { //end of try
      System.out.println("The client connection terminates");
    }
  } //end of main
}
