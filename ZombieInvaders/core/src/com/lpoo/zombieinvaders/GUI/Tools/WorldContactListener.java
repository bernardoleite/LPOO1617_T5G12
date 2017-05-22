package com.lpoo.zombieinvaders.GUI.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.lpoo.zombieinvaders.GUI.Entities.Enemy;
import com.lpoo.zombieinvaders.GUI.Entities.InteractiveTiledObject;
import com.lpoo.zombieinvaders.Logic.ZombieInvaders;

/**
 * Created by bernardoleite on 21/05/17.
 */

//12- Identificar Colisões
public class WorldContactListener implements ContactListener{
    @Override
    public void beginContact(Contact contact) {

        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        //17 - Stomping Walkers
        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

        if(fixA.getUserData() == "head" || fixB.getUserData() == "head" ){
            Fixture head = fixA.getUserData() == "head" ? fixA:fixB;
            Fixture object = head == fixA ? fixB : fixA;

            if(object.getUserData() instanceof InteractiveTiledObject){
                ((InteractiveTiledObject) object.getUserData()).onHeadHit();
            }
        }

        //17 - Stomping Walkers
        switch (cDef){
            case ZombieInvaders.ENEMY_HEAD_BIT | ZombieInvaders.RICK_BIT:

                if (fixA.getFilterData().categoryBits == ZombieInvaders.ENEMY_HEAD_BIT)
                    ((Enemy)fixA.getUserData()).hitOnHead();
               else
                    ((Enemy)fixB.getUserData()).hitOnHead();
                break;

            //18
            case ZombieInvaders.ENEMY_BIT | ZombieInvaders.OBJECT_BIT:
                if (fixA.getFilterData().categoryBits == ZombieInvaders.ENEMY_BIT)
                    ((Enemy)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Enemy)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case ZombieInvaders.RICK_BIT | ZombieInvaders.ENEMY_BIT:
                Gdx.app.log("RICK", "DIED");
        }


    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
