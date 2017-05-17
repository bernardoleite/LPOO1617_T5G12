package com.lpoo.zombieinvaders.GUI.Entities;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.lpoo.zombieinvaders.GUI.PlayScreen;

/**
 * Created by bernardoleite on 12/05/17.
 */

public class Brick extends InteractiveTiledObject {

    //16 refactoring
    public Brick(PlayScreen screen, Rectangle bounds){

        super(screen, bounds);
    }
}
