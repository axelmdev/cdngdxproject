package com.ffg.Models;

import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;

/**
 * Created by edern on 07/07/2018.
 */

public class Character {

    private Integer liteID;
    private Integer gameLiteID;
    private String mongoID;
    private String gameMongoID;
    private String name;
    private Integer id_case;
    private String mongoID_case;
    private ArrayList<Sentence> sentenceList;

    public static String GetNameUrlVersion(){
        return "Characters";
    }

    public Integer getLiteID() {
        return liteID;
    }

    public void setLiteID(Integer liteID) {
        this.liteID = liteID;
    }

    public Integer getGameLiteID() {
        return gameLiteID;
    }

    public void setGameLiteID(Integer gameLiteID) {
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

    public Integer getId_case() {
        return id_case;
    }

    public void setId_case(Integer id_case) {
        this.id_case = id_case;
    }

    public String getMongoID_case() {
        return mongoID_case;
    }

    public void setMongoID_case(String mongoID_case) {
        this.mongoID_case = mongoID_case;
    }

    public ArrayList<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(ArrayList<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }
}
