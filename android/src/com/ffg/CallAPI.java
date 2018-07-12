package com.ffg;

import android.app.Activity;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.ffg.WebManager.OiseauWebManager;

import java.util.ArrayList;

/**
 * Created by edern on 29/05/2018.
 */

public class CallAPI extends Activity {

    Net.HttpRequest httpGet = new Net.HttpRequest(HttpMethods.GET);
    HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
    HttpRequest httpRequest = requestBuilder.newRequest().method(HttpMethods.GET).url("http://www.google.com").build();
    public void setHttpGet(HttpRequest httpGet) {
        this.httpGet = httpGet;
        this.httpGet.setUrl("https://www.google.com/");
        this.httpGet.setHeader("Content-Type", "application/json");
        String test = this.httpGet.getContent();
    }

    public CallAPI() {
        launch();
    }

    public void launch() {

        OiseauWebManager oiseauWebManager = new OiseauWebManager();
        ArrayList<Oiseau> oiseaux = oiseauWebManager.GetMany();
        //Oiseau oiseau = oiseauWebManager.GetOne();


        int tototo = 3;

        /*Net.HttpResponseListener testhrl = new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                System.out.println("Réponse ok : ");
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getResultAsString());

            }

            public void failed(Throwable t) {
                System.out.println("Réponse PAS ok : " + t.getMessage());
                Gdx.app.log("WebRequest", "HTTP request failed");

            }

            public void cancelled() {
                System.out.println("Réponse Cancelled : ");
                Gdx.app.log("WebRequest", "HTTP request cancelled");
            }
        };*/

        //HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
        /*Net.HttpRequest httpRequestPOST = requestBuilder.newRequest().method(Net.HttpMethods.POST).url("http://51.68.122.241:3000/api/oiseaux").build();
        httpRequestPOST.setHeader("Content-Type", "application/json");
        httpRequestPOST.setContent("{ \"name\": \"deux\",\"nbPlume\": 2}");
        Gdx.net.sendHttpRequest(httpRequestPOST, testhrl);*/
        //Net.HttpRequest httpRequest = requestBuilder.newRequest().method(Net.HttpMethods.GET).url("http://51.68.122.241:3000/api/oiseaux").build();
        //Map parameters = new HashMap();
        //parameters.put("access_token", "kkZfiw8lGBsFOBm4pmsfIsP6ZoFqMRRHCMyFcohdIdQc0oME803uTofLRzRFDRWq");
        //parameters.put("Accept","application/json");
        //httpRequest.setContent(HttpParametersUtils.convertHttpParameters(parameters));
        //Gdx.net.sendHttpRequest(httpRequest, testhrl);
        int toto = 1;
    }
}
