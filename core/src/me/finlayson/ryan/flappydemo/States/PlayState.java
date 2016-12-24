package me.finlayson.ryan.flappydemo.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.finlayson.ryan.flappydemo.MyGdxGame;
import me.finlayson.ryan.flappydemo.Sprites.Bird;

/**
 * Created by user on 24/12/2016.
 */

public class PlayState extends State {

    private Bird bird;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50,300);
        cam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
