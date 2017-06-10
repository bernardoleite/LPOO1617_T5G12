package com.lpoo.zombieinvaders.Logic.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoo.zombieinvaders.Tools.Ability;
import com.lpoo.zombieinvaders.Tools.ShapeCollision;
import com.lpoo.zombieinvaders.ZombieInvaders;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bernardoleite on 27/05/17.
 */

public class ZombieModel {

    public int SPEED = 300;
    public static final int WIDTH = 36;
    public static final int HEIGHT = 36;

    public int ZOMBIE_SF_SPAWN_MIN = 150;
    public int ZOMBIE_SF_SPAWN_MAX = 350;
    public int i = 0;

    float x, y, speedFactor;
    ShapeCollision rect;
    public boolean remove = false;


    Random random;


    /**
     * Constructor to create a Zombie
     * @param x is where the zombie will be generated
     */
    public ZombieModel (float x) {
        this.x = x;
            this.y = ZombieInvaders.HEIGHT;
        this.rect = new ShapeCollision(x, y, WIDTH, HEIGHT);

    }

    /**
     * Constructor 2 to create a Zombie
     * @param x is where the zombie will be generated
     */
    public ZombieModel (float x, int velocity) {
        this.SPEED = velocity;
        this.x = x;
        this.y = ZombieInvaders.HEIGHT;
        this.rect = new ShapeCollision(x, y, WIDTH, HEIGHT);
    }

    /**
     * Updates time
     * @param deltaTime is a value of time that is constantly being updated
     */
    public void update (float deltaTime) {
        y -= (SPEED) * deltaTime;
        if (y < -HEIGHT)
            remove = true;

        rect.move(x, y);


    }



    /**
     *
     * @return position
     */
    public float getXposition(){
        return x;
    }

    /**
     *
     * @return position
     */
    public float getYposition(){
        return y;
    }

    /**
     *
     * @return virtual box for collision purposes
     */
    public ShapeCollision getCollisionRect () {
        return rect;
    }



}
