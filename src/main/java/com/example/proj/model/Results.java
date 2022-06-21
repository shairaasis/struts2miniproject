package com.example.proj.model;

import java.util.ArrayList;

public class Results {
    String definition;
    String partOfSpeech;
    ArrayList <String> synonyms;
    ArrayList <String> attribute;
    ArrayList <String> similarTo;
    ArrayList <String> antonyms;
    ArrayList <String> derivation;
    ArrayList <String> examples;

    // public class Syllables{
    //     int counts;
    //     ArrayList <String> list;

    //     public int getCounts() {
    //         return counts;
    //     }
    //     public void setCounts(int counts) {
    //         this.counts = counts;
    //     }
    //     public ArrayList<String> getList() {
    //         return list;
    //     }
    //     public void setList(ArrayList<String> list) {
    //         this.list = list;
    //     }
    // }

    public class Pronunciation{
        String all;

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }
        
    }
    
    public String getDefinition() {
        return definition;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }
    public String getPartOfSpeech() {
        return partOfSpeech;
    }
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }
    public ArrayList<String> getSynonyms() {
        return synonyms;
    }
    public void setSynonyms(ArrayList<String> synonyms) {
        this.synonyms = synonyms;
    }
    public ArrayList<String> getAttribute() {
        return attribute;
    }
    public void setAttribute(ArrayList<String> attribute) {
        this.attribute = attribute;
    }
    public ArrayList<String> getSimilarTo() {
        return similarTo;
    }
    public void setSimilarTo(ArrayList<String> similarTo) {
        this.similarTo = similarTo;
    }
    public ArrayList<String> getAntonyms() {
        return antonyms;
    }
    public void setAntonyms(ArrayList<String> antonyms) {
        this.antonyms = antonyms;
    }
    public ArrayList<String> getDerivation() {
        return derivation;
    }
    public void setDerivation(ArrayList<String> derivation) {
        this.derivation = derivation;
    }
    public ArrayList<String> getExamples() {
        return examples;
    }
    public void setExamples(ArrayList<String> examples) {
        this.examples = examples;
    }

    
}