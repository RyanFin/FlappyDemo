package me.finlayson.ryan.flappydemo.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.finlayson.ryan.flappydemo.MyGdxGame;

/**
 * Created by user on 24/12/2016.
 */

public class MenuState extends State {
    private Texture background;

    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
        //cam.setToOrtho(false, MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2); //start from bottom-left origin spot, size of viewport

    }

    @Override
    public void handleInput() {

        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }

    }

    @Override
    public void update(float dt) {
        handleInput(); //check the input
    }

    @Override
    public void render(SpriteBatch sb) {
        //sb.setProjectionMatrix(cam.combined); //set the viewport
        sb.begin();
        sb.draw(background, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        sb.draw(playBtn, (MyGdxGame.WIDTH/2) - (playBtn.getWidth()/2), MyGdxGame.HEIGHT/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
