package org.example;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8090);

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(HelloWorldServlet.class, "/hello/*");
        servletHandler.addServletWithMapping(TextFileServlet.class, "/*");
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("JettyServer/pages/");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {
                servletHandler,
                resourceHandler,
                new DefaultHandler() });
        server.setHandler(handlers);

        server.start();
    }
}
