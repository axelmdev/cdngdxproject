package fr.imie.ena.fightforgrades.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;

import fr.imie.ena.fightforgrades.FightForGrades;
import fr.imie.ena.fightforgrades.GameConstants;

public class SelectPartyScreen implements Screen {
    final FightForGrades game;
    /*private Texture badlogic;*/
    private Skin mySkin;
    private Stage stage;

    public SelectPartyScreen(final FightForGrades game) {
        this.game = game;
        game.myAssetManager.queueAddSkin();
        game.myAssetManager.manager.finishLoading();
        mySkin = game.myAssetManager.manager.get(GameConstants.skin);
        /*badlogic = new Texture(Gdx.files.internal("badlogic.jpg"));*/
        /*mySkin = new Skin(Gdx.files.internal(GameConstants.skin));*/
        stage = new Stage(game.screenPort);
        Gdx.input.setInputProcessor(stage);

        Label gameTitle = new Label("Select a game",mySkin,"big");
        gameTitle.setSize(GameConstants.col_width*2,GameConstants.row_height*2);
        gameTitle.setPosition(GameConstants.centerX - gameTitle.getWidth()/2,GameConstants.centerY + GameConstants.row_height);
        gameTitle.setAlignment(Align.center);

        Button party1Btn = new TextButton("Party 1",mySkin,"small");
        party1Btn.setSize(GameConstants.col_width*2,GameConstants.row_height);
        party1Btn.setPosition(GameConstants.centerX - party1Btn.getWidth()/2,GameConstants.centerY);
        party1Btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new PlayScreen((FightForGrades) game));
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button party2Btn = new TextButton("Party 2",mySkin,"small");
        party2Btn.setSize(GameConstants.col_width*2,GameConstants.row_height);
        party2Btn.setPosition(GameConstants.centerX - party2Btn.getWidth()/2,party1Btn.getY() - GameConstants.row_height -15);
        party2Btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new PlayScreen((FightForGrades) game));
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button party3Btn = new TextButton("Party 3",mySkin,"small");
        party3Btn.setSize(GameConstants.col_width*2,GameConstants.row_height);
        party3Btn.setPosition(GameConstants.centerX - party3Btn.getWidth()/2,party2Btn.getY() - GameConstants.row_height -15);
        party3Btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new PlayScreen((FightForGrades) game));
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        stage.addActor(gameTitle);
        stage.addActor(party1Btn);
        stage.addActor(party2Btn);
        stage.addActor(party3Btn);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        game.screenPort.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        mySkin.dispose();
        stage.dispose();
    }
}
