package fightforgrades.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fightforgrades.FightForGrades;
import fightforgrades.character.Enemy;
import fightforgrades.character.Player;
import fightforgrades.scenes.Hud;
import fightforgrades.tools.TiledMapStage;

/**
 * Created by nicol on 28/03/2018.
 */

public class PlayScreen implements Screen {
    private FightForGrades game;

    //cam
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;

    // map
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private TiledMapStage clickListener;

    //Player
    Player player;
    Enemy ennemy;


    public PlayScreen(FightForGrades game, int buttonId){
        this.game = game;

        gamecam = new OrthographicCamera();
        gamePort = new FitViewport( FightForGrades.V_WIDTH / FightForGrades.PPM, FightForGrades.V_HEIGHT / FightForGrades.PPM, gamecam);
        hud = new Hud(game.batch);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("brick_test.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / FightForGrades.PPM);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        TiledMapTileLayer tileId = (TiledMapTileLayer)map.getLayers().get(0);

        System.out.println("buttonid : "+buttonId);

        switch(buttonId){
            case 0:
                player = new Player("Edge", 2, 6, 6, 67, 10, 2, 1, hud, game);
                ennemy = new Enemy("Formateur", 2, 12, 6, 199, 5, 2, 1, hud, game);
                break;

            case 1:
                player = new Player("Edge", 2, 6, 6, 67, 10, 2, 1, hud, game);
                ennemy = new Enemy("Formateur", 2, 12, 6, 199, 5, 2, 1, hud, game);
                break;

            case 2:
                player = new Player("Edge", 2, 6, 6, 67, 10, 2, 1, hud, game);
                ennemy = new Enemy("Formateur", 2, 12, 6, 199, 5, 2, 1, hud, game);
                break;
        }
        //  Set player position

        TiledMapTileLayer.Cell cell = tileId.getCell(player.positionX, player.positionY);
        cell.setTile(map.getTileSets().getTile(player.idTile));
        player.setCell(cell);

        // Set ennemy position

        TiledMapTileLayer.Cell ennemyCell = tileId.getCell(ennemy.positionX, ennemy.positionY);
        ennemyCell.setTile(map.getTileSets().getTile(ennemy.idTile));
        ennemy.setCell(ennemyCell);


        clickListener = new TiledMapStage(map, player, ennemy);
        clickListener.setViewport(gamePort);
        Gdx.input.setInputProcessor(clickListener);
    }


    @Override
    public void show() {

    }

    public void handleInput(float dt){

    }

    public void update(float dt){
        handleInput(dt);

        gamecam.update();
        renderer.setView(gamecam);
        hud.stage.draw();
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0 ,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        clickListener.getViewport().setCamera(gamecam);
        clickListener.act();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();


    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
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

    }
}
