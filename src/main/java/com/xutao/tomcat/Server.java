package com.xutao.tomcat;

import com.xutao.tomcat.handle.ContentHandle;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xtao on 2016/9/11 0011.
 */
public class Server {

    private static int count = 0;

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket = null;

        try {
            ss = new ServerSocket(9999);
            System.out.println("server has init, waiting for connection");
            while (true){
                socket = ss.accept();
                count ++;
                //get request msg
                try {
                    Request request = new Request(socket);
                    Response response = new Response();
                    ContentHandle handle = new ContentHandle();
                    handle.handle(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
