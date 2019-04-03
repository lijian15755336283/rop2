package com.itheima.code4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server =new ServerSocket(7889);

        while (true){
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();

                        BufferedReader br =new BufferedReader(new InputStreamReader(is));
                        String s = br.readLine();
                        String[] split = s.split(" ");
                        String sb = split[1].substring(1);
                        OutputStream os = socket.getOutputStream();
                        FileInputStream fis =new FileInputStream(sb);
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());

                        os.write("\r\n".getBytes());
                        int len =0;
                        byte[] bytes =new byte[1024];
                        while ((len=fis.read(bytes))!=-1){
                            os.write(bytes,0,len);
                        }

                        is.close();
                        socket.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
