package com.kenzie.app;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CustomHttpClient {

    //TODO: Write sendGET method that takes URL and returns response
    public static String sendGET(String URLString) {
        //** Start of GET request algorithm
        HttpClient client = HttpClient.newHttpClient(); //client object
        URI uri = URI.create(URLString);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                return httpResponse.body();
            } else {
                // String.format is fun! Worth a Google if you're interested
                return String.format("GET request failed: %d status code received", statusCode);
            }
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }


    public static List<CluesDTO> getClueList(String httpResponseBody) throws RuntimeException {
        List<CluesDTO> clueObj;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<CluesDTO>> typeRefList = new TypeReference<>() {
            };
            clueObj = objectMapper.readValue(httpResponseBody, typeRefList);
        } catch (IOException e) {
            System.out.println("Exception error: " + e);
            throw new RuntimeException(e);
        }
        return clueObj;
    }
}


