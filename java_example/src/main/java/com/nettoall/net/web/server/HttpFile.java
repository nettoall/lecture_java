package com.nettoall.net.web.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class HttpFile implements HttpProcessor {
    protected File file ;

    public HttpFile(HttpInputStream in ) throws IOException{
        if(in.getMethod() == HTTP.METHOD_POST)
            throw new HttpException(HTTP.STATUS_NOT_ALLOWED, "<TT>" + in.getMethod() + " " + in.getPath() + "</TT>");
        file = new File(HTTP.HTML_ROOT, HTTP.translateFilename(in.getPath()));

        if(in.getPath().endsWith("/"))
            file = new File(file, HTTP.DEFAULT_INDEX);

        if(!file.exists())
            throw new HttpException(HTTP.STATUS_NOT_FOUND,"File <TT>" + in.getPath() + "</TT> not found.");

        if(file.isDirectory())
            throw new RedirectException(HTTP.STATUS_MOVED_PERMANENTLY, in.getPath() + "/");

        if(!file.isFile() || !file.canRead())
            throw new HttpException(HTTP.STATUS_FORBIDDEN, in.getPath());
    }

    public void processRequest(HttpOutputStream out) throws IOException{
        out.setHeader("Content-type", HTTP.guessMimeType(file.getName()));
        out.setHeader("Content-length", String.valueOf(file.length()));
        if(out.sendHeaders()){
            FileInputStream in = new FileInputStream(file);
            out.write(in);
            in.close();
        }
    }
}
