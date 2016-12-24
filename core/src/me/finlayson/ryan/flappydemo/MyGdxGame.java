package me.finlayson.ryan.flappydemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.finlayson.ryan.flappydemo.States.GameStateManager;
import me.finlayson.ryan.flappydemo.States.MenuState;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public static final String TITLE = "Flappy Bird";
	private GameStateManager gsm;
	private SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		img = new Texture("badlogic.jpg");
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		//wipes screen clean, blank canvas for the program to rewrite
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.setProjectionMatrix();
		gsm.update(Gdx.graphics.getDeltaTime());//delta is difference in render time
		gsm.render(batch);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
