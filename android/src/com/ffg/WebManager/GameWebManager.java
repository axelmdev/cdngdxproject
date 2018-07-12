package com.ffg.WebManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.ffg.Models.Game;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class GameWebManager implements BaseWebManager<Game> {

    private String modelNameUrlVersion = Game.GetNameUrlVersion();

    @Override
    public Game GetOne(String id) {

        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                JsonValue accountJson = json.fromJson(JsonValue.class,responseStringValue);
                Game newGame = new Game();
                /*newGame.setPseudo(accountJson.getString("pseudo"));
                newGame.setMail(accountJson.getString("mail"));
                newGame.setPwd(accountJson.getString("pwd"));*/
                //AccountDAO accountDAO = new AccountDAO();
                //accountDAO.Insert(newGame);
            }

            public void failed(Throwable t) {
                System.out.println("Réponse PAS ok : " + t.getMessage());
                Gdx.app.log("WebRequest", "HTTP request failed");

            }

            public void cancelled() {
                System.out.println("Réponse Cancelled : ");
                Gdx.app.log("WebRequest", "HTTP request cancelled");
            }
        };

        HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url("http://51.68.122.241:3000/api/" + modelNameUrlVersion + "/" + id).build();
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return null;
    }

    @Override
    public ArrayList<Game> GetMany() {
        return null;
    }

    @Override
    public boolean PostOne(Game itemToPost) {
        return false;
    }

    @Override
    public boolean PostMany(ArrayList<Game> itemsToPost) {
        return false;
    }

    @Override
    public boolean PutOne(Game itemToPut) {
        return false;
    }

    @Override
    public boolean PutMany(ArrayList<Game> itemsToPut) {
        return false;
    }

    @Override
    public boolean DeleteOne(Game itemToDelete) {
        return false;
    }

    @Override
    public boolean DeleteMany(ArrayList<Game> itemsToDelete) {
        return false;
    }
}
