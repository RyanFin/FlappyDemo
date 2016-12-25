package me.finlayson.ryan.flappydemo.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by user on 24/12/2016.
 */

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager() {
        states = new Stack<State>();
    }

    //push a state to the top of the stack
    public void push(State state){
        states.push(state);
    }

    //pop a state off the top of the State stack
    public void pop(){
        states.pop().dispose();
    }

    //pop off top stack and add new stack (2 in 1!)
    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    //delta is the change in time between two renders
    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

}
