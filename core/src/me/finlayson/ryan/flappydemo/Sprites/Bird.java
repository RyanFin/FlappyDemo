package me.finlayson.ryan.flappydemo.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by user on 24/12/2016.
 */

public class Bird {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;

    private Texture birdTexture;

    private Rectangle bounds;

    public Bird(int x, int y){
        position = new Vector3(x,y,0); //(x,y,z)
        velocity = new Vector3(0,0,0);
        birdTexture = new Texture("bird.png");
        bounds = new Rectangle(x,y,birdTexture.getWidth(),birdTexture.getHeight());
    }

    public void update(float dt){
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

    public Texture getTexture() {
        return birdTexture;
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
        birdTexture.dispose();
    }

}
