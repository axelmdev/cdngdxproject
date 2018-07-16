package com.ffg.DAL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ffg.Models.Account;

import java.util.ArrayList;

/**
 * Created by edern on 09/07/2018.
 */

public class AccountDAO implements BaseDAO<Account> {
    public static final String TABLE_NAME = "account_table";
    public static final String COL_ID = "id_acc";
    public static final String COL_PSEUDO = "pseudo";
    public static final String COL_MAIL = "mail";
    public static final String COL_PWD = "password";
    public static final String COL_MONGOID = "mongoID";
    public static final String COL_IDGAME = "id_game";

    public static String GetCreationString() {
        String query = "create table " + TABLE_NAME +" ("+COL_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_PSEUDO+" TEXT,"+COL_MAIL +" TEXT"+COL_PWD +" TEXT"+COL_MONGOID+" TEXT,"+COL_IDGAME+" INTEGER ";
        query += ",CONSTRAINT Account_Game_FK FOREIGN KEY ("+COL_IDGAME+") REFERENCES Game("+GameDAO.COL_ID+")";
        query += ",CONSTRAINT Account_Game_AK UNIQUE ("+COL_IDGAME+")";
        return query;
    }

    @Override
    public void Insert(Account itemToInsert,DBHelper dbContext) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_PSEUDO,itemToInsert.getPseudo());
        contentValues.put(COL_MAIL,itemToInsert.getMail());
        contentValues.put(COL_PWD,itemToInsert.getPwd());
        contentValues.put(COL_MONGOID,itemToInsert.getMongoID());
        contentValues.put(COL_IDGAME,itemToInsert.getGame().getId());
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            System.out.println("[FAILED]Insertion Account : " + itemToInsert.getPseudo());
        else
            System.out.println("Insertion Account : " + itemToInsert.getPseudo());
    }

    @Override
    public void InsertMany(ArrayList<Account> itemsToInsert, DBHelper dbContext) {
        for (Account a :itemsToInsert) {
            Insert(a,dbContext);
        }

    }

    @Override
    public Account SelectOne(String id, DBHelper dbContext) {
        /*SQLiteDatabase db = dbContext.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE "+ COL_ID + " = ?",new String[]{});
        Account result = new Account();
        //Id
        result.setLiteID(res.getInt(0));
        //Pseudo
        result.setPseudo(res.getString(1));
        //Mail
        result.setMail(res.getString(2));
        //Pwd
        result.setPwd(res.getString(3));
        //MongoId
        result.setMongoID(res.getString(4));
        //idGame
        //result.setGame(res.getString(5));
        return result;*/
        return null;
    }

    @Override
    public ArrayList<Account> SelectMany(DBHelper dbContext) {
        return null;
    }

    @Override
    public void Update(Account itemToUpdate, DBHelper dbContext) {

    }

    @Override
    public void UpdateMany(ArrayList<Account> itemToUpdate, DBHelper dbContext) {

    }

    @Override
    public void DeleteOne(Account itemToDelete, DBHelper dbContext) {

    }

    @Override
    public void DeleteMany(ArrayList<Account> itemsToDelete, DBHelper dbContext) {

    }
}
