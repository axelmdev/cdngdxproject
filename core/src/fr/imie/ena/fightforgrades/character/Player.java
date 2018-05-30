package fr.imie.ena.fightforgrades.character;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;


import fr.imie.ena.fightforgrades.FightForGrades;
import fr.imie.ena.fightforgrades.tools.TiledMapActor;

/**
 * Created by nicol on 25/04/2018.
 */

public class Player {

    public int nbDeplacements;
    public String name;
    public int idTile = 67;
    public int positionX;
    public int positionY;
    public boolean isMouvementCircle = false;

    public Player(String name, int nbDeplacements, int positionX, int positionY){
        this.name = name;
        this.nbDeplacements = nbDeplacements;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void move(TiledMapTile tile, TiledMapTileLayer tileLayer, TiledMapActor actor){
        this.toggleMouvement(tileLayer, 4, actor);

        TiledMapTileLayer.Cell previousCell = tileLayer.getCell(this.positionX, this.positionY);
        TiledMapTileLayer.Cell cell = actor.cell;

        actor.changeTile(previousCell, 4);
        actor.changeTile(cell, 67);
        this.positionX = (int)(actor.getX() * FightForGrades.PPM / tileLayer.getTileWidth());
        this.positionY = (int)(actor.getY() * FightForGrades.PPM / tileLayer.getTileHeight());

        System.out.println("New pos X : " + this.positionX + " pos Y : " + this.positionY);

    }

    // Toggle mouvement circle
    public void toggleMouvement(TiledMapTileLayer tiledLayer, int tileId, TiledMapActor actor){

        // Upper right quarter
        for(int i = 0; i <= this.nbDeplacements; i++){
            for(int j = 0; j <= this.nbDeplacements - i; j++){
                if(i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY + i);
                        if(cell != null)
                            actor.changeTile(cell, tileId);
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY + i);
                    if(cell != null)
                        actor.changeTile(cell, tileId);
                }
            }
        }

        // down right quarter
        for(int i = 0; i <= this.nbDeplacements; i++){
            for(int j = 0; j <= this.nbDeplacements - i; j++){
                if( i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY - i);
                        if(cell != null)
                            actor.changeTile(cell, tileId);
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY - i);
                    if(cell != null)
                        actor.changeTile(cell, tileId);
                }
            }
        }

        // down left quarter
        for(int i = 0; i <= this.nbDeplacements; i++){
            for(int j = 0; j <= this.nbDeplacements - i; j++){
                if( i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY - i);
                        if(cell != null)
                            actor.changeTile(cell, tileId);
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY - i);
                    if(cell != null)
                        actor.changeTile(cell, tileId);
                }
            }
        }

        // upper left quarter
        for(int i = 0; i <= this.nbDeplacements; i++){
            for(int j = 0; j <= this.nbDeplacements - i; j++){
                if( i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY + i);
                        if(cell != null)
                            actor.changeTile(cell, tileId);
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY + i);
                    if(cell != null)
                        actor.changeTile(cell, tileId);
                }
            }
        }

        if(this.isMouvementCircle)
            this.isMouvementCircle = false;
        else
            this.isMouvementCircle = true;
    }
}
