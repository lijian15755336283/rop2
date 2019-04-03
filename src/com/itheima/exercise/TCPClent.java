package com.itheima.exercise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
需求说明：创建新项目，按以下要求编写代码：
在项目下创建TCP 客户端
访问之前创建的服务器端,服务器端ip127.0.0.1 端口号8888
1:客户端连接服务器,并发送 hello.服务器,我是客户端.
2:开启上一题服务器,等待客户端连接,客户端连接并发送数据
 */
public class TCPClent {
    public static void main(String[] args) throws IOException {
        Socket socket =new Socket("localhost",8888);
        OutputStream os = socket.getOutputStream();
        os.write(" hello.服务器,我是客户端.".getBytes());
        InputStream is = socket.getInputStream();
        byte[] bytes =new byte[1024];
        System.out.println(new String(bytes,0,is.read(bytes)));

        socket.close();
    }
}
