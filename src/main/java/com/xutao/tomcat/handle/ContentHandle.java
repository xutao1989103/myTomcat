package com.xutao.tomcat.handle;


import com.xutao.tomcat.Request;
import com.xutao.tomcat.Response;

/**
 * Created by xtao on 2016/9/11 0011.
 */
public class ContentHandle implements Handle {

    private RequestHandle requestHandle;
    private ResponseHandle responseHandle;

    public ContentHandle( RequestHandle requestHandle, ResponseHandle responseHandle) {
        this.requestHandle = requestHandle;
        this.responseHandle = responseHandle;
    }

    public ContentHandle() {
        this.requestHandle = new DefaultRequestHandler();
        this.responseHandle = new DefaultResponseHandler();
    }

    @Override
    public void handle(Request request, Response response) {
        requestHandle.checkRequest(request, response);
        responseHandle.setContent(request, response);
        responseHandle.returnMessage(request, response);
    }
}
