package com.xutao.tomcat.handle;

import com.xutao.tomcat.Request;
import com.xutao.tomcat.Response;

/**
 * Created by xtao on 2016/9/11 0011.
 */
public interface Handle {
    void handle(Request request, Response response);
}
