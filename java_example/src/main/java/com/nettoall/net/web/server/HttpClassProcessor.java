package com.nettoall.net.web.server;

import java.io.IOException;

public interface HttpClassProcessor extends HttpProcessor {
    public void initRequest(HttpInputStream in) throws IOException;
}
