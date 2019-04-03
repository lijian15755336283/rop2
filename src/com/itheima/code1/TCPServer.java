package com.itheima.code1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server =new ServerSocket(8989);

        while (true){
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();

                        byte[] bytes =new byte[1024];

                        System.out.println(new String(bytes,0,inputStream.read(bytes)));
                        OutputStream outputStream = socket.getOutputStream();

                        outputStream.write("这是服务器".getBytes());
                        socket.close();
                    }catch ( IOException e){
                        e.printStackTrace();
                    }

                }
            }).start();

        }


    }
}
