package fightforgrades.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fightforgrades.FightForGrades;

/**
 * Created by nicol on 28/03/2018.
 */

public class Hud {
    public Stage stage;
    private Label turnLabel;
    private Label playerHpLabel;
    private Label enemyHpLabel;
    public int turnNumber = 1;
    public int playerHp = 1;
    public int enemyHp = 1;
    private Viewport viewport;

    public Hud(SpriteBatch sb){
        viewport = new FitViewport(FightForGrades.V_WIDTH, FightForGrades.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        turnLabel = new Label("TURN : "+this.turnNumber, new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        playerHpLabel = new Label("Player HP : "+this.playerHp, new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        enemyHpLabel = new Label("Player HP : "+this.enemyHp, new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        Table tableTop = new Table();
        tableTop.top();
        tableTop.setFillParent(true);
        tableTop.add(turnLabel).expandX();


        Table tableBottom = new Table();
        tableBottom.bottom();
        tableBottom.setFillParent(true);

        tableBottom.add(playerHpLabel).expandX();
        tableBottom.add(enemyHpLabel).expandX();

        stage.addActor(tableTop);
        stage.addActor(tableBottom);
    }

    public void updateTurn(int turnNumber){
        turnLabel.setText("TURN : "+turnNumber);
    }

    public void updateHp(int HP, boolean isPlayer){
        if(isPlayer){
            playerHpLabel.setText("Player HP : "+HP);
        }else{
            enemyHpLabel.setText("Enemy HP : "+HP);
        }
    }

}
