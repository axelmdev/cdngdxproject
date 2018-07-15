package com.ffg;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ffg.DAL.DBHelper;
import com.ffg.FFG;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new FFG(), config);
		DBHelper db = new DBHelper(this);
		boolean insertResult = db.insertData("toto","tata","20");
		Cursor res = db.getAllData();
		int i = 1;
		int qsd = res.getCount();
		if (qsd == 0){
			showMessage("Error","no Data");
			return;
		}
		StringBuffer buffer = new StringBuffer();
		while (res.moveToNext()){
			buffer.append("Id : " + res.getString(0)+"\n");
			buffer.append("Name : " + res.getString(1)+"\n");
			buffer.append("Surname : " + res.getString(2)+"\n");
			buffer.append("Marks : " + res.getString(3)+"\n\n");
		}
		System.out.println(buffer.toString());
		showMessage("Data",buffer.toString());
	}

	public void showMessage(String title,String message){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setCancelable(true);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.show();
	}
}
