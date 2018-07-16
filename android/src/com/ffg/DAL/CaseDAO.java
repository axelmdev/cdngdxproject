package com.ffg.DAL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
    public static final String COL_MONGOIDMAP = "mongoID_map";
    public static final String COL_IDCHAR = "id_char";
    public static final String COL_MONGOIDCHAR = "mongoID_char";
    public static final String COL_MONGOID = "mongoID";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_USABLE+" INTEGER,"+COL_IMAGE +" TEXT"+COL_MONGOID+" TEXT,"+COL_IDMAP+" INTEGER NOT NULL,"+COL_MONGOIDMAP +" TEXT,"
                +COL_IDCHAR+" INTEGER,"+COL_MONGOIDCHAR+" TEXT";
        query += ",CONSTRAINT Case_Map_FK FOREIGN KEY ("+COL_IDMAP+") REFERENCES Map("+MapDAO.COL_ID+")";
        query += ",CONSTRAINT Case_Character0_FK FOREIGN KEY ("+COL_IDCHAR+") REFERENCES Character("+CharacterDAO.COL_ID+")";
        query += ",CONSTRAINT Case_Character_AK UNIQUE ("+COL_IDCHAR+")";
        return query;
    }

    @Override
    public void Insert(Case itemToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USABLE,itemToInsert.getUsable());
        contentValues.put(COL_IMAGE,itemToInsert.getImg());
        contentValues.put(COL_IDMAP,itemToInsert.getMapLiteID());
        if (!itemToInsert.getCharMongoID().isEmpty())
            contentValues.put(COL_IDCHAR,itemToInsert.getCharMongoID());
        if (itemToInsert.getCharLiteID() != null)
            contentValues.put(COL_IDCHAR,itemToInsert.getCharMongoID());
        contentValues.put(COL_MONGOID,itemToInsert.getMongoID());
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            System.out.println("[FAILED]Insertion Case : " + itemToInsert.getLiteID());
        else
            System.out.println("Insertion Case : " + itemToInsert.getLiteID());
    }

    @Override
    public void InsertMany(ArrayList<Case> itemsToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        // Bulk Insert
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            for (Case c :itemsToInsert) {
                contentValues.put(COL_USABLE,c.getUsable());
                contentValues.put(COL_IMAGE,c.getImg());
                contentValues.put(COL_IDMAP,c.getMapLiteID());
                if (!c.getCharMongoID().isEmpty())
                    contentValues.put(COL_IDCHAR,c.getCharMongoID());
                if (c.getCharLiteID() != null)
                    contentValues.put(COL_IDCHAR,c.getCharMongoID());
                contentValues.put(COL_MONGOID,c.getMongoID());
                db.insert(TABLE_NAME,null,contentValues);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public Case SelectOne(String id, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE "+ COL_ID + " = '" + id +"'",null);
        if (res.moveToFirst()) {
            Case result = new Case();
            //Id
            result.setLiteID(res.getInt(0));
            //Usable
            int usable =  res.getInt(1);
            result.setUsable(usable == 0 ? true : false);
            // Img
            result.setImg(res.getString(2));
            //MongoId
            result.setMongoID(res.getString(3));
            // MAPID
            result.setMapLiteID(res.getInt(4));
            // MAPMONGOID
            result.setMapMongoID(res.getString(5));
            // CHARID
            if (res.getInt(6) >= 0)
                result.setCharLiteID(res.getInt(6));
            // CHARMONGOID
            if (res.getInt(7) >= 0)
                result.setCharMongoID(res.getString(7));

            return result;
        }
        else
            return null;
    }

    @Override
    public ArrayList<Case> SelectMany(DBHelper dbContext) {
        ArrayList<Case> allCases = new ArrayList<>();
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if (res.moveToFirst()) {
            while (!res.isAfterLast()) {
                Case result = new Case();
                //Id
                result.setLiteID(res.getInt(0));
                //Usable
                int usable =  res.getInt(1);
                result.setUsable(usable == 0 ? true : false);
                // Img
                result.setImg(res.getString(2));
                //MongoId
                result.setMongoID(res.getString(3));
                // MAPID
                result.setMapLiteID(res.getInt(4));
                // MAPMONGOID
                result.setMapMongoID(res.getString(5));
                // CHARID
                if (res.getInt(6) >= 0)
                    result.setCharLiteID(res.getInt(6));
                // CHARMONGOID
                if (res.getInt(7) >= 0)
                    result.setCharMongoID(res.getString(7));

                allCases.add(result);
                res.moveToNext();
            }
            return allCases;
        }
        return null;
    }

    public static ArrayList<Case> SelectManyFromMap(String MapID,DBHelper dbContext) {
        ArrayList<Case> allCases = new ArrayList<>();
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+COL_IDMAP+" = " +MapID,null);
        if (res.moveToFirst()) {
            while (!res.isAfterLast()) {
                Case result = new Case();
                //Id
                result.setLiteID(res.getInt(0));
                //Usable
                int usable =  res.getInt(1);
                result.setUsable(usable == 0 ? true : false);
                // Img
                result.setImg(res.getString(2));
                //MongoId
                result.setMongoID(res.getString(3));
                // MAPID
                result.setMapLiteID(res.getInt(4));
                // MAPMONGOID
                result.setMapMongoID(res.getString(5));
                // CHARID
                if (res.getInt(6) >= 0)
                    result.setCharLiteID(res.getInt(6));
                // CHARMONGOID
                if (res.getInt(7) >= 0)
                    result.setCharMongoID(res.getString(7));

                allCases.add(result);
                res.moveToNext();
            }
            return allCases;
        }
        return null;
    }

    @Override
    public void Update(Case itemToUpdate, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_USABLE,itemToUpdate.getUsable());
        cv.put(COL_IMAGE,itemToUpdate.getImg());
        cv.put(COL_IDMAP,itemToUpdate.getMapLiteID());
        cv.put(COL_MONGOIDMAP,itemToUpdate.getMapMongoID());
        cv.put(COL_IDCHAR,itemToUpdate.getCharLiteID());
        cv.put(COL_MONGOIDCHAR,itemToUpdate.getCharMongoID());
        cv.put(COL_MONGOID,itemToUpdate.getMongoID());
        db.update(TABLE_NAME, cv, COL_ID+"=?", new String[]{(itemToUpdate.getLiteID().toString())});
    }

    @Override
    public void UpdateMany(ArrayList<Case> itemToUpdate, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            for (Case c : itemToUpdate) {
                cv.put(COL_USABLE,c.getUsable());
                cv.put(COL_IMAGE,c.getImg());
                cv.put(COL_IDMAP,c.getMapLiteID());
                cv.put(COL_MONGOIDMAP,c.getMapMongoID());
                cv.put(COL_IDCHAR,c.getCharLiteID());
                cv.put(COL_MONGOIDCHAR,c.getCharMongoID());
                cv.put(COL_MONGOID,c.getMongoID());
                db.update(TABLE_NAME, cv, COL_ID+"=?", new String[]{(c.getLiteID().toString())});
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void DeleteOne(Case itemToDelete, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.delete(TABLE_NAME,COL_ID+"=?",new String[]{itemToDelete.getLiteID().toString()});
    }

    @Override
    public void DeleteMany(ArrayList<Case> itemsToDelete, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.beginTransaction();
        try {
            for (Case c : itemsToDelete) {
                db.delete(TABLE_NAME,COL_ID+"=?",new String[]{c.getLiteID().toString()});
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }
}
