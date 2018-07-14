package com.ffg.Models;

import java.util.ArrayList;

/**
 * Created by edern on 07/07/2018.
 */

public class ActiveCharacter extends Character {
    private String mongoID;
    private String gameMongoID;
    private int level;
    private int statsLife;
    private int statsAttack;
    private int statsDefense;
    private int currentLife;
    private int currentAttack;
    private int currentDefense;
    private int experience;
    private ArrayList<Skill> skillList;

    public static String GetNameUrlVersion(){
        return "ActiveCharacters";
    }

    @Override
    public String getMongoID() {
        return mongoID;
    }

    @Override
    public void setMongoID(String mongoID) {
        this.mongoID = mongoID;
    }

    @Override
    public String getGameMongoID() {
        return gameMongoID;
    }

    @Override
    public void setGameMongoID(String gameMongoID) {
        this.gameMongoID = gameMongoID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatsLife() {
        return statsLife;
    }

    public void setStatsLife(int statsLife) {
        this.statsLife = statsLife;
    }

    public int getStatsAttack() {
        return statsAttack;
    }

    public void setStatsAttack(int statsAttack) {
        this.statsAttack = statsAttack;
    }

    public int getStatsDefense() {
        return statsDefense;
    }

    public void setStatsDefense(int statsDefense) {
        this.statsDefense = statsDefense;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    public int getCurrentAttack() {
        return currentAttack;
    }

    public void setCurrentAttack(int currentAttack) {
        this.currentAttack = currentAttack;
    }

    public int getCurrentDefense() {
        return currentDefense;
    }

    public void setCurrentDefense(int currentDefense) {
        this.currentDefense = currentDefense;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }
}
