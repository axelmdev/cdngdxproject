package com.ffg.DAL;

import com.ffg.Models.Skill;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class SkillDAO implements BaseDAO<Skill> {
    public static final String TABLE_NAME = "skill_table";
    public static final String COL_ID = "id_skill";
    public static final String COL_NAME = "name";
    public static final String COL_DAMAGE = "damage";
    public static final String COL_MONGOID = "mongoID";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_NAME+" TEXT, "+COL_DAMAGE+" INTEGER, "+COL_MONGOID+" TEXT NOT NULL)";
        return query;
    }

    @Override
    public void Insert(Skill itemToInsert) {

    }

    @Override
    public void InsertMany(ArrayList<Skill> itemsToInsert) {

    }

    @Override
    public Skill SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Skill> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Skill itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Skill> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Skill itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Skill> itemsToDelete) {

    }
}
