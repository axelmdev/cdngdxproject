package com.ffg.Models;

import java.util.ArrayList;

/**
 * Created by edern on 07/07/2018.
 */

public class Map {
    private String mongoID;
    private String gameMongoID;
    private String name;
    private ArrayList<Case> caseList;

    public static String GetNameUrlVersion(){
        return "Maps";
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
