package org.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();

        response.setContentType("text/plain; charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = response.getWriter();
        String responseMessage = "Hello world";
        if (path != null && path.length() >= 4) {
            responseMessage = switch (path.substring(0, 4).toLowerCase()) {
                case "/rus" -> "Привет, мир!";
                case "/eng" -> "Hello world";
                case "/deu" -> "Hallo Welt";
                case "/esp" -> "Hola Mundo";
                case "/ita" -> "Ciao mondo";
                case "/ukr" -> "Привіт Світ";
                default -> "Hello world";
            };
        }
        writer.println(responseMessage);
        writer.close();
    }
}
