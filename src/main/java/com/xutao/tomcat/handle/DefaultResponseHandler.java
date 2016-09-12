package com.xutao.tomcat.handle;

import com.xutao.tomcat.Request;
import com.xutao.tomcat.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by xtao on 2016/9/11 0011.
 */
public class DefaultResponseHandler implements ResponseHandle {
    @Override
    public void setContent(Request request, Response response) {
        response.setHtml(request.getUri());
    }

    @Override
    public void returnMessage(Request request, Response response) {
        // send response msg
        OutputStream os = request.getOs();
        try {
            if(StringUtils.isNotEmpty(response.getHtml())) {
                os.write(response.getHtml().getBytes());
            }
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
