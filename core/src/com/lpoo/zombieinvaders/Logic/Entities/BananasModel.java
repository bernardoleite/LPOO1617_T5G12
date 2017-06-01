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

    public BananasModel (float x) {
        this.x = x;
        this.y = ZombieInvaders.HEIGHT;
        this.rect = new ShapeCollision(x, y, WIDTH, HEIGHT);
    }

    public void update (float deltaTime) {
        y -= SPEED * deltaTime;
        if (y < -HEIGHT)
            remove = true;

        rect.move(x, y);
    }

    public float getXposition(){
        return x;
    }

    public float getYposition(){
        return y;
    }


    public ShapeCollision getCollisionRect () {
        return rect;
    }
}
