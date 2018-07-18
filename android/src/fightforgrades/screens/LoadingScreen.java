package fightforgrades.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;

import fightforgrades.FightForGrades;
import fightforgrades.GameConstants;

public class LoadingScreen implements Screen {

    final FightForGrades game;
    /*private Texture badlogic;*/
    private Skin mySkin;
    private Stage stage;

    public LoadingScreen(final FightForGrades game, TextField usernameTextField, TextField passwordField) {
        this.game = game;
        game.myAssetManager.queueAddSkin();
        game.myAssetManager.manager.finishLoading();
        mySkin = game.myAssetManager.manager.get(GameConstants.skin);
        stage = new Stage(game.screenPort);
        Gdx.input.setInputProcessor(stage);
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        Label gameTitle = new Label("Loading",mySkin,"big");
        gameTitle.setSize(GameConstants.col_width*2, GameConstants.row_height*2);
        gameTitle.setPosition(GameConstants.centerX - gameTitle.getWidth()/2, GameConstants.centerY + GameConstants.row_height);
        gameTitle.setAlignment(Align.center);
        stage.addActor(gameTitle);
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
