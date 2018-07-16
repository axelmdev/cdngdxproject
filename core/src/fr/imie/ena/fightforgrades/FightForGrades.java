package fr.imie.ena.fightforgrades;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.graphics.OrthographicCamera;

import fr.imie.ena.fightforgrades.screens.MainMenuScreen;

public class FightForGrades extends Game {

    public static final int V_WIDTH = 256;
    public static final int V_HEIGHT = 128;
    public static final float PPM = 100;
    public MyAssetManager myAssetManager = new MyAssetManager();
    public ScreenViewport screenPort;

    public SpriteBatch batch;
    Texture img;

    @Override
    public void create () {
        batch = new SpriteBatch();
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false);
        screenPort = new ScreenViewport();

        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void dispose () {
        batch.dispose();
    }
    public void gotoMenuScreen(){
        MainMenuScreen mainMenuScreen = new MainMenuScreen(this);
        setScreen(mainMenuScreen);
    }
}