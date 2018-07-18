package fightforgrades.tools;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fightforgrades.character.Enemy;
import fightforgrades.character.Player;

/**
 * Created by nicol on 28/03/2018.
 */

public class TiledMapClickListener extends ClickListener {
    private TiledMapActor actor;
    private TiledMapTileLayer tiledLayer;
    private Player player;
    private Enemy enemy;

    public TiledMapClickListener(TiledMapActor actor, TiledMapTileLayer tiledLayer, Player player, Enemy enemy){
        this.actor = actor;
        this.tiledLayer = tiledLayer;
        this.player = player;
        this.enemy = enemy;
    }


    @Override
    public void clicked(InputEvent event, float x, float y) {

        switch(actor.cell.getTile().getId()){
            case 67: // Joueur
                System.out.println("Player cell");
                player.toggleMouvement(tiledLayer, 69, actor);
                break;

            case 69: // Mouvement circle
                System.out.println("Player mouvement");
                player.move(tiledLayer, actor, enemy);
                break;

            case 199: // Enemy
                System.out.println("Enemy !");
                player.attack(tiledLayer, actor, enemy);
                break;

            default:
                //actor.changeTile(actor.cell, 2);
                System.out.println("NOT PLAYER");
                if(player.isMouvementCircle()){
                    System.out.println("IS CIRCLE");
                    player.toggleMouvement(tiledLayer, 4, actor);
                }
        }




    }
}
