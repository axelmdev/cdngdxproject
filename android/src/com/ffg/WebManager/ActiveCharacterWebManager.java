package com.ffg.WebManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.ffg.DAL.ActiveCharacterDAO;
import com.ffg.Models.ActiveCharacter;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class ActiveCharacterWebManager implements BaseWebManager<ActiveCharacter> {

    private String modelNameUrlVersion = ActiveCharacter.GetNameUrlVersion();

    @Override
    public ActiveCharacter GetOne(String id) {
        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                JsonValue activeCharacterJson = json.fromJson(JsonValue.class,responseStringValue);
                ActiveCharacter newActiveCharacter = new ActiveCharacter();
                newActiveCharacter.setExperience(activeCharacterJson.getInt("experience"));
                newActiveCharacter.setLevel(activeCharacterJson.getInt("level"));
                //newActiveCharacter.setSkillList(ActiveCharacterJson.getInt("level"));
                newActiveCharacter.setStatsAttack(activeCharacterJson.getInt("statsAttack"));
                newActiveCharacter.setStatsDefense(activeCharacterJson.getInt("statsDefense"));
                newActiveCharacter.setStatsLife(activeCharacterJson.getInt("statsLife"));
                ActiveCharacterDAO ActiveCharacterDAO = new ActiveCharacterDAO();
                ActiveCharacterDAO.Insert(newActiveCharacter);
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
    public ArrayList<ActiveCharacter> GetMany() {
        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                ArrayList<JsonValue> activeCharactersJson = json.fromJson(ArrayList.class,responseStringValue);
                ArrayList<ActiveCharacter> activeCharacters = new ArrayList<>();
                for (JsonValue activeCharacterJson : activeCharactersJson) {
                    ActiveCharacter newActiveCharacter = new ActiveCharacter();
                    newActiveCharacter.setExperience(activeCharacterJson.getInt("experience"));
                    newActiveCharacter.setLevel(activeCharacterJson.getInt("level"));
                    //newActiveCharacter.setSkillList(activeCharacterJson.getInt("level"));
                    newActiveCharacter.setStatsAttack(activeCharacterJson.getInt("statsAttack"));
                    newActiveCharacter.setStatsDefense(activeCharacterJson.getInt("statsDefense"));
                    newActiveCharacter.setStatsLife(activeCharacterJson.getInt("statsLife"));
                    activeCharacters.add(newActiveCharacter);
                }
                ActiveCharacterDAO activeCharacterDAO = new ActiveCharacterDAO();
                activeCharacterDAO.InsertMany(activeCharacters);
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url("http://51.68.122.241:3000/api/" + modelNameUrlVersion + "/").build();
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return null;
    }

    @Override
    public boolean PostOne(ActiveCharacter itemToPost) {
        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.POST).url("http://51.68.122.241:3000/api/" + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemToPost));
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return true;
    }

    @Override
    public boolean PostMany(ArrayList<ActiveCharacter> itemsToPost) {
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.POST).url("http://51.68.122.241:3000/api/" + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemsToPost));
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return true;
    }

    @Override
    public boolean PutOne(ActiveCharacter itemToPut) {
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.PUT).url("http://51.68.122.241:3000/api/" + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemToPut));
        Gdx.net.sendHttpRequest(httpRequest, hrl);

        return true;
    }

    @Override
    public boolean PutMany(ArrayList<ActiveCharacter> itemsToPut) {

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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.PUT).url("http://51.68.122.241:3000/api/" + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemsToPut));
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return true;
    }

    @Override
    public boolean DeleteOne(ActiveCharacter itemToDelete) {
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.DELETE).url("http://51.68.122.241:3000/api/" + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemToDelete));
        Gdx.net.sendHttpRequest(httpRequest, hrl);

        return true;
    }

    @Override
    public boolean DeleteMany(ArrayList<ActiveCharacter> itemsToDelete) {

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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.DELETE).url("http://51.68.122.241:3000/api/" + modelNameUrlVersion + "/").build();
        Json json = new Json();
        httpRequest.setContent(json.toJson(itemsToDelete));
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return true;
    }
}
