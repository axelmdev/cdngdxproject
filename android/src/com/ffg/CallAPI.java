package com.ffg;

import android.app.Activity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.net.HttpParametersUtils;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.Base64Coder;

import java.io.Console;

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

    public void launch()
    {

        int tototo = 3;

        HttpRequest request = requestBuilder.newRequest().method(HttpMethods.GET).url("http://www.google.com").build(); //new HttpRequest(HttpMethods.GET,);
        request.setUrl("http://www.google.fr");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        Gdx.net.sendHttpRequest(request,new HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                System.out.println("Réponse ok : ");
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getStatus().getStatusCode());
                Gdx.app.log("WebRequest", "HTTP Response code: " + httpResponse.getResultAsString());

            }

            public void failed(Throwable t) {
                System.out.println("Réponse PAS ok : ");
                Gdx.app.log("WebRequest", "HTTP request failed");
            }

            @Override
            public void cancelled() {
                System.out.println("Réponse Cancelled : ");
                Gdx.app.log("WebRequest", "HTTP request cancelled");
            }
        });
        int toto = 1;
    }
    //Gdx.net.sendHttpRequest(httpRequest, httpResponseListener);

/*Gdx.net.sendHttpRequest (httpPost, new HttpResponseListener() {
        public void handleHttpResponse(HttpResponse httpResponse) {
            status = httpResponse.getResultAsString();
        }

    public void failed(Throwable t) {
        status = "failed";
    }
});*/
}
