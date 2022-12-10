package fr.pandonia.tools.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HTTPRequest {

    private String url;
    private Map<String, String> params;

    public HTTPRequest(String url, Map<String, String> params){
        this.url = url;
        if (params != null){
            this.params = params;
        }else{
            this.params = new HashMap<>();
        }

    }

    public HTTPResponse get(){
        URL url = null;
        HttpURLConnection c = null;
        try {
            url = new URL(this.url);
            c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.connect();
            return new HTTPResponse(c);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

}
