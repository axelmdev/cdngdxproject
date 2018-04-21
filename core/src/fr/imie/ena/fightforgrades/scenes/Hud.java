package fr.imie.ena.fightforgrades.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.imie.ena.fightforgrades.FightForGrades;

/**
 * Created by nicol on 28/03/2018.
 */

public class Hud {
    public Stage stage;
    private Viewport viewport;

    Label testLabel;

    public Hud(SpriteBatch sb){
        viewport = new FitViewport(FightForGrades.V_WIDTH, FightForGrades.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        testLabel = new Label("FIGHT FOR GRADES", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(testLabel).expandX();
        stage.addActor(table);
    }

}
