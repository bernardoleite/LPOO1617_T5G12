package com.lpoo.zombieinvaders.GUI.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by bernardoleite on 12/05/17.
 */

public class Brick extends InteractiveTiledObject {

    public Brick(World world, TiledMap map, Rectangle bounds){
        super(world,map, bounds);
    }
}
