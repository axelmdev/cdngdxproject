package fr.imie.ena.fightforgrades;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.imie.ena.fightforgrades.screens.PlayScreen;

public class FightForGrades extends Game {

	public static final int V_WIDTH = 256;
	public static final int V_HEIGHT = 128;
	public static final float PPM = 100;

	public SpriteBatch batch;
	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();

		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
