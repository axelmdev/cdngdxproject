package com.ffg;

import android.app.Activity;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.ffg.DAL.DBHelper;

import java.util.ArrayList;

/**
 * Created by edern on 29/05/2018.
 */

public class CallAPI extends Activity {
    DBHelper myDb;

    public CallAPI() {
        launch();
    }

    public void launch() {
        myDb = new DBHelper(this);
        int toto = 1;
    }
}
