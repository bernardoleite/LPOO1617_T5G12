package com.lpoo.zombieinvaders.Logic.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.lpoo.zombieinvaders.Tools.ShapeCollision;
import com.lpoo.zombieinvaders.ZombieInvaders;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bernardoleite on 27/05/17.
 */

public class GameModel {

private FirstLevelModel firstLevel;


    private ZombieInvaders game;

    public boolean moveRight = false;
    public boolean moveLeft = false;
    public boolean shooting = false;

    /**
     *
     * @param game is the main object from Libgdx Class generator of game
     */
    public GameModel(ZombieInvaders game){
        this.game = game;

    firstLevel = new FirstLevelModel(game, this);


    }

    /**
     *
     * @return the current level
     */
    public FirstLevelModel getLevel(){
        return firstLevel;
    }

    /**
     * This function allows the right movement
     */

    public void MoveRight(){

        this.moveRight = true;
        this.moveLeft = false;
        this.shooting = false;
    }

    /**
     * This function allows the left movement
     */
    public void MoveLeft(){

        this.moveRight = false;
        this.moveLeft = true;
        this.shooting = false;
    }

    /**
     * This function allows the shooting
     */
    public void Shoot(){

        this.moveRight = false;
        this.moveLeft = false;
        this.shooting = true;
    }


    /**
     *
     * @return catches all kind of events
     */
    public boolean isRight() {

        if (firstLevel.thebool == true){
            if (moveRight == true )
                return true;

            else return false;
        }

        return Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerX() < 0 || (Gdx.input.isTouched() && game.mycam.getInputInGameWorld().x >= ZombieInvaders.WIDTH / 2);
    }

    /**
     *
     * @return catches all kind of events
     */
    public boolean isLeft(){

        if (firstLevel.thebool == true){
            if (moveLeft == true )
                return true;

            else return false;
        }


        return Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerX() > 0 || (Gdx.input.isTouched() && game.mycam.getInputInGameWorld().x < ZombieInvaders.WIDTH / 2);
    }

    /**
     *
     * @return catches all kind of events
     */
    public boolean isJustRight(){

        if (firstLevel.thebool == true){
            if (moveRight == true )
                return true;

            else return false;
        }


        return Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || (Gdx.input.justTouched() && game.mycam.getInputInGameWorld().x >= ZombieInvaders.WIDTH / 2);
    }

    /**
     *
     * @return catches all kind of events
     */
    public boolean isJustLeft(){

        if (firstLevel.thebool == true){
            if (moveLeft == true )
                return true;

            else return false;
        }


        return Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || (Gdx.input.justTouched() && game.mycam.getInputInGameWorld().x < ZombieInvaders.WIDTH / 2);
    }

    /**
     *
     * @return catches all kind of events
     */
    public boolean isShooting(){

        if (firstLevel.thebool == true){
            if (shooting == true )
                return true;

            else return false;
        }

        return (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isTouched());
    }

    public FirstLevelModel getmodel(){
        return firstLevel;
    }


}
