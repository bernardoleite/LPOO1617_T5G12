package com.lpoo.zombieinvaders.Logic.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoo.zombieinvaders.Tools.ShapeCollision;
import com.lpoo.zombieinvaders.ZombieInvaders;

/**
 * Created by bernardoleite on 31/05/17.
 */

public class BananasModel {

    public static final int SPEED = 250;
    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;

    float x, y;
    ShapeCollision rect;
    public boolean remove = false;

    /**
     *
     * @param x is where the banana will be generated
     */
    public BananasModel (float x) {
        this.x = x;
        this.y = ZombieInvaders.HEIGHT;
        this.rect = new ShapeCollision(x, y, WIDTH, HEIGHT);
    }

    /**
     *
     * @param deltaTime is a value of time that is constantly updated
     */
    public void update (float deltaTime) {
        y -= SPEED * deltaTime;
        if (y < -HEIGHT)
            remove = true;

        rect.move(x, y);
    }

    /**
     *
     * @return the position
     */
    public float getXposition(){
        return x;
    }

    /**
     *
     * @return the position
     */
    public float getYposition(){
        return y;
    }


    /**
     *
     * @return the virtual box that has the object for collision purposes
     */
    public ShapeCollision getCollisionRect () {
        return rect;
    }
}
