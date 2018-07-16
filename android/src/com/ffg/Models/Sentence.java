package com.ffg.Models;

/**
 * Created by edern on 07/07/2018.
 */

public class Sentence {
    private Integer liteID;
    private String characterLiteID;
    private String mongoID;
    private String characterMongoID;
    private String content;

    public static String GetNameUrlVersion(){
        return "Sentences";
    }

    public Integer getLiteID() {
        return liteID;
    }

    public void setLiteID(Integer liteID) {
        this.liteID = liteID;
    }

    public String getCharacterLiteID() {
        return characterLiteID;
    }

    public void setCharacterLiteID(String characterLiteID) {
        this.characterLiteID = characterLiteID;
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
