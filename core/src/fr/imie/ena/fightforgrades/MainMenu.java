package fr.imie.ena.fightforgrades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import fr.imie.ena.fightforgrades.GameConstants;
import fr.imie.ena.fightforgrades.FightForGrades;

public class MainMenu implements Screen {
    final FightForGrades game;
    /*private Texture badlogic;*/
    private Skin mySkin;
    private Stage stage;

    public MainMenu(final FightForGrades game){
        this.game = game;
        game.myAssetManager.queueAddSkin();
        game.myAssetManager.manager.finishLoading();
        mySkin = game.myAssetManager.manager.get(GameConstants.skin);
        /*badlogic = new Texture(Gdx.files.internal("badlogic.jpg"));*/
        /*mySkin = new Skin(Gdx.files.internal(GameConstants.skin));*/
        stage = new Stage(game.screenPort);
        Gdx.input.setInputProcessor(stage);


        Label gameTitle = new Label("GAME MENU",mySkin,"big");
        gameTitle.setSize(GameConstants.col_width*2,GameConstants.row_height*2);
        gameTitle.setPosition(GameConstants.centerX - gameTitle.getWidth()/2,GameConstants.centerY + GameConstants.row_height);
        gameTitle.setAlignment(Align.center);

        Button startBtn = new TextButton("START GAME",mySkin,"small");
        startBtn.setSize(GameConstants.col_width*2,GameConstants.row_height);
        startBtn.setPosition(GameConstants.centerX - startBtn.getWidth()/2,GameConstants.centerY);
        startBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button settingsBtn = new TextButton("SETTINGS",mySkin,"small");
        settingsBtn.setSize(GameConstants.col_width*2,GameConstants.row_height);
        settingsBtn.setPosition(GameConstants.centerX - settingsBtn.getWidth()/2,startBtn.getY() - GameConstants.row_height -15);
        settingsBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });


        stage.addActor(gameTitle);
        stage.addActor(startBtn);
        stage.addActor(settingsBtn);


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