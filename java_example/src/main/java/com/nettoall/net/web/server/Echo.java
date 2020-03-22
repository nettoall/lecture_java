package com.nettoall.net.web.server;

import java.io.IOException;

public class Echo implements HttpClassProcessor {
    protected String message;

    public void initRequest(HttpInputStream in ) throws IOException{
        if(in.getMethod() != HTTP.METHOD_GET)
            throw new HttpException(HTTP.STATUS_NOT_ALLOWED, "Request method <TT>" + in.getMethod() + "</TT> not allowed.");
        message = HTTP.decodeSting(in.getQueryString());
    }

    public void processRequest(HttpOutputStream out ) throws IOException{
        out.setHeader("Content-type", "text/plain");
        if(out.sendHeaders())
            out.write(message + "\r\n");
    }
}
