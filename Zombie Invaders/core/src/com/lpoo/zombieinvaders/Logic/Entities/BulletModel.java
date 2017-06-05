package com.lpoo.zombieinvaders.Logic.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoo.zombieinvaders.Tools.ShapeCollision;
import com.lpoo.zombieinvaders.ZombieInvaders;

/**
 * Created by bernardoleite on 27/05/17.
 */

public class BulletModel {

    public static final int SPEED = 500;
    public static final int DEFAULT_Y = 40;
    public static final int WIDTH = 3;
    public static final int HEIGHT = 12;


    float x, y;
    ShapeCollision rect;
    public boolean remove = false;

    /**
     *
     * @param x is where bullet will be generadted
     */
    public BulletModel (float x) {
        this.x = x + 30;
        this.y = DEFAULT_Y;

        this.rect = new ShapeCollision(x, y,WIDTH, HEIGHT);


    }

    /**
     *
     * @param deltaTime is a value of time that is constantly being updated
     */
    public void update (float deltaTime) {
        y += SPEED * deltaTime;
        if (y > ZombieInvaders.HEIGHT)
            remove = true;

        rect.move(x,y);
    }


    /**
     *
     * @return rectangle box for collision purposes
     */
    public ShapeCollision getShapeCollision(){
        return rect;
    }

    /**
     *
     * @return position
     */
    public float getX(){
        return x;
    }

    /**
     *
     * @return position
     */
    public float getY(){
        return y;
    }
}
