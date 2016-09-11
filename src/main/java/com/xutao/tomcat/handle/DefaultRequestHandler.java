package com.xutao.tomcat.handle;

import com.xutao.tomcat.Request;
import com.xutao.tomcat.Response;

/**
 * Created by xtao on 2016/9/11 0011.
 */
public class DefaultRequestHandler implements RequestHandle {
    @Override
    public void checkRequest(Request request, Response response) {
        if("/favicon.ico".equals(request.getPath())) {
            response.setNeedResponse(false);
        }
    }
}
