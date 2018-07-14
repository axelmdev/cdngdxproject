package com.ffg.Models;

/**
 * Created by edern on 07/07/2018.
 */

public class Skill {
    private String mongoID;
    private String activeCharacterMongoID;
    private String name;
    private int damage;

    public static String GetNameUrlVersion(){
        return "Skills";
    }

    public String getMongoID() {
        return mongoID;
    }

    public void setMongoID(String mongoID) {
        this.mongoID = mongoID;
    }

    public String getActiveCharacterMongoID() {
        return activeCharacterMongoID;
    }

    public void setActiveCharacterMongoID(String activeCharacterMongoID) {
        this.activeCharacterMongoID = activeCharacterMongoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
