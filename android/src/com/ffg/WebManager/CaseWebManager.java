package com.ffg.WebManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.ffg.DAL.CaseDAO;
import com.ffg.Models.Case;

import java.util.ArrayList;

/**
 * Created by edern on 12/07/2018.
 */

public class CaseWebManager implements BaseWebManager<Case> {

    private String modelNameUrlVersion = Case.GetNameUrlVersion();

    @Override
    public Case GetOne(String id) {
        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                JsonValue caseJson = json.fromJson(JsonValue.class,responseStringValue);
                Case newCase = new Case();
                newCase.setImg(caseJson.getString("img"));
                newCase.setUsable(caseJson.getBoolean("usable"));
                CaseDAO caseDAO = new CaseDAO();
                caseDAO.Insert(newCase);
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
    public ArrayList<Case> GetMany() {
        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                ArrayList<JsonValue> casesJson = json.fromJson(ArrayList.class,responseStringValue);
                ArrayList<Case> cases = new ArrayList<>();
                for (JsonValue caseJson : casesJson) {
                    Case newCase = new Case();
                    newCase.setImg(caseJson.getString("img"));
                    newCase.setUsable(caseJson.getBoolean("usable"));
                    cases.add(newCase);
                }
                CaseDAO caseDAO = new CaseDAO();
                caseDAO.InsertMany(cases);
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
    public boolean PostOne(Case itemToPost) {
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
    public boolean PostMany(ArrayList<Case> itemsToPost) {
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
    public boolean PutOne(Case itemToPut) {
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
    public boolean PutMany(ArrayList<Case> itemsToPut) {

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
    public boolean DeleteOne(Case itemToDelete) {
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
    public boolean DeleteMany(ArrayList<Case> itemsToDelete) {

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
