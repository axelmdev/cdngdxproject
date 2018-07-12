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
    private boolean enemyInRange = true;
    private Hud hud;

    public Player(String name, int deplacements, int hp, int strenght, int positionX, int positionY, int idTile, Hud hud){
        this.name = name;
        this.deplacements = deplacements;
        this.positionX = positionX;
        this.positionY = positionY;
        this.idTile = idTile;
        this.hp = hp;
        this.strenght = strenght;
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

    public void attack(Enemy enemy){
        if(this.enemyInRange){
            if(enemy.hp >= this.strenght)
                enemy.hp = enemy.hp - this.strenght;
            else
                enemy.hp = 0;

            System.out.println("Enemy hp : " + enemy.hp);

        }else{
            System.out.println("Cannot attack");
        }
    }

    // Toggle mouvement circle
    public void toggleMouvement(TiledMapTileLayer tiledLayer, int tileId, TiledMapActor actor){
        this.enemyInRange = false;
        // Upper right quarter
        for(int i = 0; i <= this.deplacements; i++){
            for(int j = 0; j <= this.deplacements - i; j++){
                if(i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY + i);
                        if(cell != null) {
                            if (cell.getTile().getId() != 199) {
                                actor.changeTile(cell, tileId);
                            } else {
                                if (i == 1 || j == 1)
                                    this.enemyInRange = true;
                            }
                        }
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY + i);
                    if(cell != null) {
                        if (cell.getTile().getId() != 199) {
                            actor.changeTile(cell, tileId);
                        } else {
                            if (i == 1 || j == 1)
                                this.enemyInRange = true;
                        }
                    }
                }
            }
        }

        // down right quarter
        for(int i = 0; i <= this.deplacements; i++){
            for(int j = 0; j <= this.deplacements - i; j++){
                if( i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY - i);
                        if(cell != null) {
                            if (cell.getTile().getId() != 199) {
                                actor.changeTile(cell, tileId);
                            } else {
                                if (i == 1 || j == 1)
                                    this.enemyInRange = true;
                            }
                        }
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX + j, this.positionY - i);
                    if(cell != null) {
                        if (cell.getTile().getId() != 199) {
                            actor.changeTile(cell, tileId);
                        } else {
                            if (i == 1 || j == 1)
                                this.enemyInRange = true;
                        }
                    }
                }
            }
        }

        // down left quarter
        for(int i = 0; i <= this.deplacements; i++){
            for(int j = 0; j <= this.deplacements - i; j++){
                if( i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY - i);
                        if(cell != null) {
                            if (cell.getTile().getId() != 199) {
                                actor.changeTile(cell, tileId);
                            } else {
                                if (i == 1 || j == 1)
                                    this.enemyInRange = true;
                            }
                        }
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY - i);
                    if(cell != null) {
                        if (cell.getTile().getId() != 199) {
                            actor.changeTile(cell, tileId);
                        } else {
                            if (i == 1 || j == 1)
                                this.enemyInRange = true;
                        }
                    }
                }
            }
        }

        // upper left quarter
        for(int i = 0; i <= this.deplacements; i++){
            for(int j = 0; j <= this.deplacements - i; j++){
                if( i == 0){
                    if(j != 0){
                        TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY + i);
                        if(cell != null) {
                            if (cell.getTile().getId() != 199) {
                                actor.changeTile(cell, tileId);
                            } else {
                                if (i == 1 || j == 1)
                                    this.enemyInRange = true;
                            }
                        }
                    }
                }else{
                    TiledMapTileLayer.Cell cell = tiledLayer.getCell(this.positionX - j, this.positionY + i);
                    if(cell != null) {
                        if (cell.getTile().getId() != 199) {
                            actor.changeTile(cell, tileId);
                        } else {
                            if (i == 1 || j == 1)
                                this.enemyInRange = true;
                        }
                    }
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
