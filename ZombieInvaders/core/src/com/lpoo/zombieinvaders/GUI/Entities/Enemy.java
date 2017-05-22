package com.lpoo.zombieinvaders.GUI.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.lpoo.zombieinvaders.GUI.PlayScreen;

/**
 * Created by bernardoleite on 21/05/17.
 */

public abstract class Enemy extends Sprite{

    protected World world;
    protected PlayScreen screen;
    public Body b2body;

    //18- Moving Enemy
    public Vector2 velocity;


    public Enemy (PlayScreen screen, float x, float y){

        this.world = screen.getWorld();
        this.screen = screen;
        setPosition(x, y);
        defineEnemy();

        //18- Moving Enemy
        velocity = new Vector2(1, 0);
    }

    protected abstract void defineEnemy();

    //17
    public abstract void hitOnHead();

    //18
    public void reverseVelocity(boolean x, boolean y) {

        if(x) velocity.x = -velocity.x;
        if(y) velocity.y = -velocity.y;
    }

}
