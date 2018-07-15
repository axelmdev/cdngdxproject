package com.ffg.DAL;

import com.ffg.Models.Map;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class MapDAO implements BaseDAO<Map> {
    public static final String TABLE_NAME = "map_table";
    public static final String COL_ID = "id_map";
    public static final String COL_NAME = "name";
    public static final String COL_MONGOID = "mongoID";
    public static final String COL_IDGAME = "id_game";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_NAME+" TEXT,"+COL_MONGOID+" TEXT,"+COL_IDGAME+" INTEGER NOT NULL ";
        query += ",CONSTRAINT Map_Game_FK FOREIGN KEY ("+COL_IDGAME+") REFERENCES Game("+GameDAO.COL_ID+")";
        return query;
    }

    @Override
    public void Insert(Map itemToInsert) {

    }

    @Override
    public void InsertMany(ArrayList<Map> itemsToInsert) {

    }

    @Override
    public Map SelectOne(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public ArrayList<Map> SelectMany(ArrayList<String> parameters) {
        return null;
    }

    @Override
    public void Update(Map itemToUpdate) {

    }

    @Override
    public void UpdateMany(ArrayList<Map> itemToUpdate) {

    }

    @Override
    public void DeleteOne(Map itemToDelete) {

    }

    @Override
    public void DeleteMany(ArrayList<Map> itemsToDelete) {

    }
}
