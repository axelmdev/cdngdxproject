package com.ffg.Models;

/**
 * Created by edern on 07/07/2018.
 */

public class Case {
    private int liteID;
    private String mapLiteID;
    private String mongoID;
    private String mapMongoID;
    private boolean usable;
    private String img;

    public static String GetNameUrlVersion(){
        return "Cases";
    }

    public int getLiteID() {
        return liteID;
    }

    public void setLiteID(int liteID) {
        this.liteID = liteID;
    }

    public String getMapLiteID() {
        return mapLiteID;
    }

    public void setMapLiteID(String mapLiteID) {
        this.mapLiteID = mapLiteID;
    }

    public String getMongoID() {
        return mongoID;
    }

    public void setMongoID(String mongoID) {
        this.mongoID = mongoID;
    }

    public String getMapMongoID() {
        return mapMongoID;
    }

    public void setMapMongoID(String mapMongoID) {
        this.mapMongoID = mapMongoID;
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
