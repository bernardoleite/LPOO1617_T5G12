package com.lpoo.zombieinvaders.GUI.Entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.lpoo.zombieinvaders.GUI.PlayScreen;
import com.lpoo.zombieinvaders.Logic.ZombieInvaders;

/**
 * Created by bernardoleite on 21/05/17.
 */

public class Walker extends Enemy {

    private float stateTime;
    private Animation walkAnimation;
    private Array<TextureRegion> frames;

    //17
    private boolean setToDestroy;
    private boolean destroyed;

    public Walker(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames = new Array<TextureRegion>();
        for(int i = 0; i < 2; i++){
            frames.add(new TextureRegion(screen.getAtlas().findRegion("goomba"), i * 16, 0, 16, 16));
            walkAnimation = new Animation(0.4f, frames);
            stateTime = 0;
            setBounds(getX(), getY(), 16 / ZombieInvaders.PPM, 16 / ZombieInvaders.PPM);
            setToDestroy = false;
            destroyed = false;
        }
    }

    public void update(float dt){
        stateTime += dt;
        if(setToDestroy && !destroyed){
            world.destroyBody(b2body);
            destroyed = true;
            setRegion(new TextureRegion(screen.getAtlas().findRegion("goomba"), 32, 0, 16, 16));
            stateTime = 0;
        }
        else if (!destroyed) {
            b2body.setLinearVelocity(velocity);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) walkAnimation.getKeyFrame(stateTime, true));
        }
    }

    @Override
    protected void defineEnemy() {

        //criar o body
        BodyDef bdef = new BodyDef();

        //posição no mapa
        bdef.position.set(getX(),getY());

        //dizer que o corpo é dinâmico (colide)
        bdef.type = BodyDef.BodyType.DynamicBody;

        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6/ ZombieInvaders.PPM);

        //13 & 16- Breacking Stuff
        fdef.filter.categoryBits = ZombieInvaders.ENEMY_BIT;
        fdef.filter.maskBits =
            ZombieInvaders.GROUND_BIT|
            ZombieInvaders.COIN_BIT  |
            ZombieInvaders.BRICK_BIT |
            ZombieInvaders.ENEMY_BIT |
            ZombieInvaders.OBJECT_BIT|
            ZombieInvaders.RICK_BIT
        ;


        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);

        //17- Stomping Walker
        PolygonShape head = new PolygonShape();
        Vector2[] vertice = new Vector2[4];
        vertice[0] = new Vector2(-5, 8).scl(1 / ZombieInvaders.PPM);
        vertice[1] = new Vector2(5, 8).scl(1 / ZombieInvaders.PPM);
        vertice[2] = new Vector2(-3, 3).scl(1 / ZombieInvaders.PPM);
        vertice[3] = new Vector2(3, 3).scl(1 / ZombieInvaders.PPM);
        head.set(vertice);
        fdef.shape = head;
        fdef.restitution = 0.5f;
        fdef.filter.categoryBits = ZombieInvaders.ENEMY_HEAD_BIT;
        b2body.createFixture(fdef).setUserData(this);

    }

    //18 - Moving Walkers & Kill Rick
    public void draw(Batch batch){
        if (!destroyed || stateTime < 1)
            super.draw(batch);
    }

    //17
    @Override
    public void hitOnHead() {
        setToDestroy = true;
    }
}
