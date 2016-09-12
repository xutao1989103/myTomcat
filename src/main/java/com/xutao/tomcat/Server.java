package com.xutao.tomcat;

import com.xutao.tomcat.handle.RequestProcessor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xtao on 2016/9/11 0011.
 */
public class Server {

    private static int count = 0;
    public static final Integer port = 9999;

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket = null;
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            ss = new ServerSocket(port);
            System.out.println("server has init, waiting for connection");
            while (true){
                socket = ss.accept();
                count ++;
                //get request msg
                try {
                    RequestProcessor processor = new RequestProcessor(socket);
                    executor.execute(processor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
