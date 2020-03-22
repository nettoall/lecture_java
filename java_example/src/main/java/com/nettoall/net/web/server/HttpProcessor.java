package com.nettoall.net.web.server;

import java.io.IOException;

public interface HttpProcessor {
    public void processRequest(HttpOutputStream out) throws IOException;
}
