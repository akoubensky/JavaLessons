package org.testjetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {
    private Server server;

    public void start() throws Exception {
        server = new Server(8090);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(BlockingServlet.class, "/country/*");
        server.setHandler(handler);
        server.start();
    }

    public static void main(String[] args) throws Exception {
        new JettyServer().start();
    }
}
