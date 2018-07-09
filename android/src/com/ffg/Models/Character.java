package com.ffg.Models;

import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;

/**
 * Created by edern on 07/07/2018.
 */

public class Character {
    private String name;
    private ArrayList<Sentence> sentenceList;

    public ArrayList<Sentence> getSentencesList() {
        return sentenceList;
    }

    public void setSentencesList(ArrayList<Sentence> sentencesList) {
        this.sentenceList = sentencesList;
    }
}
