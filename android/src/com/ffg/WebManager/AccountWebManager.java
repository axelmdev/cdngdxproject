package com.ffg.WebManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.ffg.DAL.AccountDAO;
import com.ffg.Models.Account;

import java.util.ArrayList;

/**
 * Created by edern on 09/07/2018.
 */

public class AccountWebManager implements BaseWebManager<Account> {

    private String modelNameUrlVersion = Account.GetNameUrlVersion();

    @Override
    public Account GetOne(String id) {

        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                JsonValue accountJson = json.fromJson(JsonValue.class,responseStringValue);
                    Account newAccount = new Account();
                    newAccount.setPseudo(accountJson.getString("pseudo"));
                    newAccount.setMail(accountJson.getString("mail"));
                    newAccount.setPwd(accountJson.getString("pwd"));
                AccountDAO accountDAO = new AccountDAO();
                accountDAO.Insert(newAccount);
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
    public ArrayList<Account> GetMany() {

        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                ArrayList<JsonValue> accountsJson = json.fromJson(ArrayList.class,responseStringValue);
                ArrayList<Account> accounts = new ArrayList<>();
                for (JsonValue oiseauJson : accountsJson) {
                    Account newAccount = new Account();
                    newAccount.setPseudo(oiseauJson.getString("pseudo"));
                    newAccount.setMail(oiseauJson.getString("mail"));
                    newAccount.setPwd(oiseauJson.getString("pwd"));
                    accounts.add(newAccount);
                }
                AccountDAO accountDAO = new AccountDAO();
                accountDAO.InsertMany(accounts);
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url("http://51.68.122.241:3000/api/" + modelNameUrlVersion).build();
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return null;
    }

    @Override
    public boolean PostOne(Account itemToPost) {
        return false;
    }

    @Override
    public boolean PostMany(ArrayList<Account> itemsToPost) {
        return false;
    }

    @Override
    public boolean PutOne(Account itemToPut) {
        return false;
    }

    @Override
    public boolean PutMany(ArrayList<Account> itemsToPut) {
        return false;
    }

    @Override
    public boolean DeleteOne(Account itemToDelete) {
        return false;
    }

    @Override
    public boolean DeleteMany(ArrayList<Account> itemsToDelete) {
        return false;
    }
}
