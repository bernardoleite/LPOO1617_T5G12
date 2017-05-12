package com.lpoo.zombieinvaders.GUI.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.lpoo.zombieinvaders.ZombieInvaders;

/**
 * Created by bernardoleite on 11/05/17.
 */

public class RickGrimes extends Sprite{

    //O mundo em que o Sprite vai viver/atuar
    public World world;
    public Body b2body;


    public RickGrimes(World world){

        this.world = world;
        defineRick();
    }


    //
    public void defineRick(){

        //criar o body
        BodyDef bdef = new BodyDef();

        //posição no mapa
        bdef.position.set(32 / ZombieInvaders.PPM,32 / ZombieInvaders.PPM);

        //dizer que o corpo é dinâmico (colide)
        bdef.type = BodyDef.BodyType.DynamicBody;

        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/ ZombieInvaders.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef);


    }
}
