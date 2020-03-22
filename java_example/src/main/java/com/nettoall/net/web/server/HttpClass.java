package com.nettoall.net.web.server;

import java.io.IOException;

public class HttpClass implements HttpProcessor {
    protected HttpClassProcessor processor;

    public HttpClass(HttpInputStream in ) throws IOException, IllegalAccessException, InstantiationException {
        String classPath = in.getPath().substring(HTTP.CLASS_BIN.length());
        int idx = classPath.indexOf('/');
        String className = (idx < 0 ) ? classPath: classPath.substring(0, idx);

        try{
            Class theClass = Class.forName(className);
            processor = (HttpClassProcessor) theClass.newInstance();
        }catch(ClassNotFoundException ex){
            throw new HttpException(HTTP.STATUS_NOT_FOUND, "Class <TT>" + className + "</TT> not found.");
        }
        processor.initRequest(in);
    }

    public void processRequest(HttpOutputStream out) throws IOException{
        processor.processRequest(out);
    }
}
