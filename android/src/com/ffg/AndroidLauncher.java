package com.ffg;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ffg.DAL.DBHelper;
import com.ffg.FFG;

import fr.imie.ena.fightforgrades.FightForGrades;


public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new FFG(), config);
		DBHelper db = new DBHelper(this);

		initialize(new FightForGrades(), config);
	}

	public void showMessage(String title,String message){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setCancelable(true);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.show();
	}
}
