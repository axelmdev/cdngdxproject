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
        TiledMapTileLayer.Cell oldCell = tileLayer.getCell(this.positionX, this.positionY);

        for(int i = 0; i < this.deplacements; i++){
            System.out.println("ennemie X : " + this.positionX);
            System.out.println("ennemie Y : " + this.positionY);
            if(this.positionX != player.positionX || this.positionY != player.positionY){
                if(this.positionX < player.positionX && (this.positionX != player.positionX || this.positionY != player.positionY)){
                    System.out.println("inferieur a X");
                    this.positionX = this.positionX + 1;
                    continue;
                }
                if(this.positionX > player.positionX){
                    System.out.println("superieur a X");
                    this.positionX = this.positionX - 1;
                    continue;
                }
                if(this.positionY < player.positionY){
                    System.out.println("inferieur a Y");
                    this.positionY = this.positionY + 1;
                    continue;
                }
                if(this.positionY > player.positionY){
                    System.out.println("superieur a Y");
                    this.positionY = this.positionY - 1;
                    continue;
                }
                    //System.out.println("Y mouvement");


            }
        }
        TiledMapTileLayer.Cell cell = tileLayer.getCell(this.positionX, this.positionY);
        actor.changeTile(oldCell, 4);
        actor.changeTile(cell, this.idTile);

        player.play();
    }

    public void setCell(TiledMapTileLayer.Cell cell) {
        this.cell = cell;
    }

    public TiledMapTileLayer.Cell getCell() {
        return cell;
    }
}
