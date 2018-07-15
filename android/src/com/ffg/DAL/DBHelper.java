package com.ffg.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by edern on 14/07/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "FFG.db";


    public static final String SKILLLINKTABLE_NAME = "skillLink_table";
    public static final String COL_IDSKILL = "id_skill";
    public static final String COL_ISCHAR = "id_char";

    public static final String SENTENCELINKTABLE_NAME = "sentenceLink_table";
    public static final String COL_IDSENT = "id_sent";

    public ArrayList<String> GetAllCreationQueries(){
        ArrayList<String> allQueries = new ArrayList<>();
        allQueries.add(SkillDAO.GetCreationString());
        allQueries.add(SentenceDAO.GetCreationString());
        allQueries.add(AccountDAO.GetCreationString());
        allQueries.add(MapDAO.GetCreationString());
        allQueries.add(CaseDAO.GetCreationString());
        allQueries.add(CharacterDAO.GetCreationString());
        allQueries.add(ActiveCharacterDAO.GetCreationString());
        allQueries.add(GameDAO.GetCreationString());

        String sentenceCharacterTableQuery = "CREATE TABLE "+SENTENCELINKTABLE_NAME+" ("+COL_IDSENT+" INTEGER NOT NULL ,"+COL_ISCHAR+"INTEGER NOT NULL";
        sentenceCharacterTableQuery += ",CONSTRAINT dit_PK PRIMARY KEY ("+COL_IDSENT+","+COL_ISCHAR+")";
        sentenceCharacterTableQuery += ",CONSTRAINT dit_Sentence_FK FOREIGN KEY ("+COL_IDSENT+") REFERENCES Sentence("+SentenceDAO.COL_ID+")";
        sentenceCharacterTableQuery += ",CONSTRAINT dit_Character0_FK FOREIGN KEY ("+COL_ISCHAR+") REFERENCES Character("+CharacterDAO.COL_ID+")";
        allQueries.add(sentenceCharacterTableQuery);

        String skillActiveCharacterTableQuery = "CREATE TABLE "+SKILLLINKTABLE_NAME+" ("+COL_IDSKILL+" INTEGER NOT NULL ,"+COL_ISCHAR+"INTEGER NOT NULL";
        sentenceCharacterTableQuery += ",CONSTRAINT lance_PK PRIMARY KEY ("+COL_IDSKILL+","+COL_ISCHAR+")";
        sentenceCharacterTableQuery += ",CONSTRAINT lance_Skill_FK FOREIGN KEY ("+COL_IDSKILL+") REFERENCES Skill("+SkillDAO.COL_ID+")";
        sentenceCharacterTableQuery += ",CONSTRAINT lance_ActiveCharacter0_FK FOREIGN KEY ("+COL_ISCHAR+") REFERENCES ActiveCharacter("+ActiveCharacterDAO.COL_ID+")";
        allQueries.add(sentenceCharacterTableQuery);

        return allQueries;
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String query : GetAllCreationQueries()) {
            db.execSQL(query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean insertData(String name,String surname,String marks){
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return res;
    }
}
