package com.lpoo.zombieinvaders.GUI.Entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.lpoo.zombieinvaders.GUI.PlayScreen;
import com.lpoo.zombieinvaders.Logic.ZombieInvaders;

/**
 * Created by bernardoleite on 11/05/17.
 */

public class RickGrimes extends Sprite{

    // 11 - Jump & Run
    public enum State {FALLING, JUMPING, STANDING, RUNNING};
    public State currentState;
    public State previousState;
    private Animation<TextureRegion> rickRun;
    private Animation<TextureRegion> rickJump;
    private boolean runningRight;
    private float stateTimer;
    private boolean canJump = true;
    //O mundo em que o Sprite vai viver/atuar
    public World world;
    public Body b2body;

    //10
    private TextureRegion rickStand;

    //adicionado argumento em 10
    //16 refactoring
    public RickGrimes( PlayScreen screen){

        ///Criação de Sprite em torno da circunferência - 10
        super(screen.getAtlas().findRegion("little_mario"));

         // 16 - refactoring
        this.world = screen.getWorld();

        // 11 - Jump & Run
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 1; i < 4; i++){

            frames.add(new TextureRegion(getTexture(), i*16, 11, 16, 16));

        }
        rickRun = new Animation<TextureRegion>(0.1f, frames);
        frames.clear();

        for (int i = 4; i < 6; i++){
            frames.add(new TextureRegion(getTexture(), i*16, 11, 16, 16));
        }
        rickJump = new Animation<TextureRegion>(0.1f, frames);


        defineRick();

        //Criação de Sprite em torno da circunferência - 10
        rickStand = new TextureRegion(getTexture(), 0, 11, 16, 16);
        setBounds(0,0,16 / ZombieInvaders.PPM, 16 / ZombieInvaders.PPM);
        setRegion(rickStand);
    }


    //10
    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth()  / 2, b2body.getPosition().y - getHeight() / 2);

        //11 - Jump & Run - Retorna a frame própria da texture
        setRegion(getFrame(dt));
    }

    // 11 - Jump & Run
    public TextureRegion getFrame(float dt){
        currentState = getState();

       TextureRegion region;
        switch (currentState){
            case JUMPING:
                region = rickJump.getKeyFrame(stateTimer);
                break;
            case RUNNING:
                region = rickRun.getKeyFrame(stateTimer, true);
                break;
            case FALLING:
            case STANDING:
            default:
                region = rickStand;
                break;
        }


        //fazer flips nos sprites
        if ((b2body.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()){
            region.flip(true, false);
            runningRight = false;
        }
        else if((b2body.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()){
            region.flip(true, false);
            runningRight = true;
        }

        // se (currentS == pS) então (stateTimer = stateTimer + dt) senão (stateTimer = 0)
        stateTimer = currentState == previousState ? stateTimer + dt : 0;
        previousState = currentState;
        return region;
    }

     // 11 - Jump & Run
    public State getState(){
         if(b2body.getLinearVelocity().y > 0 || b2body.getLinearVelocity().y < 0 &&  previousState == State.JUMPING){
             canJump = false;
             return State.JUMPING;}
         else if (b2body.getLinearVelocity().y < 0)
            return State.FALLING;
        else if (b2body.getLinearVelocity().x != 0){
             canJump = true;
            return State.RUNNING;}
        else{
             canJump = true;
            return State.STANDING;}
    }

    public boolean getCanJump() {
        return  canJump;
    }

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
        shape.setRadius(6/ ZombieInvaders.PPM);

        //13 - Breacking Stuff
        fdef.filter.categoryBits = ZombieInvaders.RICK_BIT;
        fdef.filter.maskBits =
                ZombieInvaders.GROUND_BIT |
                ZombieInvaders.COIN_BIT |
                ZombieInvaders.BRICK_BIT |
                        ZombieInvaders.ENEMY_BIT |
                        ZombieInvaders.OBJECT_BIT |
                        ZombieInvaders.ENEMY_HEAD_BIT
        ;


        fdef.shape = shape;
        b2body.createFixture(fdef);


        //12 - Identificar colisões
        EdgeShape head = new EdgeShape();
        head.set(new Vector2(-2 / ZombieInvaders.PPM, 6 / ZombieInvaders.PPM), new Vector2(2 / ZombieInvaders.PPM, 6 / ZombieInvaders.PPM));
        fdef.shape = head;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData("head");

    }
}
