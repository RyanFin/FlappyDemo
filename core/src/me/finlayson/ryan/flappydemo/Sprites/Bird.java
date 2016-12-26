package me.finlayson.ryan.flappydemo.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by user on 24/12/2016.
 */

public class Bird {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 130;

    private Vector3 position;
    private Vector3 velocity;

    private Texture texture;

    private Rectangle bounds;
    private Animation birdAnimation;

    public Bird(int x, int y){
        position = new Vector3(x,y,0); //(x,y,z)
        velocity = new Vector3(0,0,0);
        //display bird animation rather than a single bird image
        texture = new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        bounds = new Rectangle(x,y,texture.getWidth() / 3, texture.getHeight());
    }

    public void update(float dt){
        birdAnimation.update(dt);
        if(position.y > 0){
            velocity.add(0,GRAVITY,0);
        }

        velocity.scl(dt); //scale velocity by its change in tim
        position.add(MOVEMENT * dt,velocity.y,0);
        //reverse the scale so it can be added again on next frame

        if(position.y < 0){
            position.y = 0;
        }

        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }


    public Vector3 getPosition() {
        return position;
    }

    public void jump(){
        velocity.y = 250;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void dispose(){
        texture.dispose();
    }

}
