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

        GameModel mod = new GameModel(game);

        mod.getmodel().thebool = true;

        mod.getmodel().treatLeftMovement(1);

        mod.getmodel().treatRightMovement(1);

        float x1 =  mod.getmodel().getx();

        mod.MoveLeft();

        mod.getmodel().treatLeftMovement(1);

        mod.getmodel().treatRightMovement(1);

        float x2 =  mod.getmodel().getx();

        assertEquals(3, x1-x2, 0);

    }

    public void testMoveRight(){

        ZombieInvaders game = new ZombieInvaders();

        GameModel mod = new GameModel(game);

        mod.getmodel().thebool = true;

        mod.getmodel().treatLeftMovement(1);

        mod.getmodel().treatRightMovement(1);

        float x1 =  mod.getmodel().getx();

        mod.MoveRight();

        mod.getmodel().treatLeftMovement(1);

        mod.getmodel().treatRightMovement(1);

        float x2 =  mod.getmodel().getx();

        assertEquals(3, x2-x1, 0);

    }

    public void testShooting(){

        ZombieInvaders game = new ZombieInvaders();

        GameModel mod = new GameModel(game);

        mod.getmodel().thebool = true;

        assertEquals(0,  mod.getmodel().getBullets().size());

        mod.Shoot();

        mod.getmodel().shootingCode(1);

        mod.getmodel().getBullets().get(0).getY();

        assertEquals(1,  mod.getmodel().getBullets().size());

        mod.Shoot();

        mod.getmodel().shootingCode(1);

        mod.getmodel().getBullets().get(0).getY();

        assertEquals(2,  mod.getmodel().getBullets().size());

    }

    public void testDecreaseBullets(){

        ZombieInvaders game = new ZombieInvaders();

        GameModel mod = new GameModel(game);

        mod.getmodel().thebool = true;

        assertEquals(20,  mod.getmodel().getThenrbananas());

        mod.Shoot();

        mod.getmodel().shootingCode(1);

        assertEquals(19,  mod.getmodel().getThenrbananas());

    }

    public void testZombiePositionY(){

        ZombieInvaders game = new ZombieInvaders();

        GameModel mod = new GameModel(game);

        mod.getmodel().thebool = true;

        mod.getmodel().render(1);

        float y1 =  mod.getmodel().getZombies().get(0).getYposition();

        assertEquals(470, y1, y1 - 470);

        mod.getmodel().render(1);

        float y2 =  mod.getmodel().getZombies().get(0).getYposition();

        assertEquals(220, y2, y2- 220 );

    }


    public void testZombiePositionX(){

        ZombieInvaders game = new ZombieInvaders();

        GameModel mod = new GameModel(game);

        mod.getmodel().thebool = true;

        mod.getmodel().render(1);

        float x1 =  mod.getmodel().getZombies().get(0).getXposition();

        assertEquals(x1, x1, x1 - x1);

        mod.getmodel().render(1);

        float x2 =  mod.getmodel().getZombies().get(0).getXposition();

        assertEquals(x2, x1,x2- x1 );

    }

    public void testBananaPosition(){

        ZombieInvaders game = new ZombieInvaders();

        GameModel mod = new GameModel(game);

        mod.getmodel().thebool = true;

        mod.getmodel().render(10);

        float y1 =  mod.getmodel().getBananas().get(0).getYposition();

        assertEquals(-1780, y1, y1 - (-1780));

    }



    public void testHealth(){

        ZombieInvaders game = new ZombieInvaders();

        GameModel mod = new GameModel(game);

        mod.getmodel().thebool = true;

        assertEquals(100,  mod.getmodel().getHealth());

    }





}
