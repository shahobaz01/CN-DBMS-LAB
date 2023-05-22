// Q1. Write Socket Programme to deliver message frm client to server Program

import java.io.*;
import java.net.*;
public class server1
{
public static void main(String a[]) throws Exception
{
try
{
ServerSocket serversocket = new ServerSocket(6000);
Boolean flag = true;
while(flag)
{
Socket connectionsocket = serversocket.accept();
DataInputStream streamln = new DataInputStream(new BufferedInputStream(connectionsocket.getInputStream()));
DataOutputStream streamOut = new DataOutputStream(connectionsocket.getOutputStream());
System.out.println("The client is connected");
String line = "";
while(true)
{
line = streamln.readUTF();
if(!line.equalsIgnoreCase("stop"))
System.out.println(line);
else
{
flag = false;
break;
}
}
}
}//end of try
catch(Exception e)
{
System.out.println("The client connection terminates");
}
}//end of main
}
