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
    private static Texture texture;

    float x, y;
    ShapeCollision rect;
    public boolean remove = false;

    public BulletModel (float x) {
        this.x = x;
        this.y = DEFAULT_Y;

        this.rect = new ShapeCollision(x, y,WIDTH, HEIGHT);

        if (texture == null)
            texture = new Texture("bullet.png");
    }

    public void update (float deltaTime) {
        y += SPEED * deltaTime;
        if (y > ZombieInvaders.HEIGHT)
            remove = true;

        rect.move(x,y);
    }

    public void render (SpriteBatch batch) {
        batch.draw(texture, x, y);
    }


    public ShapeCollision getShapeCollision(){
        return rect;
    }
}
