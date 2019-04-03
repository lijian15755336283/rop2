package com.itheima.code2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket =new ServerSocket(8855);
        File file =new File("G:\\kk");
        if(!file.exists()){
            file.mkdirs();
        }
        FileOutputStream fos =new FileOutputStream(file+"\\1.jpg");
        Socket s = socket.accept();
        InputStream is = s.getInputStream();
        int len =0;
        byte[] bytes=new byte[1024];
        while ((len=is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        System.out.println("====");
        OutputStream os = s.getOutputStream();
        os.write("上传成功".getBytes());
        fos.close();
        s.close();

    }
}
