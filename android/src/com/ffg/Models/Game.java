package com.ffg.Models;

import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by edern on 07/07/2018.
 */

public class Game {
    private String mongoID;
    private String accountMongoID;
    private ArrayList<Map> mapList;
    private ArrayList<Character> characterList;
    private ArrayList<ActiveCharacter> activeCharacterList;

    public static String GetNameUrlVersion(){
        return "Games";
    }

    public String getMongoID() {
        return mongoID;
    }

    public void setMongoID(String mongoID) {
        this.mongoID = mongoID;
    }

    public String getAccountMongoID() {
        return accountMongoID;
    }

    public void setAccountMongoID(String accountMongoID) {
        this.accountMongoID = accountMongoID;
    }

    public ArrayList<Map> getMapList() {
        return mapList;
    }

    public void setMapList(ArrayList<Map> mapList) {
        this.mapList = mapList;
    }

    public ArrayList<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(ArrayList<Character> characterList) {
        this.characterList = characterList;
    }

    public ArrayList<ActiveCharacter> getActiveCharacterList() {
        return activeCharacterList;
    }

    public void setActiveCharacterList(ArrayList<ActiveCharacter> activeCharacterList) {
        this.activeCharacterList = activeCharacterList;
    }
}
