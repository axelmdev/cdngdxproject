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



                //newAccount.setGame(accountJson.getString("pseudo"));
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url(baseUrl + modelNameUrlVersion + "/" + id).build();
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
                for (JsonValue accountJson : accountsJson) {
                    Account newAccount = new Account();
                    newAccount.setPseudo(accountJson.getString("pseudo"));
                    newAccount.setMail(accountJson.getString("mail"));
                    newAccount.setPwd(accountJson.getString("pwd"));
                    //newAccount.setGame(accountJson.getString("pseudo"));
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url(baseUrl + modelNameUrlVersion + "/").build();
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return null;
    }

    @Override
    public boolean PostOne(Account itemToPost) {
        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                Boolean aBoolean = json.fromJson(Boolean.class,responseStringValue);
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.POST).url(baseUrl + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemToPost));
        Gdx.net.sendHttpRequest(httpRequest, hrl);

        return true;
    }

    @Override
    public boolean PostMany(ArrayList<Account> itemsToPost) {

        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                Boolean aBoolean = json.fromJson(Boolean.class,responseStringValue);
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.POST).url(baseUrl + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemsToPost));
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return true;
    }

    @Override
    public boolean PutOne(Account itemToPut) {
        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                Boolean aBoolean = json.fromJson(Boolean.class,responseStringValue);
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.PUT).url(baseUrl + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemToPut));
        Gdx.net.sendHttpRequest(httpRequest, hrl);

        return true;
    }

    @Override
    public boolean PutMany(ArrayList<Account> itemsToPut) {

        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                Boolean aBoolean = json.fromJson(Boolean.class,responseStringValue);
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.PUT).url(baseUrl + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemsToPut));
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return true;
    }

    @Override
    public boolean DeleteOne(Account itemToDelete) {
        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                Boolean aBoolean = json.fromJson(Boolean.class,responseStringValue);
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.DELETE).url(baseUrl + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemToDelete));
        Gdx.net.sendHttpRequest(httpRequest, hrl);

        return true;
    }

    @Override
    public boolean DeleteMany(ArrayList<Account> itemsToDelete) {

        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                Boolean aBoolean = json.fromJson(Boolean.class,responseStringValue);
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.DELETE).url(baseUrl + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemsToDelete));
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return true;
    }
}
