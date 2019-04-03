package com.itheima.code2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
	1.通过指定的IP地址和端口创建客户端Socket对象
		2.创建本地字节输入流FileInputStream对象，构造方法中传入要读的文件路径
		3.通过客户端Socket对象的getOutputStream方法获取网络字节输出流OutputStream对象
		4.通过本地字节输入流FileInputStream对象的read方法，把数据写出到服务器
		5.通过网络字节输出流对象OutputStream对象的write方法，将数据发送到服务器
		6.通过客户端Socket对象的getInputStream方法获取网络字节输入流InputStream对象
		7.通过网络字节输入流InputStream对象的read方法，读取服务器回写的数据
		8.释放资源（FileInputStream,Socket）
 */
public class Tpc {
    public static void main(String[] args) throws IOException {
        Socket socket =new Socket("localhost",8855);
        FileInputStream fs =new FileInputStream("G:\\a\\timg.jpg");
        OutputStream os = socket.getOutputStream();
        int len =0;
        byte[] bytes =new byte[1024];
        while ((len=fs.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        while ((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fs.close();
        socket.close();
    }
}
