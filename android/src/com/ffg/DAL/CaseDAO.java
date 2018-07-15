package com.ffg.DAL;

import com.ffg.Models.Case;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class CaseDAO implements BaseDAO<Case> {
    public static final String TABLE_NAME = "case_table";
    public static final String COL_ID = "id_case";
    public static final String COL_USABLE = "usable";
    public static final String COL_IMAGE = "image";
    public static final String COL_IDMAP = "id_map";
    public static final String COL_IDCHAR = "id_char";
    public static final String COL_MONGOID = "mongoID";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_USABLE+" INTEGER,"+COL_IMAGE +" TEXT"+COL_MONGOID+" TEXT,"+COL_IDMAP+" INTEGER NOT NULL"+COL_IDCHAR+" INTEGER NOT NULL";
        query += ",CONSTRAINT Case_Map_FK FOREIGN KEY ("+COL_IDMAP+") REFERENCES Map("+MapDAO.COL_ID+")";
        query += ",CONSTRAINT Case_Character0_FK FOREIGN KEY ("+COL_IDCHAR+") REFERENCES Character("+CharacterDAO.COL_ID+")";
        query += ",CONSTRAINT Case_Character_AK UNIQUE ("+COL_IDCHAR+")";
        return query;
    }

    @Override
    public void Insert(Case itemToInsert) {

    }

    @Override
    public void InsertMany(ArrayList<Case> itemsToInsert) {

    }

    @Override
    public Case SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Case> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Case itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Case> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Case itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Case> itemsToDelete) {

    }
}
