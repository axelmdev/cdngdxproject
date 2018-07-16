package com.ffg.Models;

/**
 * Created by edern on 07/07/2018.
 */

public class Case {
    private Integer liteID;
    private Integer mapLiteID;
    private Integer charLiteID;
    private String mongoID;
    private String mapMongoID;
    private String charMongoID;
    private boolean usable;
    private String img;

    public static String GetNameUrlVersion(){
        return "Cases";
    }

    public Integer getLiteID() {
        return liteID;
    }

    public void setLiteID(Integer liteID) {
        this.liteID = liteID;
    }

    public Integer getMapLiteID() {
        return mapLiteID;
    }

    public void setMapLiteID(Integer mapLiteID) {
        this.mapLiteID = mapLiteID;
    }

    public Integer getCharLiteID() {
        return charLiteID;
    }

    public void setCharLiteID(Integer charLiteID) {
        this.charLiteID = charLiteID;
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

    public String getCharMongoID() {
        return charMongoID;
    }

    public void setCharMongoID(String charMongoID) {
        this.charMongoID = charMongoID;
    }

    public boolean getUsable() {
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
