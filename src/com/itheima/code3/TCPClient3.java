package com.itheima.code3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient3 {
    public static void main(String[] args) throws Exception {
        Socket socket =new Socket("localhost",9989);
        FileInputStream fis =new FileInputStream("G:\\itheima\\3.jpg");
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
