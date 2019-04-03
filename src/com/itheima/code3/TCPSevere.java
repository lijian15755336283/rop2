package com.itheima.code3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPSevere {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9989);
        while (true) {
            Socket socket = server.accept();
            String hostAddress = socket.getInetAddress().getHostAddress();
            System.out.println(hostAddress+"正在上传");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        File file = new File("G:\\kkk");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        FileOutputStream fos = new FileOutputStream(file + "\\itheima" + System.currentTimeMillis() + new Random().nextInt(999) + ".jpg");
                        InputStream is = socket.getInputStream();

                        int len = 0;
                        byte[] bytes = new byte[1024];

                        while ((len = is.read(bytes)) != -1) {

                            fos.write(bytes, 0, len);

                        }

                        OutputStream os = socket.getOutputStream();
                        os.write("上传成功".getBytes());
                        fos.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

    }
}
