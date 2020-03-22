package com.nettoall.net.web.server;

import java.io.IOException;

public class HttpException extends IOException implements HttpProcessor {
    protected int code;

    public HttpException(int code, String detail){
        super(detail);
        this.code = code;
    }

    public void processRequest(HttpOutputStream out ) throws IOException{
        out.setCode(code);
        out.setHeader("Content-Type", "text/html");

        if(out.sendHeaders()){
            String msg = HTTP.getCodeMessage(code);
            out.write("<HTML><HEAD><TITLE>" + code + " " + msg + "</TITLE></HEAD>\n" + "<BODY<H1>" + msg + "</H1>\n" +
                    getMessage() + "<P>\n</BODY></HTML>\n");
        }
    }
}
