package com.lpoo.zombieinvaders.Logic.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.lpoo.zombieinvaders.GUI.Screens.EndScreen;
import com.lpoo.zombieinvaders.Tools.ShapeCollision;
import com.lpoo.zombieinvaders.ZombieInvaders;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bernardoleite on 28/05/17.
 */

public class FirstLevelModel {

    public static final float SPEED = 300;

    public static final float SHIP_ANIMATION_SPEED = 0.5f;
    public static final int SHIP_WIDTH_PIXEL = 17;
    public static final int SHIP_HEIGHT_PIXEL = 32;
    public static final int SHIP_WIDTH = SHIP_WIDTH_PIXEL * 3;
    public static final int SHIP_HEIGHT = SHIP_HEIGHT_PIXEL * 3;

    public static final float ROLL_TIMER_SWITCH_TIME = 0.25f;
    public static final float SHOOT_WAIT_TIME = 0.3f;

    public static final float ZOMBIE_TIMER_SPAWN_MIN = 0.3f;
    public static final float ZOMBIE_TIMER_SPAWN_MAX = 0.6f;

    private Music music;

    Animation<TextureRegion>[] rolls;

    float x;
    float y;
    int roll;
    float rollTimer;
    float stateTime;
    float shootTimer;
    float timerBetweenZombieSpawn;

    Random random;
    ZombieInvaders game;

    ArrayList<BulletModel> bullets;
    ArrayList<ZombieModel> zombies;
    ArrayList<ExplosionModel> explosions;

    ShapeCollision healthBar;

    BitmapFont myscore;

    Texture whiteshape;

    int thescore;

    //0 sem vida , 1 com vida cheia
    float health = 1;


    public FirstLevelModel(ZombieInvaders game){


        music = ZombieInvaders.manager.get("arcade.ogg", Music.class);
        music.setLooping(true);
        music.play();


        this.game = game;
        y = 15;
        x = ZombieInvaders.WIDTH / 2 - SHIP_WIDTH / 2;
        bullets = new ArrayList<BulletModel>();
        zombies = new ArrayList<ZombieModel>();
        explosions = new ArrayList<ExplosionModel>();

        myscore = new BitmapFont(Gdx.files.internal("score.fnt"));

        healthBar = new ShapeCollision(0, 0, SHIP_WIDTH, SHIP_HEIGHT );
        whiteshape = new Texture("blank.png");

        thescore = 0;

        random = new Random();
        timerBetweenZombieSpawn = random.nextFloat() * (ZOMBIE_TIMER_SPAWN_MAX - ZOMBIE_TIMER_SPAWN_MIN) + ZOMBIE_TIMER_SPAWN_MIN;

        shootTimer = 0;

        roll = 2;
        rollTimer = 0;
        rolls = new Animation[5];

        TextureRegion[][] rollSpriteSheet = TextureRegion.split(new Texture("rick.gif"), SHIP_WIDTH_PIXEL, SHIP_HEIGHT_PIXEL);

        //rolls[0] = new Animation(SHIP_ANIMATION_SPEED, rollSpriteSheet[2]);//All left
        //rolls[1] = new Animation(SHIP_ANIMATION_SPEED, rollSpriteSheet[1]);
        rolls[2] = new Animation(SHIP_ANIMATION_SPEED, rollSpriteSheet[0]);//No tilt
        //rolls[3] = new Animation(SHIP_ANIMATION_SPEED, rollSpriteSheet[3]);
        //rolls[4] = new Animation(SHIP_ANIMATION_SPEED, rollSpriteSheet[4]);//Right


    }


