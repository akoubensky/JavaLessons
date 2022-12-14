package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JettyClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "http://localhost:8090/hello";
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        int status = response.statusCode();
        HttpHeaders headers = response.headers();
        System.out.println(headers.toString());
        System.out.println(status);
        System.out.println(body);
    }
}
