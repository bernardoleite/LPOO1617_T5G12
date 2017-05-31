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

    boolean gyroscopeAvail = Gdx.input.isPeripheralAvailable(Input.Peripheral.Gyroscope);

    private ZombieInvaders game;

    public GameModel(ZombieInvaders game){
        this.game = game;

    firstLevel = new FirstLevelModel(game, this);

    }

    public FirstLevelModel getLevel(){
        return firstLevel;
    }


    public boolean isRight() {

        return Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerX() < 0 || (Gdx.input.isTouched() && game.mycam.getInputInGameWorld().x >= ZombieInvaders.WIDTH / 2);
    }

    public boolean isLeft(){
        return Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerX() > 0 || (Gdx.input.isTouched() && game.mycam.getInputInGameWorld().x < ZombieInvaders.WIDTH / 2);
    }

    public boolean isJustRight(){
        return Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || (Gdx.input.justTouched() && game.mycam.getInputInGameWorld().x >= ZombieInvaders.WIDTH / 2);
    }

    public boolean isJustLeft(){
        return Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || (Gdx.input.justTouched() && game.mycam.getInputInGameWorld().x < ZombieInvaders.WIDTH / 2);
    }

    public boolean isShooting(){
        return (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isTouched());
    }


}
