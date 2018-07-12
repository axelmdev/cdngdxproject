package com.ffg.Models;

/**
 * Created by edern on 07/07/2018.
 */

public class Sentence {
    private String content;

    public static String GetNameUrlVersion(){
        return "Sentences";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
