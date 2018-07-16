package com.ffg.DAL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ffg.Models.Case;
import com.ffg.Models.Map;

import java.util.ArrayList;

import fr.imie.ena.fightforgrades.character.Player;

/**
 * Created by edern on 12/07/2018.
 */

public class MapDAO implements BaseDAO<Map> {
    public static final String TABLE_NAME = "map_table";
    public static final String COL_ID = "id_map";
    public static final String COL_NAME = "name";
    public static final String COL_MONGOID = "mongoID";
    public static final String COL_IDGAME = "id_game";
    public static final String COL_MONGOIDGAME = "mongoID_game";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_NAME+" TEXT,"+COL_MONGOID+" TEXT,"+COL_IDGAME+" INTEGER NOT NULL "+COL_MONGOIDGAME+" TEXT NULL ";
        query += ",CONSTRAINT Map_Game_FK FOREIGN KEY ("+COL_IDGAME+") REFERENCES Game("+GameDAO.COL_ID+")";
        return query;
    }

    @Override
    public void Insert(Map itemToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,itemToInsert.getName());
        contentValues.put(COL_MONGOID,itemToInsert.getMongoID());
        contentValues.put(COL_IDGAME,itemToInsert.getGameLiteID());
        contentValues.put(COL_MONGOIDGAME,itemToInsert.getGameMongoID());
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            System.out.println("[FAILED]Insertion Sentence : " + itemToInsert.getLiteID());
        else
            System.out.println("Insertion Sentence : " + itemToInsert.getLiteID());
    }

    @Override
    public void InsertMany(ArrayList<Map> itemsToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        // Bulk Insert
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            for (Map m :itemsToInsert) {
                contentValues.put(COL_NAME,m.getName());
                contentValues.put(COL_MONGOID,m.getMongoID());
                contentValues.put(COL_IDGAME,m.getGameLiteID());
                contentValues.put(COL_MONGOIDGAME,m.getGameMongoID());
                db.insert(TABLE_NAME,null,contentValues);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public Map SelectOne(String id, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE "+ COL_ID + " = '" + id +"'",null);
        if (res.moveToFirst()) {
            Map result = new Map();
            //Id
            result.setLiteID(res.getInt(0));
            //Name
            result.setName(res.getString(1));
            //MongoId
            result.setMongoID(res.getString(2));
            //GameId
            result.setGameLiteID(res.getInt(3));
            //MongoId
            result.setGameMongoID(res.getString(4));

            result.setCaseList(CaseDAO.SelectManyFromMap(id,dbContext));
            return result;
        }
        else
            return null;
    }

    @Override
    public ArrayList<Map> SelectMany(DBHelper dbContext) {
        ArrayList<Map> allMaps = new ArrayList<>();
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if (res.moveToFirst()) {
            while (!res.isAfterLast()) {
                Map result = new Map();
                //Id
                result.setLiteID(res.getInt(0));
                //Name
                result.setName(res.getString(1));
                //MongoId
                result.setMongoID(res.getString(2));
                //GameId
                result.setGameLiteID(res.getInt(3));
                //MongoId
                result.setGameMongoID(res.getString(4));

                result.setCaseList(CaseDAO.SelectManyFromMap(result.getLiteID().toString(),dbContext));

                allMaps.add(result);
                res.moveToNext();
            }
            return allMaps;
        }
        return null;
    }

    @Override
    public void Update(Map itemToUpdate, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME,itemToUpdate.getName());
        cv.put(COL_MONGOID,itemToUpdate.getMongoID());
        cv.put(COL_IDGAME,itemToUpdate.getGameLiteID());
        cv.put(COL_MONGOIDGAME,itemToUpdate.getGameMongoID());
        db.update(TABLE_NAME, cv, COL_ID+"=?", new String[]{(itemToUpdate.getLiteID().toString())});

        CaseDAO caseDAO = new CaseDAO();
        caseDAO.UpdateMany(itemToUpdate.getCaseList(),dbContext);
    }

    @Override
    public void UpdateMany(ArrayList<Map> itemToUpdate, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        CaseDAO caseDAO = new CaseDAO();
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            for (Map m : itemToUpdate) {
                cv.put(COL_NAME,m.getName());
                cv.put(COL_MONGOID,m.getMongoID());
                cv.put(COL_IDGAME,m.getGameLiteID());
                cv.put(COL_MONGOIDGAME,m.getGameMongoID());
                db.update(TABLE_NAME, cv, COL_ID+"=?", new String[]{(m.getLiteID().toString())});
                caseDAO.UpdateMany(m.getCaseList(),dbContext);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void DeleteOne(Map itemToDelete, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.delete(TABLE_NAME,COL_ID+"=?",new String[]{itemToDelete.getLiteID().toString()});
    }

    @Override
    public void DeleteMany(ArrayList<Map> itemsToDelete, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.beginTransaction();
        try {
            for (Map m : itemsToDelete) {
                db.delete(TABLE_NAME,COL_ID+"=?",new String[]{m.getLiteID().toString()});
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }
}
