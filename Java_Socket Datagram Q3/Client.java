//client program
import java.io.*;
import java.net.*;

public class Client {

  public static void main(String[] args) {
    byte[] data;
    String line;
    DatagramPacket dp;
    try {
      InetAddress add = InetAddress.getLocalHost();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      DatagramSocket socket = new DatagramSocket();
      while (true) {
        line = br.readLine();
        if (line.equals("stop")) break;
        data = line.getBytes();
        dp = new DatagramPacket(data, data.length, add, 3490);
        socket.send(dp);
      }
    } catch (IOException ae) {
      System.out.println(ae);
    }
  }
}
