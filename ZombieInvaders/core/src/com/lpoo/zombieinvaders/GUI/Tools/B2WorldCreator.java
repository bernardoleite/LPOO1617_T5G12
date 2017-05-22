package com.lpoo.zombieinvaders.GUI.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.lpoo.zombieinvaders.GUI.Entities.Brick;
import com.lpoo.zombieinvaders.GUI.Entities.Coin;
import com.lpoo.zombieinvaders.GUI.PlayScreen;
import com.lpoo.zombieinvaders.Logic.ZombieInvaders;

/**
 * Created by bernardoleite on 11/05/17.
 */

public class B2WorldCreator {

    //16 - Refactoring
    public B2WorldCreator (PlayScreen screen)
    {       //16 refact
        World world = screen.getWorld();
        TiledMap map = screen.getMap();

        //box2d - Criar body, shape, fixture para depois criar no ciclo
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //box2d - Criar floor - 7
        for (MapObject object: map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2)/ ZombieInvaders.PPM, (rect.getY() + rect.getHeight() / 2 ) / ZombieInvaders.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / ZombieInvaders.PPM, rect.getHeight() / 2 / ZombieInvaders.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        //box2d - Criar pipe
        for (MapObject object: map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / ZombieInvaders.PPM, (rect.getY() + rect.getHeight() / 2 ) / ZombieInvaders.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / ZombieInvaders.PPM, rect.getHeight() / 2 / ZombieInvaders.PPM);
            fdef.shape = shape;

            //16
            fdef.filter.categoryBits =  ZombieInvaders.OBJECT_BIT;
            body.createFixture(fdef);
        }

        //box2d - Criar brick
        for (MapObject object: map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            //16 refactoring
            new Brick(screen, rect);
        }

        //box2d - Criar coin
        for (MapObject object: map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            //16 refactoring
            new Coin(screen, rect);

        }
    }
}
