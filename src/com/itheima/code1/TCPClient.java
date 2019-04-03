package com.itheima.code1;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket =new Socket("localhost",8989);

        OutputStream os = socket.getOutputStream();

        for (int i = 0; i < 10; i++) {
            os.write("这是客户端".getBytes());

            os.flush();
            System.out.println();
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        byte[] bytes =new byte[1024];
        int read = is.read(bytes);

        System.out.println(new String(bytes,0,read));

        //socket.close();

    }
}
