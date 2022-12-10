package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8090);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(JettyServlet.class, "/status");
        server.setHandler(handler);

        server.start();
    }
}
