package com.ffg.Models;

import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;

/**
 * Created by edern on 07/07/2018.
 */

public class Character {

    private int liteID;
    private String gameLiteID;
    private String mongoID;
    private String gameMongoID;
    private String name;
    private ArrayList<Sentence> sentenceList;

    public static String GetNameUrlVersion(){
        return "Characters";
    }

    public int getLiteID() {
        return liteID;
    }

    public void setLiteID(int liteID) {
        this.liteID = liteID;
    }

    public String getGameLiteID() {
        return gameLiteID;
    }

    public void setGameLiteID(String gameLiteID) {
        this.gameLiteID = gameLiteID;
    }

    public String getMongoID() {
        return mongoID;
    }

    public void setMongoID(String mongoID) {
        this.mongoID = mongoID;
    }

    public String getGameMongoID() {
        return gameMongoID;
    }

    public void setGameMongoID(String gameMongoID) {
        this.gameMongoID = gameMongoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(ArrayList<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }
}
