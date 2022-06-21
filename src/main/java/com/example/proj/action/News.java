package com.example.proj.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.proj.model.NewsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class News extends ActionSupport{
    NewsResponse newsResponse;
    String API_KEY = "176ef08c9d384ca084d7418c34cda295";
    private String searchPhrase, language, sortBy;

    public String execute() throws Exception {

        String format = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String currentDate = dateFormat.format(calendar.getTime());
        try {

            URL url = new URL("https://newsapi.org/v2/everything?q=+" +getSearchPhrase() + "&searchIn=title,description&language="+getLanguage()+"&sortBy="+ getSortBy() +"&from=" + currentDate
                    + "&apiKey=" + API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                newsResponse = mapper.readValue(output, NewsResponse.class);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    
    public String getSearchPhrase() {
        return searchPhrase;
    }

    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public NewsResponse getNewsResponse() {
        return newsResponse;
    }


    public void setNewsResponse(NewsResponse newsResponse) {
        this.newsResponse = newsResponse;
    }


    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAPI_KEY() {
        return API_KEY;
    }
    public void setAPI_KEY(String aPI_KEY) {
        API_KEY = aPI_KEY;
    }

    
}
