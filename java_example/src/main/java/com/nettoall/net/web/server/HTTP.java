package com.nettoall.net.web.server;

//import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Vector;

public class HTTP {
    public static final String SERVER_INFO  ="JNP-HTTPD/1.0";
    public static final String CGI_BIN = "/cgi-bin/";
    public static final String CLASS_BIN = "/class-bin/";
    public static final File SERVER_LOCATION = new File(System.getProperty("user.dir"));
    public static final File HTML_ROOT = new File(SERVER_LOCATION, "html");
    public static final int PORT = 8888;
    public static final String DEFAULT_INDEX = "index.html";

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_HEAD = "HEAD";

    public static final int STATUS_OKAY  = 200;
    public static final int STATUS_NO_CONTENT  = 204;
    public static final int STATUS_MOVED_PERMANENTLY  = 301;
    public static final int STATUS_MOVED_TEMPORARILY  = 302;
    public static final int STATUS_BAD_REQUEST  = 400;
    public static final int STATUS_FORBIDDEN  = 403;
    public static final int STATUS_NOT_FOUND  = 404;
    public static final int STATUS_NOT_ALLOWED  = 405;
    public static final int STATUS_INTERNAL_ERROR  = 500;
    public static final int STATUS_NOT_IMPLEMENTED  = 501;

    protected static final Vector environment = new Vector();

    static{
        environment.addElement("SERVER_SOFTWARE=" + SERVER_INFO);
        environment.addElement("GATEWAY_INTERFACE=" + "CGI/1.0");
        environment.addElement("SERVER_PORT=" + PORT);
        environment.addElement("DOCUMENT_ROOT=" + HTML_ROOT.getPath());
        try{
            environment.addElement("SERVER_NAME=" + InetAddress.getLocalHost().getHostName());
        }catch(UnknownHostException ex){
            environment.addElement("SERVER_NAME=localhost");
        }
    }

    public static String getCodeMessage(int code){
        switch(code){
            case STATUS_OKAY:                return "OK";
            case STATUS_NO_CONTENT:          return "No Content";
            case STATUS_MOVED_PERMANENTLY:   return "Moved Permanently";
            case STATUS_MOVED_TEMPORARILY:   return "Moved Temporarily";
            case STATUS_BAD_REQUEST:         return "Bad Request";
            case STATUS_FORBIDDEN:            return "Forbidden";
            case STATUS_NOT_FOUND:           return "Not Found";
            case STATUS_NOT_ALLOWED:         return "Method Not Allowed";
            case STATUS_INTERNAL_ERROR:      return "Internal Server Error";
            case STATUS_NOT_IMPLEMENTED:     return "Not Implemented";
            default:                         return "Unknown Code(" + code + ")";
        }
    }

    public static String canonicalizePath(String path){
        char[] chars = path.toCharArray();
        int length = chars.length;
        int idx, odx = 0;

        while((idx = indexOf(chars, length, '/', odx)) < length-1){
            int ndx = indexOf(chars, length, '/', idx +1), kill = -1;
            if(ndx == idx +1){
                kill = 1;
            }else if((ndx >= idx +2) && (chars[idx+1] == '.')){
                if(ndx == idx +2){
                    kill = 2;
                }else if((ndx == idx +3) && (chars[idx +2] == '.')){
                    kill = 3;
                    while((idx > 0) && (chars[ --idx] != '/'))
                        ++kill;
                }
            }
            if(kill == -1){
                idx = ndx;
            }else if(idx + kill >= length){
                length = odx = idx +1;
            }else{
                length -= kill;
                System.arraycopy(chars, idx +1 +kill, chars, idx +1, length - idx -1);
                odx = idx;
            }
        }
        return new String(chars, 0, length);
    }

    protected static int indexOf(char[] chars, int length, char chr, int from){
        while((from < length) && (chars[from] != chr))
            ++from;
        return from;
    }

    public static String translateFilename(String filename){
        StringBuffer result = new StringBuffer();
        int idx, odx = 0;

        while((idx = filename.indexOf('/', odx)) != -1){
            result.append(filename.substring(odx, idx)).append(File.separator);
            odx = idx +1;
        }

        result.append(filename.substring(odx));
        return result.toString();
    }

    public static String decodeSting(String str){
        String replaced = str.replace('+',' ');
        StringBuffer result = new StringBuffer();
        int idx, odx = 0;

        while((idx = str.indexOf('%', odx)) != -1){
            result.append(replaced.substring(odx,idx));
            try{
                result.append((char) Integer.parseInt(str.substring(idx+1, idx + 3), 16));
            }catch(NumberFormatException ex){

            }
            odx = idx +3;
        }
        result.append(replaced.substring(odx));
        return result.toString();
    }

    protected static final Hashtable mimeTypes = new Hashtable ();
    static{
        mimeTypes.put("gif", "image/gif");
        mimeTypes.put("jpeg", "image/jpeg");
        mimeTypes.put("jpg", "image/jpg");
        mimeTypes.put("html", "text/html");
        mimeTypes.put("htm", "text/htm");
    }

    public static String guessMimeType(String fileName){
        int i = fileName.lastIndexOf(".");
        String type = (String)mimeTypes.get(fileName.substring(i+1).toLowerCase());
        return (type != null) ? type:"text/plain";
    }
}
