package com.lpoo.zombieinvaders.Logic.Entities;

import com.lpoo.zombieinvaders.ZombieInvaders;

/**
 * Created by bernardoleite on 30/05/17.
 */

public class CharacterModel {


    public static final float SPEED = 300;

    public static final float PERSON_ANIMATION_SPEED = 0.5f;
    public static final int PERSON_WIDTH_PIXEL = 32;
    public static final int PERSON_HEIGHT_PIXEL = 45;
    public static final int PERSON_WIDTH = PERSON_WIDTH_PIXEL ;
    public static final int PERSON_HEIGHT = PERSON_HEIGHT_PIXEL ;

    public static final float ROLL_TIMER_SWITCH_TIME = 0.25f;
    public static final float SHOOT_WAIT_TIME = 0.3f;

    float x;
    float y;

    float rollTimer;

    float shootTimer;

    public CharacterModel(){

        y = 15;
        x = ZombieInvaders.WIDTH / 2 - PERSON_WIDTH / 2;

        shootTimer = 0;

    }

    public float getxposition(){
        return x;
    }

    public float getyposition(){
        return y;
    }

    public float getshootTimer(){
        return shootTimer;
    }

    public float getRollTimer(){
        return rollTimer;
    }




}
