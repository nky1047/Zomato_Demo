package org.zomato.nitin.Utility;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientDemo {
    public static void main(String[] args) {
        // Create HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Create a GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print status code and body
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
