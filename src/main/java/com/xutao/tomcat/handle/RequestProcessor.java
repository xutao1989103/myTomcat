package com.xutao.tomcat.handle;


import com.xutao.tomcat.Request;
import com.xutao.tomcat.Response;

import java.net.Socket;

/**
 * Created by xtao on 2016/9/11 0011.
 */
public class RequestProcessor implements Handle,Runnable {

    private Socket socket;
    private RequestHandle requestHandle;
    private ResponseHandle responseHandle;
    private Request request;
    private Response response;

    public RequestProcessor(RequestHandle requestHandle, ResponseHandle responseHandle) {
        this.requestHandle = requestHandle;
        this.responseHandle = responseHandle;
    }

    public RequestProcessor(Socket socket) throws Exception{
        this.socket = socket;
        this.requestHandle = new DefaultRequestHandler();
        this.responseHandle = new DefaultResponseHandler();
        this.request = new Request(socket);
        this.response = new Response();
    }

    @Override
    public void handle() {
        requestHandle.checkRequest(request, response);
        responseHandle.setContent(request, response);
        responseHandle.returnMessage(request, response);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        handle();
    }
}
