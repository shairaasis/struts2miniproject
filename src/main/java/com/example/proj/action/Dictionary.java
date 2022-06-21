package com.example.proj.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import com.example.proj.model.DictionaryResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.opensymphony.xwork2.ActionSupport;

public class Dictionary extends ActionSupport{
    DictionaryResponse dictionaryResponse;
    public String execute() throws Exception {
        URL url = new URL("https://wordsapiv1.p.rapidapi.com/words/incredible/definitions/?rapidapi-key=8e5fc8ca86mshebf74458f8359fap1bbbabjsn71215df7915c");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.println("Output from server ....\n");
        String output;

        while ((output = br.readLine()) != null) {
            ObjectMapper mapper = new ObjectMapper();
            dictionaryResponse = mapper.readValue(output, DictionaryResponse.class);
        }
    return SUCCESS;

    // HttpResponse<String> response = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/incredible/definitions&apiKey=8e5fc8ca86mshebf74458f8359fap1bbbabjsn71215df7915c")
	// .header("X-RapidAPI-Key", "8e5fc8ca86mshebf74458f8359fap1bbbabjsn71215df7915c")
	// .header("X-RapidAPI-Host", "wordsapiv1.p.rapidapi.com")
	// .asString();
    
    //OkHttpClient client = new OkHttpClient();

// Request response = new Request.Builder()
// 	.url("https://wordsapiv1.p.rapidapi.com/words/incredible/definitions")
// 	.get()
// 	.addHeader("X-RapidAPI-Key", "8e5fc8ca86mshebf74458f8359fap1bbbabjsn71215df7915c")
// 	.addHeader("X-RapidAPI-Host", "wordsapiv1.p.rapidapi.com")
// 	.build();

// Response response = client.newCall(request).execute();
    

}
}