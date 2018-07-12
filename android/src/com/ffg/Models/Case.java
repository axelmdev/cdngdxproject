package com.ffg.Models;

/**
 * Created by edern on 07/07/2018.
 */

public class Case {
    private boolean usable;
    private String img;

    public static String GetNameUrlVersion(){
        return "Cases";
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
