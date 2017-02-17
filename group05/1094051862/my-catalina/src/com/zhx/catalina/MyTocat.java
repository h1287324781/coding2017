package com.zhx.catalina;

import http.MyServlet;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTocat {
	
	
	
	public void start(int port) throws Exception {
		ServerSocket server = new ServerSocket(port);
		System.out.println("Tomcat已启动，监听端口是"+port);
		while(true) {
			Socket client = server.accept();
			
			InputStream in = client.getInputStream();
			
			MyRequest request = 
			
			StringBuffer sb = new StringBuffer();
			byte [] buff = new byte[1024];
			int len  ;
			while((len= in.read(buff) )> 0) {
				sb.append(new String(buff,0,len));
			}
			in.close();
			
			String method = "";
			String url = "";
			String[] arr = sb.toString().split("\n");
			for (int i=0;i<arr.length;i++) {
				if (i==0){
					String[] larr = arr[i].split("\s");
					method = larr[0];
					url = larr[1];
				}
			}
			
			MyServlet servlet = new MyServlet() {
				
			}
			
			
			System.out.println("url"+url+",method"+method);
			
			
			System.out.println(sb.toString());
			
			in.read();
			
			OutputStream out = client.getOutputStream();
			
			out.flush();
			
			out.write("Hello World".getBytes());
			client.close();
		}
	}
	public static void main(String[] args) throws Exception {
		new MyTocat().start(8080);
	}
}
