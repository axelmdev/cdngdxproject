package fr.imie.ena.fightforgrades.character;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import fr.imie.ena.fightforgrades.tools.TiledMapActor;

/**
 * Created by nicol on 01/06/2018.
 */

public class Enemy extends Character {

    private TiledMapTileLayer.Cell cell;

    public Enemy(String name, int deplacements, int positionX, int positionY, int idTile){
        this.name = name;
        this.deplacements = deplacements;
        this.positionX = positionX;
        this.positionY = positionY;
        this.idTile = idTile;
    }

    public void move(TiledMapTileLayer tileLayer, TiledMapActor actor, Player player) {

    }

    public void setCell(TiledMapTileLayer.Cell cell) {
        this.cell = cell;
    }

    public TiledMapTileLayer.Cell getCell() {
        return cell;
    }
}
