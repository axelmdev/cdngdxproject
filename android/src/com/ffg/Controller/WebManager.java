package com.ffg.Controller;

import android.util.JsonReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.Json;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by edern on 07/07/2018.
 */

public class WebManager<T> {

    private String baseUrl = "http://51.68.122.241:3000/api/";
    boolean gotResponse = false;
    ArrayList<T> result = new ArrayList<>();

    public ArrayList<T> GetOne(String pluralType,int id){
        Net.HttpResponseListener  responseListener = GenerateResponseListener();
        responseListener.notify();
        HttpRequestBuilder requestBuilder = new HttpRequestBuilder();

        String url = baseUrl + pluralType + "/" + id;

        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url(url).build();
        Gdx.net.sendHttpRequest(httpRequest, responseListener);
        return null;
    }

    public ArrayList<T> Get(String pluralType){
        Net.HttpResponseListener  responseListener = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                System.out.println("Réponse ok : ");
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getResultAsString());
                gotResponse = true;
                Json json = new Json();

            }

            public void failed(Throwable t) {
                System.out.println("Réponse PAS ok : ");
                Gdx.app.log("WebRequest", "HTTP request failed");
            }

            public void cancelled() {
                System.out.println("Réponse Cancelled : ");
                Gdx.app.log("WebRequest", "HTTP request cancelled");
            }
        };
        responseListener.notify();
        HttpRequestBuilder requestBuilder = new HttpRequestBuilder();

        String url = baseUrl + pluralType;

        Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url(url).build();
        Gdx.net.sendHttpRequest(httpRequest, responseListener);

        while (gotResponse == false){

        }
        return result;
    }


    /*
    * Generate a generic HttpReponseListener
     */
    private Net.HttpResponseListener GenerateResponseListener(){
        return new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                System.out.println("Réponse ok : ");
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getResultAsString());
                gotResponse = true;
                Json json = new Json();

            }

            public void failed(Throwable t) {
                System.out.println("Réponse PAS ok : ");
                Gdx.app.log("WebRequest", "HTTP request failed");
            }

            public void cancelled() {
                System.out.println("Réponse Cancelled : ");
                Gdx.app.log("WebRequest", "HTTP request cancelled");
            }
        };
    }
}
