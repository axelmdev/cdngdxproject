package com.ffg.DAL;

import com.ffg.Models.ActiveCharacter;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class ActiveCharacterDAO implements BaseDAO<ActiveCharacter> {
    public static final String TABLE_NAME = "activeCharacter_table";
    public static final String COL_ID = CharacterDAO.COL_ID;
    public static final String COL_lEVEL = "level";
    public static final String COL_STATSLIFE = "statsLife";
    public static final String COL_STATSATTACK = "statsAttack";
    public static final String COL_STATSDEFENSE = "statsDefense";
    public static final String COL_EXPERIENCE = "experience";
    public static final String COL_NAME = "name";
    public static final String COL_MONGOID = "mongoID";
    public static final String COL_IDGAME = "id_game";
    public static final String COL_IDCASE = "id_case";
    public static final String COL_IDCHAR = "id_char";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_lEVEL+" INTEGER NOT NULL,"+COL_STATSLIFE+" INTEGER NOT NULL,"
                +COL_STATSATTACK+" INTEGER NOT NULL,"+COL_STATSDEFENSE+" INTEGER NOT NULL,"+COL_EXPERIENCE+" INTEGER NOT NULL,"+COL_NAME+" TEXT NOT NULL,"+COL_MONGOID+" TEXT NOT NULL,"
                +COL_IDGAME+" INTEGER NOT NULL,"+COL_IDCASE+" INTEGER NOT NULL,"+ COL_IDCHAR +" INTEGER NOT NULL";
        query += ",CONSTRAINT ActiveCharacter_PK PRIMARY KEY ("+COL_ID+")";
        query += ",CONSTRAINT ActiveCharacter_Character_FK FOREIGN KEY ("+COL_IDCHAR+") REFERENCES Character("+CharacterDAO.COL_ID+")";
        query += ",CONSTRAINT ActiveCharacter_Game0_FK FOREIGN KEY ("+COL_IDGAME+") REFERENCES Game("+GameDAO.COL_ID+")";
        query += ",CONSTRAINT ActiveCharacter_Case1_FK FOREIGN KEY ("+COL_IDCASE+") REFERENCES Case("+CaseDAO.COL_ID+")";
        query += ",CONSTRAINT ActiveCharacter_Game2_FK FOREIGN KEY ("+COL_IDCHAR+") REFERENCES Game("+GameDAO.COL_ID+")";
        query += ",CONSTRAINT ActiveCharacter_Case_AK UNIQUE ("+COL_IDCASE+")";
        return query;
    }

    @Override
    public void Insert(ActiveCharacter itemToInsert) {

    }

    @Override
    public void InsertMany(ArrayList itemsToInsert) {

    }

    @Override
    public ActiveCharacter SelectOne(ArrayList parameters) {
        return null;
    }

    @Override
    public ArrayList SelectMany(ArrayList parameters) {
        return null;
    }

    @Override
    public void Update(ActiveCharacter itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList itemToUpdate) {

    }

    @Override
    public void DeleteOne(ActiveCharacter itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList itemsToDelete) {

    }
}
