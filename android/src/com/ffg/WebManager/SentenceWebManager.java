package com.ffg.WebManager;

import android.app.Activity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.ffg.DAL.DBHelper;
import com.ffg.DAL.SentenceDAO;
import com.ffg.Models.Character;
import com.ffg.Models.Sentence;
import com.ffg.R;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class SentenceWebManager extends Activity {

    private String modelNameUrlVersion = Sentence.GetNameUrlVersion();
    private String characterNameUrlVersion = Character.GetNameUrlVersion();
    private String baseUrl = getString(R.string.apiBaseUrl);
    private SentenceWebManager sentenceWebManagerContext = this;

    public static Sentence GetOneFromJson(JsonValue jsonValue){
            Sentence sentence = new Sentence();
            sentence.setMongoID(jsonValue.getString("id"));
            sentence.setCharacterMongoID(jsonValue.getString("characterMongoID"));
            sentence.setContent(jsonValue.getString("content"));
            return sentence;
    }

    public static ArrayList<Sentence> GetManyFromJson(ArrayList<JsonValue> jsonValue){
        ArrayList<Sentence> allSentences = new ArrayList<>();
        for (JsonValue sentenceJson : jsonValue) {
            allSentences.add(GetOneFromJson(sentenceJson));
        }
        return allSentences;
    }


    public Sentence GetOne(String characterId, String id) {

        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                JsonValue sentenceJson = json.fromJson(JsonValue.class,responseStringValue);
                SentenceDAO sentenceDAO = new SentenceDAO();
                sentenceDAO.Insert(GetOneFromJson(sentenceJson), new DBHelper(sentenceWebManagerContext));
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url(baseUrl + characterNameUrlVersion + "/" + characterId + "/" + modelNameUrlVersion + "/" + id).build();
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return null;
    }


    public ArrayList<Sentence> GetMany(String characterId) {

        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                ArrayList<JsonValue> sentencesJson = json.fromJson(ArrayList.class,responseStringValue);
                SentenceDAO sentenceDAO = new SentenceDAO();
                sentenceDAO.InsertMany(GetManyFromJson(sentencesJson), new DBHelper(sentenceWebManagerContext));
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
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url(baseUrl + characterNameUrlVersion + "/" + characterId + "/" + modelNameUrlVersion).build();
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        return null;
    }


    public boolean PostOne(Sentence itemToPost) {
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


    public boolean PostMany(ArrayList<Sentence> itemsToPost) {

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


    public boolean PutOne(Sentence itemToPut) {
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


    public boolean PutMany(ArrayList<Sentence> itemsToPut) {

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


    public boolean DeleteOne(Sentence itemToDelete) {
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


    public boolean DeleteMany(ArrayList<Sentence> itemsToDelete) {

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
