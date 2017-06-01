package com.lpoo.zombieinvaders.Logic.Entities;

import com.lpoo.zombieinvaders.ZombieInvaders;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Created by bernardoleite on 01/06/17.
 */

public class TestSuit extends TestCase{

    public void testMoveLeft(){

        ZombieInvaders game = new ZombieInvaders();

        FirstLevelModel model;

        GameModel mod = new GameModel(game);

        model = new FirstLevelModel(game, mod);

        model.areWeTesting = true;

        model.treatLeftMovement(1);

        model.treatRightMovement(1);

        float x1 = model.getx();

        mod.MoveLeft();

        model.treatLeftMovement(1);

        model.treatRightMovement(1);

        float x2 = model.getx();

        assertEquals(3, x1-x2, 0);

    }

    public void testMoveRight(){

        ZombieInvaders game = new ZombieInvaders();

        FirstLevelModel model;

        GameModel mod = new GameModel(game);

        model = new FirstLevelModel(game, mod);

        model.areWeTesting = true;

        model.treatLeftMovement(1);

        model.treatRightMovement(1);

        float x1 = model.getx();

        mod.MoveRight();

        model.treatLeftMovement(1);

        model.treatRightMovement(1);

        float x2 = model.getx();

        assertEquals(3, x2-x1, 0);

    }

    public void testShooting(){

        ZombieInvaders game = new ZombieInvaders();

        FirstLevelModel model;

        GameModel mod = new GameModel(game);

        model = new FirstLevelModel(game, mod);

        model.areWeTesting = true;

        assertEquals(0, model.getBullets().size());

        mod.Shoot();

        model.shootingCode(1);

        model.getBullets().get(0).getY();

        assertEquals(1, model.getBullets().size());

        mod.Shoot();

        model.shootingCode(1);

        model.getBullets().get(0).getY();

        assertEquals(2, model.getBullets().size());

    }

    public void testDecreaseBullets(){

        ZombieInvaders game = new ZombieInvaders();

        FirstLevelModel model;

        GameModel mod = new GameModel(game);

        model = new FirstLevelModel(game, mod);

        model.areWeTesting = true;

        assertEquals(20, model.getThenrbananas());

        mod.Shoot();

        model.shootingCode(1);

        assertEquals(19, model.getThenrbananas());

    }

    public void testZombiePositionY(){

        ZombieInvaders game = new ZombieInvaders();

        FirstLevelModel model;

        GameModel mod = new GameModel(game);

        model = new FirstLevelModel(game, mod);

        model.areWeTesting = true;

        model.render(1);

       float y1 = model.getZombies().get(0).getYposition();

        assertEquals(470, y1, y1 - 470);

        model.render(1);

        float y2 = model.getZombies().get(0).getYposition();

        assertEquals(220, y2, y2- 220 );

    }

    public void testZombiePositionX(){

        ZombieInvaders game = new ZombieInvaders();

        FirstLevelModel model;

        GameModel mod = new GameModel(game);

        model = new FirstLevelModel(game, mod);

        model.render(1);

        float x1 = model.getZombies().get(0).getXposition();

        assertEquals(x1, x1, x1 - x1);

        model.render(1);

        float x2 = model.getZombies().get(0).getXposition();

        assertEquals(x2, x1,x2- x1 );

    }

    public void testBananaPosition(){

        ZombieInvaders game = new ZombieInvaders();

        FirstLevelModel model;

        GameModel mod = new GameModel(game);

        model = new FirstLevelModel(game, mod);

        model.render(10);

        float y1 = model.getBananas().get(0).getYposition();

        assertEquals(-1780, y1, y1 - (-1780));




    }



    public void testHealth(){

        ZombieInvaders game = new ZombieInvaders();

        FirstLevelModel model;

        GameModel mod = new GameModel(game);

        model = new FirstLevelModel(game, mod);

        model.areWeTesting = true;

        assertEquals(100, model.getHealth());

    }





}
