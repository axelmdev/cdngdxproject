package com.ffg.DAL;

import com.ffg.Models.Game;

import java.util.ArrayList;

/**
 * Created by edern on 10/07/2018.
 */

public class GameDAO implements BaseDAO<Game>
{
    public static final String TABLE_NAME = "game_table";
    public static final String COL_ID = "id_game";
    public static final String COL_MONGOID = "mongoID";
    public static final String COL_IDACC = "id_acc";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_MONGOID+" TEXT,"+COL_IDACC+" INTEGER NOT NULL";
        query += ",CONSTRAINT Game_Account_FK FOREIGN KEY ("+COL_IDACC+") REFERENCES Account("+AccountDAO.COL_ID+")";
        query += ",CONSTRAINT Game_Account_AK UNIQUE ("+COL_IDACC+")";
        return query;
    }

    @Override
    public void Insert(Game itemToInsert, DBHelper dbContext) {

    }

    @Override
    public void InsertMany(ArrayList<Game> itemsToInsert, DBHelper dbContext) {

    }

    @Override
    public Game SelectOne(String id, DBHelper dbContext) {
        return null;
    }

    @Override
    public ArrayList<Game> SelectMany(DBHelper dbContext) {
        return null;
    }

    @Override
    public void Update(Game itemToUpdate, DBHelper dbContext) {

    }

    @Override
    public void UpdateMany(ArrayList<Game> itemToUpdate, DBHelper dbContext) {

    }

    @Override
    public void DeleteOne(Game itemToDelete, DBHelper dbContext) {

    }

    @Override
    public void DeleteMany(ArrayList<Game> itemsToDelete, DBHelper dbContext) {

    }
}
