package com.ffg.DAL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ffg.Models.ActiveCharacter;
import com.ffg.Models.Skill;

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
    public static final String COL_MONGOIDGAME = "id_game";
    public static final String COL_IDCASE = "id_case";
    public static final String COL_IDCHAR = "id_char";
    public static final String COL_MONGOIDCHAR = "id_char";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_lEVEL+" INTEGER,"+COL_STATSLIFE+" INTEGER NOT NULL,"
                +COL_STATSATTACK+" INTEGER NOT NULL,"+COL_STATSDEFENSE+" INTEGER,"+COL_EXPERIENCE+" INTEGER,"+COL_NAME+" TEXT NOT NULL,"+COL_MONGOID+" TEXT NOT NULL,"
                +COL_IDGAME+" INTEGER NOT NULL,"+COL_MONGOIDGAME+" TEXT NOT NULL,"+COL_IDCASE+" INTEGER,"+ COL_IDCHAR +" INTEGER NOT NULL,"+ COL_MONGOIDCHAR +" INTEGER NOT NULL";
        query += ",CONSTRAINT ActiveCharacter_PK PRIMARY KEY ("+COL_ID+")";
        query += ",CONSTRAINT ActiveCharacter_Character_FK FOREIGN KEY ("+COL_IDCHAR+") REFERENCES Character("+CharacterDAO.COL_ID+")";
        query += ",CONSTRAINT ActiveCharacter_Game0_FK FOREIGN KEY ("+COL_IDGAME+") REFERENCES Game("+GameDAO.COL_ID+")";
        query += ",CONSTRAINT ActiveCharacter_Case1_FK FOREIGN KEY ("+COL_IDCASE+") REFERENCES Case("+CaseDAO.COL_ID+")";
        query += ",CONSTRAINT ActiveCharacter_Game2_FK FOREIGN KEY ("+COL_IDCHAR+") REFERENCES Game("+GameDAO.COL_ID+")";
        query += ",CONSTRAINT ActiveCharacter_Case_AK UNIQUE ("+COL_IDCASE+")";
        return query;
    }

    @Override
    public void Insert(ActiveCharacter itemToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,itemToInsert.getName());
        contentValues.put(COL_lEVEL,itemToInsert.getLevel());
        contentValues.put(COL_STATSLIFE,itemToInsert.getStatsLife());
        contentValues.put(COL_STATSATTACK,itemToInsert.getStatsAttack());
        contentValues.put(COL_STATSDEFENSE,itemToInsert.getStatsDefense());
        contentValues.put(COL_EXPERIENCE,itemToInsert.getExperience());
        contentValues.put(COL_NAME,itemToInsert.getName());
        contentValues.put(COL_MONGOID,itemToInsert.getMongoID());
        contentValues.put(COL_IDGAME,itemToInsert.getGameLiteID());
        contentValues.put(COL_MONGOIDGAME,itemToInsert.getGameMongoID());
        contentValues.put(COL_IDCASE,itemToInsert.getCaseLiteID());
        contentValues.put(COL_IDCHAR,itemToInsert.getCharLiteID());
        contentValues.put(COL_MONGOIDCHAR,itemToInsert.getCharMongoID());
        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1)
            System.out.println("[FAILED]Insertion ActiveCharacter : " + itemToInsert.getLiteID());
        else
            System.out.println("Insertion ActiveCharacter : " + itemToInsert.getLiteID());

        contentValues = new ContentValues();
        for (Skill s : itemToInsert.getSkillList()) {
            contentValues.put(DBHelper.COL_IDSKILL,s.getLiteID());
            contentValues.put(DBHelper.COL_IDCHAR,itemToInsert.getCharLiteID());
        }
        result= db.insert(DBHelper.SKILLLINKTABLE_NAME,null,contentValues);

        if (result == -1)
            System.out.println("[FAILED]Insertion SKILLLINK : " + itemToInsert.getLiteID());
        else
            System.out.println("Insertion SKILLLINK : " + itemToInsert.getLiteID());
    }

    @Override
    public void InsertMany(ArrayList<ActiveCharacter> itemsToInsert, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        // Bulk Insert
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            for (ActiveCharacter ac :itemsToInsert) {
                contentValues.put(COL_NAME,ac.getName());
                contentValues.put(COL_lEVEL,ac.getLevel());
                contentValues.put(COL_STATSLIFE,ac.getStatsLife());
                contentValues.put(COL_STATSATTACK,ac.getStatsAttack());
                contentValues.put(COL_STATSDEFENSE,ac.getStatsDefense());
                contentValues.put(COL_EXPERIENCE,ac.getExperience());
                contentValues.put(COL_NAME,ac.getName());
                contentValues.put(COL_MONGOID,ac.getMongoID());
                contentValues.put(COL_IDGAME,ac.getGameLiteID());
                contentValues.put(COL_MONGOIDGAME,ac.getGameMongoID());
                contentValues.put(COL_IDCASE,ac.getCaseLiteID());
                contentValues.put(COL_IDCHAR,ac.getCharLiteID());
                contentValues.put(COL_MONGOIDCHAR,ac.getCharMongoID());
                db.insert(TABLE_NAME,null,contentValues);
                for (Skill s : ac.getSkillList()) {
                    contentValues.put(DBHelper.COL_IDSKILL,s.getLiteID());
                    contentValues.put(DBHelper.COL_IDCHAR,ac.getCharLiteID());
                }
                db.insert(DBHelper.SKILLLINKTABLE_NAME,null,contentValues);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public ActiveCharacter SelectOne(String id, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE "+ COL_ID + " = '" + id +"'",null);
        if (res.moveToFirst()) {
            ActiveCharacter result = new ActiveCharacter();
            //Id
            result.setLiteID(res.getInt(0));
            //Level
            result.setLevel(res.getInt(1));
            //StatsLife
            result.setStatsLife(res.getInt(2));
            //StatsAttack
            result.setStatsAttack(res.getInt(3));
            //StatsDefense
            result.setStatsDefense(res.getInt(4));
            //Experience
            result.setExperience(res.getInt(5));
            //Name
            result.setName(res.getString(6));
            //MongoId
            result.setGameMongoID(res.getString(7));
            //id_game
            result.setGameLiteID(res.getInt(8));
            //id_case
            if (res.getInt(9) >= 0)
                result.setCaseLiteID(res.getInt(9));
            //id_char
            result.setCharLiteID(res.getInt(10));
            //mongoid_char
            result.setCharMongoID(res.getString(11));

            result.setSkillList(SkillDAO.SelectManyFromAC(id,dbContext));
            return result;
        }
        else
            return null;
    }

    @Override
    public ArrayList<ActiveCharacter> SelectMany(DBHelper dbContext) {
        ArrayList<ActiveCharacter> allActiveCharacters = new ArrayList<>();
        SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if (res.moveToFirst()) {
            while (!res.isAfterLast()) {
                ActiveCharacter result = new ActiveCharacter();
                //Id
                result.setLiteID(res.getInt(0));
                //Level
                result.setLevel(res.getInt(1));
                //StatsLife
                result.setStatsLife(res.getInt(2));
                //StatsAttack
                result.setStatsAttack(res.getInt(3));
                //StatsDefense
                result.setStatsDefense(res.getInt(4));
                //Experience
                result.setExperience(res.getInt(5));
                //Name
                result.setName(res.getString(6));
                //MongoId
                result.setGameMongoID(res.getString(7));
                //id_game
                result.setGameLiteID(res.getInt(8));
                //id_case
                if (res.getInt(9) >= 0)
                    result.setCaseLiteID(res.getInt(9));
                //id_char
                result.setCharLiteID(res.getInt(10));
                //mongoid_char
                result.setCharMongoID(res.getString(11));

                result.setSkillList(SkillDAO.SelectManyFromAC( result.getLiteID().toString(),dbContext));

                allActiveCharacters.add(result);
                res.moveToNext();
            }
            return allActiveCharacters;
        }
        return null;
    }

    @Override
    public void Update(ActiveCharacter itemToUpdate, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME,itemToUpdate.getName());
        cv.put(COL_lEVEL,itemToUpdate.getLevel());
        cv.put(COL_STATSLIFE,itemToUpdate.getStatsLife());
        cv.put(COL_STATSATTACK,itemToUpdate.getStatsAttack());
        cv.put(COL_STATSDEFENSE,itemToUpdate.getStatsDefense());
        cv.put(COL_EXPERIENCE,itemToUpdate.getExperience());
        cv.put(COL_NAME,itemToUpdate.getName());
        cv.put(COL_MONGOID,itemToUpdate.getMongoID());
        cv.put(COL_IDGAME,itemToUpdate.getGameLiteID());
        cv.put(COL_MONGOIDGAME,itemToUpdate.getGameMongoID());
        if (itemToUpdate.getCaseLiteID() != null)
            cv.put(COL_IDCASE,itemToUpdate.getCaseLiteID());
        cv.put(COL_IDCHAR,itemToUpdate.getCharLiteID());
        cv.put(COL_MONGOIDCHAR,itemToUpdate.getCharMongoID());
        db.update(TABLE_NAME, cv, COL_ID+"=?", new String[]{(itemToUpdate.getLiteID().toString())});

        SkillDAO skillDAO = new SkillDAO();
        skillDAO.UpdateMany(itemToUpdate.getSkillList(),dbContext);
    }

    @Override
    public void UpdateMany(ArrayList<ActiveCharacter> itemToUpdate, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        CaseDAO caseDAO = new CaseDAO();
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            for (ActiveCharacter ac : itemToUpdate) {
                cv.put(COL_NAME,ac.getName());
                cv.put(COL_lEVEL,ac.getLevel());
                cv.put(COL_STATSLIFE,ac.getStatsLife());
                cv.put(COL_STATSATTACK,ac.getStatsAttack());
                cv.put(COL_STATSDEFENSE,ac.getStatsDefense());
                cv.put(COL_EXPERIENCE,ac.getExperience());
                cv.put(COL_NAME,ac.getName());
                cv.put(COL_MONGOID,ac.getMongoID());
                cv.put(COL_IDGAME,ac.getGameLiteID());
                cv.put(COL_MONGOIDGAME,ac.getGameMongoID());
                if (ac.getCaseLiteID() != null)
                    cv.put(COL_IDCASE,ac.getCaseLiteID());
                cv.put(COL_IDCHAR,ac.getCharLiteID());
                cv.put(COL_MONGOIDCHAR,ac.getCharMongoID());
                db.update(TABLE_NAME, cv, COL_ID+"=?", new String[]{(ac.getLiteID().toString())});

                SkillDAO skillDAO = new SkillDAO();
                skillDAO.UpdateMany(ac.getSkillList(),dbContext);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void DeleteOne(ActiveCharacter itemToDelete, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.delete(TABLE_NAME,COL_ID+"=?",new String[]{itemToDelete.getLiteID().toString()});
    }

    @Override
    public void DeleteMany(ArrayList<ActiveCharacter> itemsToDelete, DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.beginTransaction();
        try {
            for (ActiveCharacter ac : itemsToDelete) {
                db.delete(TABLE_NAME,COL_ID+"=?",new String[]{ac.getLiteID().toString()});
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }
}
