package com.example.proj.model;

import java.util.ArrayList;

public class DictionaryResponse {
    String word;
    ArrayList <Definition> definitions;
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public ArrayList<Definition> getDefinitions() {
        return definitions;
    }
    public void setDefinitions(ArrayList<Definition> definitions) {
        this.definitions = definitions;
    }
    
}
