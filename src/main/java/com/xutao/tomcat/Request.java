package com.xutao.tomcat;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by xtao on 2016/9/11 0011.
 */
public class Request {

    private String uri;
    private String method;
    private String path;
    private String version;
    private String host;
    private String conection;
    private String Cookie;
    private OutputStream os;


    public Request(Socket socket) throws Exception{
        InputStream is = socket.getInputStream();
        byte[] buff = new byte[1024];
        int len = is.read(buff);
        if(len > 0) {
            String msg = new String(buff, 0, len);
            convertToParams(msg, this);
        }else {
            System.out.println("bad request");
        }
        os = socket.getOutputStream();
    }

    private void convertToParams(String reqStr, Request request) {
        String[] details = reqStr.split("\n");
        String methodAndPath = details[0];
        String[] pathDetail = methodAndPath.split(" ");
        request.setMethod(pathDetail[0]);
        request.setPath(pathDetail[1]);
        request.setVersion(pathDetail[2]);
        for(int i=1; i< details.length; i++){
            String[] items = details[i].split(":");
            if("Host".equals(items[0])) {
                request.setHost(items[1]);
                request.setUri(items[1] + request.getPath());
            }
            if("Cookie".equals(items[0])) {
                request.setCookie(items[1]);
            }
        }
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConection() {
        return conection;
    }

    public void setConection(String conection) {
        this.conection = conection;
    }

    public String getCookie() {
        return Cookie;
    }

    public void setCookie(String cookie) {
        Cookie = cookie;
    }

    public OutputStream getOs() {
        return os;
    }

    public void setOs(OutputStream os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Request{" +
                "uri='" + uri + '\'' +
                ", method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", host='" + host + '\'' +
                ", conection='" + conection + '\'' +
                ", Cookie='" + Cookie + '\'' +
                '}';
    }
}
