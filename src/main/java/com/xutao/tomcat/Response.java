package com.xutao.tomcat;

/**
 * Created by xtao on 2016/9/11 0011.
 */
public class Response {
    private Boolean needResponse;
    private String html;

    public Boolean getNeedResponse() {
        return needResponse;
    }

    public void setNeedResponse(Boolean needResponse) {
        this.needResponse = needResponse;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
