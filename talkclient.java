package com.imooc;
import java.net.*;
import java.io.*;
public class talkclient{
 public static void main(String args[]){
  Socket socket;
  String s;
  int port = 2000;
  try{
   //向本地服务器申请连接
   //注意端口号要和服务器的一致
   socket = new Socket("localhost",port);//localhost=127.0.0.1
   System.out.println("连接成功");
   System.out.println("=========================================");
   System.out.println("");
   //获得对应Socket的输入/输出流
   InputStream in = socket.getInputStream();
   DataInputStream din = new DataInputStream(in);
    //获取输入流，并创建相应的数据输入流
   OutputStream out = socket.getOutputStream();
   DataOutputStream dout = new DataOutputStream(out);
    //获取输出流，并创建相应的数据输出流
   BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
  while(true){
    System.out.print("请输入要发送的信息:" );//显示字符串
    s = sin.readLine();  //读入从client传来的字符串
    dout.writeUTF(s);
    if(s.trim().equals("BYE")) {System.out.print("通话结束" );break;}
    System.out.println("");
    
    s = din.readUTF();  //读入从client传来的字符串
    System.out.println("从服务器接收的信息为:" + s);//显示字符串
    if(s.trim().equals("BYE")) {System.out.print("通话结束" );break;}
    System.out.println("");
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

