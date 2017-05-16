package com.lpoo.zombieinvaders.GUI.Entities;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by bernardoleite on 12/05/17.
 */

public class Coin extends InteractiveTiledObject {

    public Coin(World world, TiledMap map, Rectangle bounds)
    {
        super(world, map, bounds);


    }
}
