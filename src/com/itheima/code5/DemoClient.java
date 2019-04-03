package com.itheima.code5;

import java.io.*;
import java.net.Socket;

public class DemoClient {
    public static void main(String[] args) throws IOException {
        Socket socket =new Socket("localhost",8899);
        FileInputStream fis =new FileInputStream("G:\\kk\\1.jpg");
        OutputStream os = socket.getOutputStream();
        int len =0;
        byte[] bytes =new byte[1024];
        while ((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        while ((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        socket.close();
    }
}
