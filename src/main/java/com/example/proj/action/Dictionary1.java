package com.example.proj.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.stream.Collectors;

import com.example.proj.model.DictionaryResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class Dictionary1 extends ActionSupport{
    
    DictionaryResponse dictionaryResponse;
    String API_KEY = "8e5fc8ca86mshebf74458f8359fap1bbbabjsn71215df7915c";

    public String execute() throws Exception {
    String format = "yyyy-MM-dd";
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    String currentDate = dateFormat.format(calendar.getTime());
    try {

        URL url = new URL("https://wordsapiv1.p.rapidapi.com/words/incredible/?rapidapi-key=8e5fc8ca86mshebf74458f8359fap1bbbabjsn71215df7915c");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        output =  br.lines().collect(Collectors.joining());
        dictionaryResponse = mapper.readValue(output, DictionaryResponse.class);
        System.out.println("Word and definition: ..."+ dictionaryResponse.getWord()+ dictionaryResponse.getResults());
        // BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        // String output;
        // while ((output = br.readLine()) != null) {
        //     ObjectMapper mapper = new ObjectMapper();
        //     dictionaryResponse = mapper.readValue(output, DictionaryResponse.class);
        // }
        conn.disconnect();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return SUCCESS;
    }

    public DictionaryResponse getDictionaryResponse() {
        return dictionaryResponse;
    }

    public void setDictionaryResponse(DictionaryResponse dictionaryResponse) {
        this.dictionaryResponse = dictionaryResponse;
    }

    public String getAPI_KEY() {
        return API_KEY;
    }

    public void setAPI_KEY(String aPI_KEY) {
        API_KEY = aPI_KEY;
    }

    
}
