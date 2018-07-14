package com.ffg.Models;

/**
 * Created by edern on 07/07/2018.
 */

public class Sentence {
    private String mongoID;
    private String characterMongoID;
    private String content;

    public static String GetNameUrlVersion(){
        return "Sentences";
    }

    public String getMongoID() {
        return mongoID;
    }

    public void setMongoID(String mongoID) {
        this.mongoID = mongoID;
    }

    public String getCharacterMongoID() {
        return characterMongoID;
    }

    public void setCharacterMongoID(String characterMongoID) {
        this.characterMongoID = characterMongoID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
