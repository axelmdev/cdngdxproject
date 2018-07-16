package com.ffg.DAL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
    public static final String COL_MONGOIDCASE = "mongoID_case";
    public static final String COL_IDGAME = "id_game";
    public static final String COL_MONGOIDGAME = "mongoID_game";
    public static final String COL_MONGOID = "mongoID";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_NAME+" TEXT NOT NULL,"+COL_MONGOID+" TEXT,"+COL_IDCASE+" INTEGER NOT NULL"+COL_MONGOIDCASE+" TEXT,"
                +COL_IDGAME+" INTEGER NOT NULL"+COL_MONGOIDGAME+" TEXT,";
        query += ",CONSTRAINT Character_Case_FK FOREIGN KEY ("+COL_IDCASE+") REFERENCES Case("+CaseDAO.COL_ID+")";
        query += ",CONSTRAINT Character_Game0_FK FOREIGN KEY ("+COL_IDGAME+") REFERENCES Game("+GameDAO.COL_ID+")";
        query += ",CONSTRAINT Character_Case_AK UNIQUE ("+COL_IDCASE+")";
        return query;
    }

    @Override
    public void Insert(Character itemToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,itemToInsert.getName());
        if (itemToInsert.getId_case() != null)
            contentValues.put(COL_IDCASE,itemToInsert.getId_case());
        if (!itemToInsert.getMongoID_case().isEmpty())
            contentValues.put(COL_MONGOIDCASE,itemToInsert.getMongoID_case());
        contentValues.put(COL_IDGAME,itemToInsert.getGameLiteID());
        contentValues.put(COL_MONGOIDGAME,itemToInsert.getGameMongoID());
        contentValues.put(COL_MONGOID,itemToInsert.getMongoID());
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            System.out.println("[FAILED]Insertion Sentence : " + itemToInsert.getLiteID());
        else
            System.out.println("Insertion Sentence : " + itemToInsert.getLiteID());
    }

    @Override
    public void InsertMany(ArrayList<Character> itemsToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        // Bulk Insert
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            for (Character c :itemsToInsert) {
                contentValues.put(COL_NAME,c.getName());
                if (c.getId_case() != null)
                    contentValues.put(COL_IDCASE,c.getId_case());
                if (!c.getMongoID_case().isEmpty())
                    contentValues.put(COL_MONGOIDCASE,c.getMongoID_case());
                contentValues.put(COL_IDGAME,c.getGameLiteID());
                contentValues.put(COL_MONGOIDGAME,c.getGameMongoID());
                contentValues.put(COL_MONGOID,c.getMongoID());
                db.insert(TABLE_NAME,null,contentValues);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public Character SelectOne(String id, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE "+ COL_ID + " = '" + id +"'",null);
        if (res.moveToFirst()) {
            Character result = new Character();
            //Id
            result.setLiteID(res.getInt(0));
            //Name
            result.setName(res.getString(1));
            //MongoId
            result.setMongoID(res.getString(2));
            //CaseId
            if (res.getInt(3) > 0)
                result.setId_case(res.getInt(3));
            //CaseMongoID
            if (!res.getString(4).isEmpty())
                result.setMongoID_case(res.getString(4));
            //GameID
            result.setGameLiteID(res.getInt(5));
            //MongoGameID
            result.setGameMongoID(res.getString(6));

            result.setSentenceList(SentenceDAO.SelectManyFromCharacter(id,dbContext));
            return result;
        }
        else
            return null;
    }

    @Override
    public ArrayList<Character> SelectMany(DBHelper dbContext) {
        return null;
    }

    @Override
    public void Update(Character itemToUpdate, DBHelper dbContext) {

    }

    @Override
    public void UpdateMany(ArrayList<Character> itemToUpdate, DBHelper dbContext) {

    }

    @Override
    public void DeleteOne(Character itemToDelete, DBHelper dbContext) {

    }

    @Override
    public void DeleteMany(ArrayList<Character> itemsToDelete, DBHelper dbContext) {

    }
}
