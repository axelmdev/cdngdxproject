package com.ffg.Models;

import java.util.ArrayList;

/**
 * Created by edern on 07/07/2018.
 */

public class Map {
    private Integer liteID;
    private Integer gameLiteID;
    private String mongoID;
    private String gameMongoID;
    private String name;
    private ArrayList<Case> caseList;

    public static String GetNameUrlVersion(){
        return "Maps";
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

    public ArrayList<Case> getCaseList() {
        return caseList;
    }

    public void setCaseList(ArrayList<Case> caseList) {
        this.caseList = caseList;
    }
}
