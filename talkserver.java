package com.imooc;
//点对点聊天程序,服务器端
import java.net.*;
import java.io.*;
public class talkserver{
public static void main(String args[]){
ServerSocket server = null;
Socket socket;
String s;//中间字符串
int port = 2000;
String hello = "From Server:Hello World!";
try{
 server = new ServerSocket(port);
   //建立服务器Socket连接，其侦听端口为port，port与客户端相同
 System.out.println("正在等待连接端口port=" + port + "...");
 socket = server.accept();
 System.out.println("已成功连接端口port=" + port);
 System.out.println("=========================================");
 
 InputStream in = socket.getInputStream();
 DataInputStream din = new DataInputStream(in);
  //获取输入流，并创建相应的数据输入流
 OutputStream out = socket.getOutputStream();
 DataOutputStream dout = new DataOutputStream(out);
  //获取输出流，并创建相应的数据输出流
 BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
 
 System.out.println("请等待客户发送信息...");
while(true){
 System.out.println("");
 s = din.readUTF();  //读入从client传来的字符串
 System.out.println("从客户端接收的信息为:" + s);//显示字符串
 if(s.trim().equals("BYE")) {System.out.print("通话结束" );break;}
 
 System.out.println("");
 System.out.print("请输入要发送的信息:" );//显示字符串
 s = sin.readLine();  //读入从client传来的字符串
 dout.writeUTF(s);
 if(s.trim().equals("BYE")) {System.out.print("通话结束" );break;}
}
 din.close();
 dout.close();
 in.close();
 out.close();
 socket.close();
}
catch(IOException e){
 System.out.println("Error" + e);//若端口已被占用，则抛出异常
 System.exit(1);
}
}
}
//程序分析:
//程序首先在端口2000上创建一个等待连接请求的ServerSocket对象sever:
//server=new ServerSocket(2000);
//接着调用Server对象的accept()方法等待某客户程序发出的连接请求。
//该方法一直阻塞直到有客户连接到该端口。
//一旦有客户发送正确请求，则连接成功，accept()方法返回一个Socket对象,
//于是得到一个新的用于通信的Socket对象,通信链路建立成功.
//然后利用Socket类提供的getInputStream()和getOutputStream()方法
//创建与Socket对象绑定的输入/输出流.此后即可与客户进行通信,
//直到客户端断开连接即关闭各个流结束通信.

