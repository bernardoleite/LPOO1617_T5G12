package com.lpoo.zombieinvaders.Logic.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by bernardoleite on 27/05/17.
 */

public class ExplosionModel {

    public static final float DURATION_FRAME = 0.2f;
    public static final int OFFSET = 0;
    public static final int EXPLOSION_SIZE = 32;

    private static Animation<TextureRegion> explosion = null;
    float x,y;
    float timestate;

    public boolean remove = false;


    /**
     * Constructor to generator an explosion
     * @param x position
     * @param y position
     */
    public ExplosionModel(float x, float y){
        this.x = x - OFFSET;
        this.y = y - OFFSET;
        timestate = 0;

        if (explosion == null)
            explosion = new Animation(DURATION_FRAME, TextureRegion.split(new Texture("explosion.png"), EXPLOSION_SIZE, EXPLOSION_SIZE )[0]);

    }

    /**
     * Update constantly
     * @param deltaTime is a value that is constantly being updated
     */
    public void update (float deltaTime){
        timestate += deltaTime;
        if(explosion.isAnimationFinished(timestate)){
            remove = true;
        }
    }

    /**
     *
     * @param batch is for animation purposes
     */
    public void render (SpriteBatch batch){
        batch.draw(explosion.getKeyFrame(timestate), x , y);
    }


}


