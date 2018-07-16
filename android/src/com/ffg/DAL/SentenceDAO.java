package com.ffg.DAL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ffg.Models.Sentence;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class SentenceDAO implements BaseDAO<Sentence> {
    public static final String TABLE_NAME = "sentence_table";
    public static final String COL_ID = "id_sentence";
    public static final String COL_CONTENT = "content";
    public static final String COL_MONGOID = "mongoID";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_CONTENT+" TEXT,"+COL_MONGOID+" TEXT)";
        return query;
    }

    @Override
    public void Insert(Sentence itemToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CONTENT,itemToInsert.getContent());
        contentValues.put(COL_MONGOID,itemToInsert.getMongoID());
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            System.out.println("[FAILED]Insertion Sentence : " + itemToInsert.getLiteID());
        else
            System.out.println("Insertion Sentence : " + itemToInsert.getLiteID());
    }

    @Override
    public void InsertMany(ArrayList<Sentence> itemsToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        // Bulk Insert
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            for (Sentence s :itemsToInsert) {
                contentValues.put(COL_CONTENT,s.getContent());
                contentValues.put(COL_MONGOID,s.getMongoID());
                db.insert(TABLE_NAME,null,contentValues);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public Sentence SelectOne(String id, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE "+ COL_ID + " = '" + id +"'",null);
        if (res.moveToFirst()) {
            Sentence result = new Sentence();
            //Id
            result.setLiteID(res.getInt(0));
            //Content
            result.setContent(res.getString(1));
            //MongoId
            result.setMongoID(res.getString(2));
            return result;
        }
        else
            return null;
    }

    @Override
    public ArrayList<Sentence> SelectMany(DBHelper dbContext) {
        ArrayList<Sentence> allSentences = new ArrayList<>();
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if (res.moveToFirst()) {
            while (!res.isAfterLast()) {
                Sentence result = new Sentence();
                //Id
                result.setLiteID(res.getInt(0));
                //Content
                result.setContent(res.getString(1));
                //MongoId
                result.setMongoID(res.getString(2));

                allSentences.add(result);
                res.moveToNext();
            }
            return allSentences;
        }
        return null;
    }


    public static ArrayList<Sentence> SelectManyFromCharacter(String id,DBHelper dbContext) {
        ArrayList<Sentence> allSentences = new ArrayList<>();
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT ("+COL_ID+","+COL_CONTENT+","+COL_MONGOID+") FROM "+TABLE_NAME + " INNER JOIN " + DBHelper.SENTENCELINKTABLE_NAME + " ON " + DBHelper.SENTENCELINKTABLE_NAME+"."
                +DBHelper.COL_IDSENT + " = " + COL_ID + " WHERE " + DBHelper.SENTENCELINKTABLE_NAME+"."
                +DBHelper.COL_IDCHAR + " = " + id,null);
        if (res.moveToFirst()) {
            while (!res.isAfterLast()) {
                Sentence result = new Sentence();
                //Id
                result.setLiteID(res.getInt(0));
                //Content
                result.setContent(res.getString(1));
                //MongoId
                result.setMongoID(res.getString(2));

                allSentences.add(result);
                res.moveToNext();
            }
            return allSentences;
        }
        return null;
    }

    @Override
    public void Update(Sentence itemToUpdate, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_CONTENT,itemToUpdate.getContent());
        cv.put(COL_MONGOID,itemToUpdate.getMongoID());
        db.update(TABLE_NAME, cv, COL_ID+"=?", new String[]{(itemToUpdate.getLiteID().toString())});
    }

    @Override
    public void UpdateMany(ArrayList<Sentence> itemToUpdate, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            for (Sentence s : itemToUpdate) {
                cv.put(COL_CONTENT,s.getContent());
                cv.put(COL_MONGOID,s.getMongoID());
                db.update(TABLE_NAME, cv, COL_ID+"=?", new String[]{(s.getLiteID().toString())});
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void DeleteOne(Sentence itemToDelete, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.delete(TABLE_NAME,COL_ID+"=?",new String[]{itemToDelete.getLiteID().toString()});
    }

    @Override
    public void DeleteMany(ArrayList<Sentence> itemsToDelete, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.beginTransaction();
        try {
            for (Sentence s : itemsToDelete) {
                db.delete(TABLE_NAME,COL_ID+"=?",new String[]{s.getLiteID().toString()});
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }
}
