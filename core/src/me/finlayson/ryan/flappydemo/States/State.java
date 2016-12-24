package me.finlayson.ryan.flappydemo.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import me.finlayson.ryan.flappydemo.MyGdxGame;

/**
 * Created by user on 24/12/2016.
 */

public abstract class State {
    protected OrthographicCamera cam;
    protected Viewport viewport;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    //constructor
    protected State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        //viewport = new FitViewport(MyGdxGame.WIDTH,MyGdxGame.HEIGHT,cam);
        mouse = new Vector3();
    }

    public abstract void handleInput();
    public abstract void update(float dt); //delta is the difference between one screen rendered and another screen rendered
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

    /*
    public void resize(int width, int height){
        viewport.update(width,height);
    }*/


}
