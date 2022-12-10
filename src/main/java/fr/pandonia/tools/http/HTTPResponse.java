package fr.pandonia.tools.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HTTPResponse {

    private int statusCode;
    private String content;

    public HTTPResponse(HttpURLConnection connection){
        try {
            this.statusCode = connection.getResponseCode();
            switch (getStatusCode()) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    br.close();
                    this.content =  sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.disconnect();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getContent() {
        return content;
    }
}

