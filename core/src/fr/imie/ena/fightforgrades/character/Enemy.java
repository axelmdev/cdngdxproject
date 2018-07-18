package fr.imie.ena.fightforgrades.character;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import fr.imie.ena.fightforgrades.scenes.Hud;
import fr.imie.ena.fightforgrades.screens.GameOverScreen;
import fr.imie.ena.fightforgrades.tools.TiledMapActor;

/**
 * Created by nicol on 01/06/2018.
 */

public class Enemy extends Character {

    private TiledMapTileLayer.Cell cell;
    private Hud hud;
    private Game game;

    public Enemy(String name, int deplacements, int hp, int strenght, int positionX, int positionY, int idTile, Hud hud, Game game){
        this.name = name;
        this.deplacements = deplacements;
        this.positionX = positionX;
        this.positionY = positionY;
        this.idTile = idTile;
        this.hp = hp;
        this.strenght = strenght;
        this.defense = 0;
        this.hud = hud;
        this.game = game;

        hud.updateHp(this.hp, false);
    }

    public void turn(TiledMapTileLayer tileLayer, TiledMapActor actor, Player player){
        boolean asMove = this.move(tileLayer, actor, player);

        if(!asMove){
            this.attack(player);
            if(player.hp == 0){
                game.setScreen(new GameOverScreen(game));
                //dispose();
            }else{
                player.play();
            }

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
        int attack = 1; // default attack = 1
        // if strenght > defense change attack
        if(player.defense < this.strenght){
            attack = this.strenght - player.defense;
        }

        if(player.hp >= attack){
            player.hp = player.hp - attack;
        }else{
            player.hp = 0;
        }


        hud.updateHp(player.hp, true);
        System.out.println("HP : " + player.hp);
    }

    public void setCell(TiledMapTileLayer.Cell cell) {
        this.cell = cell;
    }

    public TiledMapTileLayer.Cell getCell() {
        return cell;
    }
}
