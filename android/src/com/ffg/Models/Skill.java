package com.ffg.Models;

/**
 * Created by edern on 07/07/2018.
 */

public class Skill {
    private String name;
    private int damage;

    public static String GetNameUrlVersion(){
        return "Skills";
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
