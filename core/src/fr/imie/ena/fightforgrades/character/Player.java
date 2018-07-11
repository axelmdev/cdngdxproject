package fr.imie.ena.fightforgrades.character;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;


import fr.imie.ena.fightforgrades.FightForGrades;
import fr.imie.ena.fightforgrades.scenes.Hud;
import fr.imie.ena.fightforgrades.tools.TiledMapActor;

/**
 * Created by nicol on 25/04/2018.
 */

public class Player extends Character {

    private TiledMapTileLayer.Cell cell;
    private boolean isMouvementCircle = false;
    private Hud hud;

    public Player(String name, int deplacements, int positionX, int positionY, int idTile, Hud hud){
        this.name = name;
        this.deplacements = deplacements;
        this.positionX = positionX;
        this.positionY = positionY;
        this.idTile = idTile;
        this.hud = hud;
    }

    public void play(){

        this.hud.turnNumber = this.hud.turnNumber + 1;
        this.hud.updateTurn(this.hud.turnNumber);
    }

    public void move(TiledMapTileLayer tileLayer, TiledMapActor actor){
        // Remove mouvement circle
        this.toggleMouvement(tileLayer, 4, actor);

        // Get concerned cells
        TiledMapTileLayer.Cell previousCell = cell;
        TiledMapTileLayer.Cell cell = actor.cell;

        // Update cell's tile
        actor.changeTile(previousCell, 4);
        actor.changeTile(cell, 67);

        this.cell = cell;

        // Store previous positions
        this.previousPosX = this.positionX;
        this.previousPosY = this.positionY;

        // Update to new positions
        this.positionX = (int)(actor.getX() * FightForGrades.PPM / tileLayer.getTileWidth());
        this.positionY = (int)(actor.getY() * FightForGrades.PPM / tileLayer.getTileHeight());

        System.out.println("New pos X : " + this.positionX + " pos Y : " + this.positionY);

    }

    // Toggle mouvement circle
    public void toggleMouvement(TiledMapTileLayer tiledLayer, int tileId, TiledMapActor actor){

        // Upper right quarter
        for(int i = 0; i <= this.deplacements; i++){
            for(int j = 0; j <= this.deplacements - i; j++){
                if(i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY + i);
                        if(cell != null && cell.getTile().getId() != 199)
                            actor.changeTile(cell, tileId);
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY + i);
                    if(cell != null && cell.getTile().getId() != 199)
                        actor.changeTile(cell, tileId);
                }
            }
        }

        // down right quarter
        for(int i = 0; i <= this.deplacements; i++){
            for(int j = 0; j <= this.deplacements - i; j++){
                if( i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY - i);
                        if(cell != null && cell.getTile().getId() != 199)
                            actor.changeTile(cell, tileId);
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY - i);
                    if(cell != null && cell.getTile().getId() != 199)
                        actor.changeTile(cell, tileId);
                }
            }
        }

        // down left quarter
        for(int i = 0; i <= this.deplacements; i++){
            for(int j = 0; j <= this.deplacements - i; j++){
                if( i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY - i);
                        if(cell != null && cell.getTile().getId() != 199)
                            actor.changeTile(cell, tileId);
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY - i);
                    if(cell != null && cell.getTile().getId() != 199)
                        actor.changeTile(cell, tileId);
                }
            }
        }

        // upper left quarter
        for(int i = 0; i <= this.deplacements; i++){
            for(int j = 0; j <= this.deplacements - i; j++){
                if( i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY + i);
                        if(cell != null && cell.getTile().getId() != 199)
                            actor.changeTile(cell, tileId);
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY + i);
                    if(cell != null && cell.getTile().getId() != 199)
                        actor.changeTile(cell, tileId);
                }
            }
        }

        if(this.isMouvementCircle)
            this.isMouvementCircle = false;
        else
            this.isMouvementCircle = true;
    }

    public boolean isMouvementCircle() {
        return isMouvementCircle;
    }
    public void setMouvementCircle(boolean mouvementCircle) {
        isMouvementCircle = mouvementCircle;
    }


    public TiledMapTileLayer.Cell getCell() {
        return cell;
    }

    public void setCell(TiledMapTileLayer.Cell cell) {
        this.cell = cell;
    }




}
