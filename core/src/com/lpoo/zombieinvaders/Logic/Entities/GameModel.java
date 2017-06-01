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

    public GameModel(ZombieInvaders game){
        this.game = game;

    firstLevel = new FirstLevelModel(game, this);


    }

    public FirstLevelModel getLevel(){
        return firstLevel;
    }


    public void MoveRight(){

        this.moveRight = true;
        this.moveLeft = false;
        this.shooting = false;
    }

    public void MoveLeft(){

        this.moveRight = false;
        this.moveLeft = true;
        this.shooting = false;
    }

    public void Shoot(){

        this.moveRight = false;
        this.moveLeft = false;
        this.shooting = true;
    }


    public boolean isRight() {

        if (firstLevel.areWeTesting == true){
            if (moveRight == true )
                return true;

            else return false;
        }

        return Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerX() < 0 || (Gdx.input.isTouched() && game.mycam.getInputInGameWorld().x >= ZombieInvaders.WIDTH / 2);
    }

    public boolean isLeft(){

        if (firstLevel.areWeTesting == true){
            if (moveLeft == true )
                return true;

            else return false;
        }


        return Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerX() > 0 || (Gdx.input.isTouched() && game.mycam.getInputInGameWorld().x < ZombieInvaders.WIDTH / 2);
    }

    public boolean isJustRight(){

        if (firstLevel.areWeTesting == true){
            if (moveRight == true )
                return true;

            else return false;
        }


        return Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || (Gdx.input.justTouched() && game.mycam.getInputInGameWorld().x >= ZombieInvaders.WIDTH / 2);
    }

    public boolean isJustLeft(){

        if (firstLevel.areWeTesting == true){
            if (moveLeft == true )
                return true;

            else return false;
        }


        return Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || (Gdx.input.justTouched() && game.mycam.getInputInGameWorld().x < ZombieInvaders.WIDTH / 2);
    }

    public boolean isShooting(){

        if (firstLevel.areWeTesting == true){
            if (shooting == true )
                return true;

            else return false;
        }

        return (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isTouched());
    }


}
