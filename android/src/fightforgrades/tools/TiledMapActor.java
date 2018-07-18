package fightforgrades.tools;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import fightforgrades.character.Player;


/**
 * Created by nicol on 28/03/2018.
 */

public class TiledMapActor extends Actor {

    private TiledMap tiledMap;
    private TiledMapTileLayer tileLayer;
    public TiledMapTileLayer.Cell cell;
    public Player player;

    public TiledMapActor(TiledMap tiledMap, TiledMapTileLayer tileLayer, TiledMapTileLayer.Cell cell){
        this.tiledMap = tiledMap;
        this.tileLayer = tileLayer;
        this.cell = cell;
    }

    public void changeTile(TiledMapTileLayer.Cell cell, int id){
        cell.setTile(tiledMap.getTileSets().getTile(id));
    }

}
