package com.lpoo.zombieinvaders.GUI.Entities;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.lpoo.zombieinvaders.GUI.PlayScreen;
import com.lpoo.zombieinvaders.Logic.ZombieInvaders;

/**
 * Created by bernardoleite on 12/05/17.
 */

public abstract class InteractiveTiledObject {

    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;

    //16 refactoring
    public InteractiveTiledObject(PlayScreen screen, Rectangle bounds){

        //16 refactoring
        this.world = screen.getWorld();
        this.map = screen.getMap();


        this.bounds = bounds;

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth() / 2) / ZombieInvaders.PPM, (bounds.getY() + bounds.getHeight() / 2) / ZombieInvaders.PPM );

        body = world.createBody(bdef);

        shape.setAsBox(bounds.getWidth() / 2 / ZombieInvaders.PPM, bounds.getHeight() / 2 / ZombieInvaders.PPM);
        fdef.shape = shape;
        body.createFixture(fdef);




    }
}
