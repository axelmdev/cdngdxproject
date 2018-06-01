package fr.imie.ena.fightforgrades.tools;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

import fr.imie.ena.fightforgrades.FightForGrades;
import fr.imie.ena.fightforgrades.character.Player;

/**
 * Created by nicol on 28/03/2018.
 */

public class TiledMapStage extends Stage {
    private TiledMap tiledMap;
    private Player player;

    public TiledMapStage(TiledMap tiledMap, Player player){
        this.tiledMap = tiledMap;
        this.player = player;

        for(MapLayer layer : tiledMap.getLayers()){

            TiledMapTileLayer tiledLayer = (TiledMapTileLayer)layer;
            createActorForLayer(tiledLayer, player);
        }
    }

    private void createActorForLayer(TiledMapTileLayer tiledLayer, Player player){
        for(int x = 0; x < tiledLayer.getWidth(); x++){
            for(int y = 0; y < tiledLayer.getHeight(); y++){
               // System.out.println("x : " + x * tiledLayer.getTileWidth() + " y : " + y * tiledLayer.getTileHeight());
               // System.out.println("width : " + tiledLayer.getTileWidth() + " height : " + tiledLayer.getTileHeight());
                TiledMapTileLayer.Cell cell = tiledLayer.getCell(x, y);

                TiledMapActor actor = new TiledMapActor(tiledMap, tiledLayer, cell);

                if(player.positionX == x && player.positionY == y) {
                    actor.player = player;
                }

                actor.setBounds((x * tiledLayer.getTileWidth()) / FightForGrades.PPM, (y * tiledLayer.getTileHeight()) / FightForGrades.PPM, tiledLayer.getTileWidth() / FightForGrades.PPM, tiledLayer.getTileHeight() / FightForGrades.PPM);
                addActor(actor);
                EventListener eventListener = new TiledMapClickListener(actor, tiledLayer, player);
                actor.addListener(eventListener);
            }
        }
    }
}
