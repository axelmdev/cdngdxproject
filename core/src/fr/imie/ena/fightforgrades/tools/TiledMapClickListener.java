package fr.imie.ena.fightforgrades.tools;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by nicol on 28/03/2018.
 */

public class TiledMapClickListener extends ClickListener {
    private TiledMapActor actor;

    public TiledMapClickListener(TiledMapActor actor){
        this.actor = actor;
    }


    @Override
    public void clicked(InputEvent event, float x, float y) {
        System.out.println(actor.cell +  " has been cliked");
        System.out.println("cell x : " + actor.getX());
        actor.changeTile(actor.cell);



    }
}
