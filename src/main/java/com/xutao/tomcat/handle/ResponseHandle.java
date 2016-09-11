package com.xutao.tomcat.handle;

import com.xutao.tomcat.Request;
import com.xutao.tomcat.Response;

/**
 * Created by xtao on 2016/9/11 0011.
 */
public interface ResponseHandle {
    void setContent(Request request, Response response);
    void returnMessage(Request request, Response response);
}
