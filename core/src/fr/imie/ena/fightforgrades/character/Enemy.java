package fr.imie.ena.fightforgrades.character;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import fr.imie.ena.fightforgrades.tools.TiledMapActor;

/**
 * Created by nicol on 01/06/2018.
 */

public class Enemy extends Character {

    private TiledMapTileLayer.Cell cell;

    public Enemy(String name, int deplacements, int hp, int strenght, int positionX, int positionY, int idTile){
        this.name = name;
        this.deplacements = deplacements;
        this.positionX = positionX;
        this.positionY = positionY;
        this.idTile = idTile;
        this.hp = hp;
        this.strenght = strenght;
    }

    public void turn(TiledMapTileLayer tileLayer, TiledMapActor actor, Player player){
        boolean asMove = this.move(tileLayer, actor, player);

        if(!asMove){
            this.attack(player);
            player.play();
        }
    }

    public boolean move(TiledMapTileLayer tileLayer, TiledMapActor actor, Player player) {
        TiledMapTileLayer.Cell oldCell = tileLayer.getCell(this.positionX, this.positionY);

        for(int i = 0; i < this.deplacements; i++){
           // System.out.println("ennemie X : " + this.positionX);
            //System.out.println("ennemie Y : " + this.positionY);

            if(this.positionX < player.positionX - 1){
                //System.out.println("inferieur a X");
                this.positionX = this.positionX + 1;
                continue;
            }

            if(this.positionX > player.positionX + 1){
                //System.out.println("superieur a X");
                this.positionX = this.positionX - 1;
                continue;
            }

            if(this.positionY < player.positionY - 1){
               // System.out.println("inferieur a Y");
                this.positionY = this.positionY + 1;
                continue;
            }

            if(this.positionY > player.positionY + 1){
                //System.out.println("superieur a Y");
                this.positionY = this.positionY - 1;
                continue;
            }
        }
        TiledMapTileLayer.Cell cell = tileLayer.getCell(this.positionX, this.positionY);
        actor.changeTile(oldCell, 4);
        actor.changeTile(cell, this.idTile);

        if(oldCell != cell)
            return true;
        else
            return false;


    }

    public void attack(Player player){
        System.out.println("Enemy attack !");
        if(player.hp >= this.strenght)
            player.hp = player.hp - this.strenght;
        else
            player.hp = 0;
        System.out.println("HP : " + player.hp);
    }

    public void setCell(TiledMapTileLayer.Cell cell) {
        this.cell = cell;
    }

    public TiledMapTileLayer.Cell getCell() {
        return cell;
    }
}
