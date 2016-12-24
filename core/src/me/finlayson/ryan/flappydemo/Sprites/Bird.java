package me.finlayson.ryan.flappydemo.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by user on 24/12/2016.
 */

public class Bird {

    private static final int GRAVITY = -15;

    private Vector3 position;
    private Vector3 velocity;

    private Texture birdTexture;

    public Bird(int x, int y){
        position = new Vector3(x,y,0); //(x,y,z)
        velocity = new Vector3(0,0,0);
        birdTexture = new Texture("bird.png");
    }

    public void update(float dt){
        velocity.add(0,GRAVITY,0);
        velocity.scl(dt); //scale velocity by its change in time
        position.add(0,velocity.y,0);
        //reverse the scale so it can be added again on next frame
        velocity.scl(1/dt);
    }

    public Texture getTexture() {
        return birdTexture;
    }


    public Vector3 getPosition() {
        return position;
    }

}