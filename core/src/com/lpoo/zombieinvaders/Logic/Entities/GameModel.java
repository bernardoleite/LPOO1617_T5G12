package com.lpoo.zombieinvaders.Logic.Entities;

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


    public GameModel(ZombieInvaders game){

    firstLevel = new FirstLevelModel(game);

    }

    public FirstLevelModel getLevel(){
        return firstLevel;
    }
}
