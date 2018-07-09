package com.ffg.WebManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;
import com.ffg.DAL.OiseauDao;
import com.ffg.Models.Oiseau;

import java.util.ArrayList;

/**
 * Created by edern on 08/07/2018.
 */

public class OiseauWebManager implements BaseWebManager<Oiseau> {
    @Override
    public Oiseau GetOne(String id) {
        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                System.out.println("Réponse ok : ");
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                ArrayList<Oiseau> oiseaux = json.fromJson(ArrayList.class,responseStringValue);
                JsonValue jsonValue = new JsonReader().parse(responseStringValue);
                for (JsonValue values : jsonValue.iterator())
                {
                    Oiseau oiseau = new Oiseau();
                    oiseau.setId(values.getString("id"));
                    oiseau.setName(values.getString("name"));
                    oiseau.setNbPlume(values.getInt("nbPlume"));
                }
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
        /*Net.HttpRequest httpRequestPOST = requestBuilder.newRequest().method(Net.HttpMethods.POST).url("http://51.68.122.241:3000/api/oiseaux").build();
        httpRequestPOST.setHeader("Content-Type", "application/json");
        httpRequestPOST.setContent("{ \"name\": \"deux\",\"nbPlume\": 2}");
        Gdx.net.sendHttpRequest(httpRequestPOST, testhrl);*/
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url("http://51.68.122.241:3000/api/oiseaux").build();
        //Map parameters = new HashMap();
        //parameters.put("access_token", "kkZfiw8lGBsFOBm4pmsfIsP6ZoFqMRRHCMyFcohdIdQc0oME803uTofLRzRFDRWq");
        //parameters.put("Accept","application/json");
        //httpRequest.setContent(HttpParametersUtils.convertHttpParameters(parameters));
        Gdx.net.sendHttpRequest(httpRequest, hrl);


        return null;
    }

    @Override
    public ArrayList<Oiseau> GetMany() {
        Net.HttpResponseListener hrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String responseStringValue = httpResponse.getResultAsString();
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + responseStringValue);
                Json json = new Json();
                ArrayList<JsonValue> oiseauxJson = json.fromJson(ArrayList.class,responseStringValue);
                ArrayList<Oiseau> oiseaux = new ArrayList<>();
                for (JsonValue oiseauJson : oiseauxJson) {
                    Oiseau newOiseau = new Oiseau();
                    newOiseau.setId(oiseauJson.getString("id"));
                    newOiseau.setNbPlume(oiseauJson.getInt("nbPlume"));
                    newOiseau.setName(oiseauJson.getString("name"));
                    oiseaux.add(newOiseau);
                }
                OiseauDao oiseauDao = new OiseauDao();
                oiseauDao.InsertMany(oiseaux);
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
        /*Net.HttpRequest httpRequestPOST = requestBuilder.newRequest().method(Net.HttpMethods.POST).url("http://51.68.122.241:3000/api/oiseaux").build();
        httpRequestPOST.setHeader("Content-Type", "application/json");
        httpRequestPOST.setContent("{ \"name\": \"deux\",\"nbPlume\": 2}");
        Gdx.net.sendHttpRequest(httpRequestPOST, testhrl);*/
        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url("http://51.68.122.241:3000/api/oiseaux").build();
        //Map parameters = new HashMap();
        //parameters.put("access_token", "kkZfiw8lGBsFOBm4pmsfIsP6ZoFqMRRHCMyFcohdIdQc0oME803uTofLRzRFDRWq");
        //parameters.put("Accept","application/json");
        //httpRequest.setContent(HttpParametersUtils.convertHttpParameters(parameters));
        Gdx.net.sendHttpRequest(httpRequest, hrl);
        String content = httpRequest.getContent();
        return null;
    }

    @Override
    public boolean PostOne(Oiseau itemToPost) {
        return false;
    }

    @Override
    public boolean PostMany(ArrayList<Oiseau> itemsToPost) {
        return false;
    }

    @Override
    public boolean PutOne(Oiseau itemToPut) {
        return false;
    }

    @Override
    public boolean PutMany(ArrayList<Oiseau> itemsToPut) {
        return false;
    }

    @Override
    public boolean DeleteOne(Oiseau itemToDelete) {
        return false;
    }

    @Override
    public boolean DeleteMany(ArrayList<Oiseau> itemsToDelete) {
        return false;
    }
}

class Oiseaux{
    private Array<Oiseau> oiseaux;

    public Array<Oiseau> getOiseaux() {
        return oiseaux;
    }

    public void setOiseaux(Array<Oiseau> oiseaux) {
        this.oiseaux = oiseaux;
    }
}
