package com.ffg.Models;

import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;

/**
 * Created by edern on 07/07/2018.
 */

public class Character {

    private String name;
    private ArrayList<Sentence> sentenceList;

    public static String GetNameUrlVersion(){
        return "Characters";
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
