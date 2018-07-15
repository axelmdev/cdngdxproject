package com.ffg.DAL;

import com.ffg.Models.Character;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class CharacterDAO implements BaseDAO<Character> {
    public static final String TABLE_NAME = "character_table";
    public static final String COL_ID = "id_char";
    public static final String COL_NAME = "name";
    public static final String COL_IDCASE = "id_case";
    public static final String COL_IDGAME = "id_game";
    public static final String COL_MONGOID = "mongoID";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_NAME+" TEXT NOT NULL,"+COL_MONGOID+" TEXT,"+COL_IDCASE+" INTEGER NOT NULL"+COL_IDGAME+" INTEGER NOT NULL";
        query += ",CONSTRAINT Character_Case_FK FOREIGN KEY ("+COL_IDCASE+") REFERENCES Case("+CaseDAO.COL_ID+")";
        query += ",CONSTRAINT Character_Game0_FK FOREIGN KEY ("+COL_IDGAME+") REFERENCES Game("+GameDAO.COL_ID+")";
        query += ",CONSTRAINT Character_Case_AK UNIQUE ("+COL_IDCASE+")";
        return query;
    }
    @Override
    public void Insert(Character itemToInsert) {

    }

    @Override
    public void InsertMany(ArrayList<Character> itemsToInsert) {

    }

    @Override
    public Character SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Character> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Character itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Character> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Character itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Character> itemsToDelete) {

    }
}