    public void render (float delta) {

        //Shooting code
        shootTimer += delta;
        if ((isRight() || isLeft()) && shootTimer >= SHOOT_WAIT_TIME) {
            shootTimer = 0;

            int offset = 4;
            if (roll == 1 || roll == 3)//Slightly tilted
                offset = 8;

            if (roll == 0 || roll == 4)//Fully tilted
                offset = 16;

            bullets.add(new BulletModel(x + offset));
            //bullets.add(new BulletModel(x + SHIP_WIDTH - offset));
        }

        //Spawn Zombies
        timerBetweenZombieSpawn -= delta;
        if  (timerBetweenZombieSpawn <= 0) {
            timerBetweenZombieSpawn = random.nextFloat() * (ZOMBIE_TIMER_SPAWN_MAX - ZOMBIE_TIMER_SPAWN_MIN) + ZOMBIE_TIMER_SPAWN_MIN;
            zombies.add(new ZombieModel(random.nextInt(ZombieInvaders.WIDTH - ZombieModel.WIDTH)));
        }

        //Update Zombies
        ArrayList<ZombieModel> zombiesToRemove = new ArrayList<ZombieModel>();
        for (ZombieModel zombie: zombies) {
            zombie.update(delta);
            if(zombie.remove)
                zombiesToRemove.add(zombie);

        }


        //Update bullets
        ArrayList<BulletModel> bulletsToRemove = new ArrayList<BulletModel>();

        for (BulletModel bullet : bullets) {
            bullet.update(delta);
            if (bullet.remove)
                bulletsToRemove.add(bullet);
        }

        //Atualizar as explosões
        ArrayList<ExplosionModel> explosionToRemove = new ArrayList<ExplosionModel>();
        for (ExplosionModel explosion: explosions){
            explosion.update(delta);
            if (explosion.remove)
                explosionToRemove.add(explosion);
        }
        explosions.removeAll(explosionToRemove);

        if (isLeft()) {
            x -= SPEED * Gdx.graphics.getDeltaTime();

            if (x < 0)
                x = 0;

            //Update roll if button just clicked
            if (isJustLeft() && !isRight() && roll > 0) {
                rollTimer = 0;
                //roll--;
            }

            //Update roll
            rollTimer -= Gdx.graphics.getDeltaTime();
            if (Math.abs(rollTimer) > ROLL_TIMER_SWITCH_TIME && roll > 0) {
                rollTimer -= ROLL_TIMER_SWITCH_TIME;
               // roll--;
            }
        } else {
            if (roll < 2) {
                //Update roll to make it go back to center
                rollTimer += Gdx.graphics.getDeltaTime();
                if (Math.abs(rollTimer) > ROLL_TIMER_SWITCH_TIME && roll < 4) {
                    rollTimer -= ROLL_TIMER_SWITCH_TIME;
                   // roll++;
                }
            }
        }

        if (isRight()) {
            x += SPEED * Gdx.graphics.getDeltaTime();

            if (x + SHIP_WIDTH > ZombieInvaders.WIDTH)
                x = ZombieInvaders.WIDTH - SHIP_WIDTH;

            if (isJustRight() && !isLeft() && roll > 0) {
                rollTimer = 0;
               // roll--;
            }

            //Update roll
            rollTimer += Gdx.graphics.getDeltaTime();
            if (Math.abs(rollTimer) > ROLL_TIMER_SWITCH_TIME && roll < 4) {
                rollTimer -= ROLL_TIMER_SWITCH_TIME;
                //roll++;
            }
        } else {
            if (roll > 2) {
                //Update roll
                rollTimer -= Gdx.graphics.getDeltaTime();
                if (Math.abs(rollTimer) > ROLL_TIMER_SWITCH_TIME && roll > 0) {
                    rollTimer -= ROLL_TIMER_SWITCH_TIME;
                   // roll--;
                }
            }
        }


        //Depois do movimento do jogador, atualizar collisao
        healthBar.move(x,y);

        //Verificar Colisões

        for (BulletModel bullet: bullets){
            for (ZombieModel zombie: zombies){
                if (bullet.getShapeCollision().checkCollision(zombie.getCollisionRect())){
                    bulletsToRemove.add(bullet);
                    zombiesToRemove.add(zombie);
                    explosions.add(new ExplosionModel(zombie.getXposition(), zombie.getYposition()));
                    thescore+=100;
                }
            }
        }

        zombies.removeAll(zombiesToRemove);
        bullets.removeAll(bulletsToRemove);

        for( ZombieModel zombie: zombies){
            if (zombie.getCollisionRect().checkCollision(healthBar)){
                zombiesToRemove.add(zombie);
                health -= 0.3;

                //Verificar a vida
                if(health <= 0){
                   // this.dispose(); ver
                    game.setScreen(new EndScreen(game, thescore));
                }
            }
        }

        zombies.removeAll(zombiesToRemove);

        stateTime += delta;

    }


    public boolean isRight() {
        return Gdx.input.isKeyPressed(Input.Keys.RIGHT) || (Gdx.input.isTouched() && game.mycam.getInputInGameWorld().x >= ZombieInvaders.WIDTH / 2);
    }

    public boolean isLeft(){
        return Gdx.input.isKeyPressed(Input.Keys.LEFT) || (Gdx.input.isTouched() && game.mycam.getInputInGameWorld().x < ZombieInvaders.WIDTH / 2);

    }

    public boolean isJustRight(){
        return Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || (Gdx.input.justTouched() && game.mycam.getInputInGameWorld().x >= ZombieInvaders.WIDTH / 2);

    }

    public boolean isJustLeft(){
        return Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || (Gdx.input.justTouched() && game.mycam.getInputInGameWorld().x < ZombieInvaders.WIDTH / 2);

    }

    public float getHealth(){
        return health;
    }

    public Animation<TextureRegion>[] getRolls(){
        return rolls;
    }

    public float getStateTime(){
        return stateTime;
    }

    public ArrayList<BulletModel> getBullets(){
        return bullets;
    }

    public ArrayList<ZombieModel> getZombies(){
        return zombies;
    }

    public ArrayList<ExplosionModel> getExplosions(){
        return explosions;
    }

    public BitmapFont getMyscore(){
        return myscore;
    }

    public int getThescore(){
        return thescore;
    }

    public int getRoll(){
        return roll;
    }

    public Texture getWhiteshape(){
        return whiteshape;
    }

    public float getx(){
        return x;
    }

    public float gety(){
        return y;
    }


}
