package com.itheima.code5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server =new ServerSocket(8899);
        Socket socket = server.accept();
        FileOutputStream fos =new FileOutputStream("G:\\it\\1.jpg");
        InputStream is = socket.getInputStream();
        int len =0;
        byte[] bytes=new byte[1024];
        while ((len=is.read(bytes))!=-1){
            fos.write(bytes);
        }
        OutputStream os = socket.getOutputStream();
        os.write("上传成功".getBytes());
        fos.close();
        socket.close();
    }
}
