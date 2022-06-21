package com.example.proj.model;

import java.util.ArrayList;

import com.example.proj.model.Results.Pronunciation;
// import com.example.proj.model.Results.Syllables;

public class DictionaryResponse {
    String word;
    ArrayList <Results> results = new ArrayList<Results>();
    // Syllables syllables;
    // public DictionaryResponse(Syllables syllables) {
    //     this.syllables = syllables;
    // }
    //Pronunciation pronunciation;

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    // public ArrayList<Definition> getDefinitions() {
    //     return definitions;
    // }
    // public void setDefinitions(ArrayList<Definition> definitions) {
    //     this.definitions = definitions;
    // }
    public ArrayList<Results> getResults() {
        return results;
    }
    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }
    // public Syllables getSyllables() {
    //     return syllables;
    // }
    // public void setSyllables(Syllables syllables) {
    //     this.syllables = syllables;
    // }
    // public Pronunciation getPronunciation() {
    //     return pronunciation;
    // }
    // public void setPronunciation(Pronunciation pronunciation) {
    //     this.pronunciation = pronunciation;
    // }
    
    
}
