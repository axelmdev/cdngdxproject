package fr.imie.ena.fightforgrades.character;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import fr.imie.ena.fightforgrades.tools.TiledMapActor;

/**
 * Created by nicol on 01/06/2018.
 */

public abstract class Character {

    public int deplacements;
    public String name;
    public int idTile;
    public int previousPosX;
    public int previousPosY;
    public int positionX;
    public int positionY;
    public int hp;
    public int strenght;

}
