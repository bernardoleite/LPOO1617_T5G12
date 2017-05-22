package com.lpoo.zombieinvaders.GUI.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.lpoo.zombieinvaders.GUI.PlayScreen;
import com.lpoo.zombieinvaders.Logic.ZombieInvaders;

/**
 * Created by bernardoleite on 12/05/17.
 */

public class Coin extends InteractiveTiledObject {

    //16 refactoing
    public Coin(PlayScreen screen, Rectangle bounds)
    {
        super(screen, bounds);

        //12
        fixture.setUserData(this);

        //13
        setCategoryFiler(ZombieInvaders.COIN_BIT);

    }

    //12 - Identificar Colisões
    @Override
    public void onHeadHit() {

    }
}
