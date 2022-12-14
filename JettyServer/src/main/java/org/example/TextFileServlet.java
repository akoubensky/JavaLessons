package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Сервлет, обрабатывающий только запросы типа GET и выдающий статические страницы,
 * читая файл, указанный в запросе.
 */
public class TextFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
    		HttpServletRequest request,
    		HttpServletResponse response) throws IOException {
    	
    	String path = request.getPathInfo();
    	response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html; charset=UTF-8");
    	if (!(path.endsWith(".htm") || path.endsWith(".html"))) {
    		response.setContentType("text/plain; charset=UTF-8");
    	}
    	
    	// Формируем относительное имя файла (относительно текущего каталога проекта)
		String fileName = "." + path;
		PrintWriter responseWriter = response.getWriter();
		try {
			Files.lines(Path.of(fileName)).forEach(responseWriter::println);
		} catch (IOException e) {
	        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.setContentType("text/html");
			responseWriter.println(String.format(
					"<title>File not found</title>" +
					"<h2>404 - PAGE NOT FOUND</h2>\n" +
					"<p style=\"font-size:16pt\">" +
							"Sorry, the requested page <code>%s</code> is not found" +
					"</p>",
					path));
		} finally {
			responseWriter.close();
		}
    }
    
    // Запросы PUT, POST, DELETE и другие не обрабатываются
}
