package com.ffg.Models;

import java.util.ArrayList;

/**
 * Created by edern on 07/07/2018.
 */

public class ActiveCharacter extends Character {
    private Integer liteID;
    private Integer gameLiteID;
    private String gameMongoID;
    private Integer charLiteID;
    private String charMongoID;
    private Integer caseLiteID;
    private Integer level;
    private Integer statsLife;
    private Integer statsAttack;
    private Integer statsDefense;
    private Integer currentLife;
    private Integer currentAttack;
    private Integer currentDefense;
    private Integer experience;
    private ArrayList<Skill> skillList;

    public static String GetNameUrlVersion(){
        return "ActiveCharacters";
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

    @Override
    public String getGameMongoID() {
        return gameMongoID;
    }

    @Override
    public void setGameMongoID(String gameMongoID) {
        this.gameMongoID = gameMongoID;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatsLife() {
        return statsLife;
    }

    public void setStatsLife(Integer statsLife) {
        this.statsLife = statsLife;
    }

    public Integer getStatsAttack() {
        return statsAttack;
    }

    public void setStatsAttack(Integer statsAttack) {
        this.statsAttack = statsAttack;
    }

    public Integer getStatsDefense() {
        return statsDefense;
    }

    public void setStatsDefense(Integer statsDefense) {
        this.statsDefense = statsDefense;
    }

    public Integer getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(Integer currentLife) {
        this.currentLife = currentLife;
    }

    public Integer getCurrentAttack() {
        return currentAttack;
    }

    public void setCurrentAttack(Integer currentAttack) {
        this.currentAttack = currentAttack;
    }

    public Integer getCurrentDefense() {
        return currentDefense;
    }

    public void setCurrentDefense(Integer currentDefense) {
        this.currentDefense = currentDefense;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }

    public Integer getCharLiteID() {
        return charLiteID;
    }

    public void setCharLiteID(Integer charLiteID) {
        this.charLiteID = charLiteID;
    }

    public String getCharMongoID() {
        return charMongoID;
    }

    public void setCharMongoID(String charMongoID) {
        this.charMongoID = charMongoID;
    }

    public Integer getCaseLiteID() {
        return caseLiteID;
    }

    public void setCaseLiteID(Integer caseLiteID) {
        this.caseLiteID = caseLiteID;
    }
}
