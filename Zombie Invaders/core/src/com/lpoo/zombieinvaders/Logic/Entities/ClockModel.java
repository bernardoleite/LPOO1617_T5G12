package com.lpoo.zombieinvaders.Logic.Entities;

import com.lpoo.zombieinvaders.Tools.ShapeCollision;
import com.lpoo.zombieinvaders.ZombieInvaders;

/**
 * Created by bernardoleite on 06/06/17.
 */

public class ClockModel {

    public static final int SPEED = 250;
    public static final int WIDTH = 17;
    public static final int HEIGHT = 19;


    float x, y;
    ShapeCollision rect;
    public boolean remove = false;

    public int score;

    /**
     *
     * @param x is where the Clock will be generated
     */
    public ClockModel (float x) {
        this.x = x;
        this.y = ZombieInvaders.HEIGHT;
        this.rect = new ShapeCollision(x, y, WIDTH, HEIGHT);
    }

    /**
     *
     * @param deltaTime is the value of time that is constantly being updated
     */
    public void update (float deltaTime) {
        y -= SPEED * deltaTime;
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
