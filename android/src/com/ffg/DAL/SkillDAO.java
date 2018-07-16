package com.ffg.DAL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_NAME+" TEXT, "+COL_DAMAGE+" INTEGER, "+COL_MONGOID+" TEXT)";
        return query;
    }

    @Override
    public void Insert(Skill itemToInsert, DBHelper dbContext) {

        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,itemToInsert.getName());
        contentValues.put(COL_DAMAGE,itemToInsert.getDamage());
        contentValues.put(COL_MONGOID,itemToInsert.getMongoID());
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            System.out.println("[FAILED]Insertion Skill : " + itemToInsert.getName());
        else
            System.out.println("Insertion Skill : " + itemToInsert.getName());
    }

    @Override
    public void InsertMany(ArrayList<Skill> itemsToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        // Bulk Insert
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            for (Skill s :itemsToInsert) {
                contentValues.put(COL_NAME,s.getName());
                contentValues.put(COL_DAMAGE,s.getDamage());
                contentValues.put(COL_MONGOID,s.getMongoID());
                db.insert(TABLE_NAME,null,contentValues);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public Skill SelectOne(String id, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE "+ COL_ID + " = '" + id +"'",null);
        if (res.moveToFirst()) {
            Skill result = new Skill();
            //Id
            result.setLiteID(res.getInt(0));
            //Name
            result.setName(res.getString(1));
            //Damage
            result.setDamage(res.getInt(2));
            //MongoId
            result.setMongoID(res.getString(3));
            return result;
        }
        else
            return null;
    }

    @Override
    public ArrayList<Skill> SelectMany(DBHelper dbContext) {
        ArrayList<Skill> allSkills = new ArrayList<>();
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if (res.moveToFirst()) {
            while (!res.isAfterLast()) {
                Skill result = new Skill();
                //Id
                result.setLiteID(res.getInt(0));
                //Name
                result.setName(res.getString(1));
                //Damage
                result.setDamage(res.getInt(2));
                //MongoId
                result.setMongoID(res.getString(3));

                allSkills.add(result);
                res.moveToNext();
            }
            return allSkills;
        }
        return null;
    }

    public static ArrayList<Skill> SelectManyFromAC(String ACId,DBHelper dbContext) {
        ArrayList<Skill> allSkills = new ArrayList<>();
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT ("+COL_ID+","+COL_NAME+","+COL_DAMAGE+","+COL_MONGOID+") FROM "+TABLE_NAME + " INNER JOIN "+ DBHelper.SKILLLINKTABLE_NAME + " ON " + DBHelper.COL_IDSKILL + " = " + COL_ID + " WHERE " + DBHelper.SKILLLINKTABLE_NAME+"."+DBHelper.COL_IDCHAR + " = " + ACId,null);
        if (res.moveToFirst()) {
            while (!res.isAfterLast()) {
                Skill result = new Skill();
                //Id
                result.setLiteID(res.getInt(0));
                //Name
                result.setName(res.getString(1));
                //Damage
                result.setDamage(res.getInt(2));
                //MongoId
                result.setMongoID(res.getString(3));

                allSkills.add(result);
                res.moveToNext();
            }
            return allSkills;
        }
        return null;
    }

    @Override
    public void Update(Skill itemToUpdate, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME,itemToUpdate.getName());
        cv.put(COL_DAMAGE,itemToUpdate.getDamage());
        cv.put(COL_MONGOID,itemToUpdate.getMongoID());
        db.update(TABLE_NAME, cv, COL_ID+"=?", new String[]{(itemToUpdate.getLiteID().toString())});
    }

    @Override
    public void UpdateMany(ArrayList<Skill> itemToUpdate, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            for (Skill s : itemToUpdate) {
                cv.put(COL_NAME,s.getName());
                cv.put(COL_DAMAGE,s.getDamage());
                cv.put(COL_MONGOID,s.getMongoID());
                db.update(TABLE_NAME, cv, COL_ID+"=?", new String[]{(s.getLiteID().toString())});
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void DeleteOne(Skill itemToDelete, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.delete(TABLE_NAME,COL_ID+"=?",new String[]{itemToDelete.getLiteID().toString()});
    }

    @Override
    public void DeleteMany(ArrayList<Skill> itemsToDelete, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.beginTransaction();
        try {
            for (Skill s : itemsToDelete) {
                db.delete(TABLE_NAME,COL_ID+"=?",new String[]{s.getLiteID().toString()});
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }
}
