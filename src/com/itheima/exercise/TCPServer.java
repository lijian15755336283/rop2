package com.itheima.exercise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server =new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        byte[] bytes =new byte[1024];
        System.out.println(new String(bytes,0,is.read(bytes)));
        OutputStream os = socket.getOutputStream();
        os.write("hello world".getBytes());
        socket.close();
    }
}
