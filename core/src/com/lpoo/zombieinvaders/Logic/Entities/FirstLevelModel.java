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

    CharacterModel person;

    public boolean areWeTesting = false;

    public static final float TESTING_VELOCITY = 3f;

    public static final float ZOMBIE_TIMER_SPAWN_MIN = 0.3f;
    public static final float ZOMBIE_TIMER_SPAWN_MAX = 0.6f;

    public static final float BANANAS_TIMER_SPAWN_MIN = 0.3f;
    public static final float BANANAS_TIMER_SPAWN_MAX = 10f;

    public static final float MORANGOS_TIMER_SPAWN_MIN = 0.1f;
    public static final float MORANGOS_TIMER_SPAWN_MAX = 13f;

    public  boolean zombie_bullet = false;
    public  boolean morango_person = false;

    private Music music;

    //Animation<TextureRegion>[] rolls;


    int roll;
    float rollTimer;
    float stateTime;
    float timerBetweenZombieSpawn;
    float timerBetweenBananasSpawn;
    float timerBetweenMorangosSpawn;

    Random random;
    ZombieInvaders game;
    GameModel model;

    ArrayList<BulletModel> bullets;
    ArrayList<ZombieModel> zombies;
    ArrayList<ExplosionModel> explosions;
    ArrayList<BananasModel> bananas;
    ArrayList<MorangoModel> morangos;

    ShapeCollision healthBar;
/*
    BitmapFont myscore;
    BitmapFont mybananas;
    BitmapFont mylife;
*/
    //Texture whiteshape;

    int thescore;
    int nrbananas = 20;

    //0 sem vida , 1 com vida cheia
    int health = 100;


    public FirstLevelModel(ZombieInvaders game, GameModel model){

        person = new CharacterModel();


        // music = ZombieInvaders.manager.get("arcade.ogg", Music.class);
       // music.setLooping(true);
       // music.play();

        this.model = model;
        this.game = game;


        bullets = new ArrayList<BulletModel>();
        zombies = new ArrayList<ZombieModel>();
        explosions = new ArrayList<ExplosionModel>();
        bananas = new ArrayList<BananasModel>();
        morangos = new ArrayList<MorangoModel>();

        healthBar = new ShapeCollision(0, 0, person.PERSON_WIDTH, person.PERSON_HEIGHT );

        thescore = 0;

        random = new Random();
        timerBetweenZombieSpawn = random.nextFloat() * (ZOMBIE_TIMER_SPAWN_MAX - ZOMBIE_TIMER_SPAWN_MIN) + ZOMBIE_TIMER_SPAWN_MIN;
        timerBetweenBananasSpawn = random.nextFloat() * (BANANAS_TIMER_SPAWN_MAX - BANANAS_TIMER_SPAWN_MIN) + BANANAS_TIMER_SPAWN_MIN;
        timerBetweenMorangosSpawn = random.nextFloat() * (MORANGOS_TIMER_SPAWN_MAX - MORANGOS_TIMER_SPAWN_MIN) + MORANGOS_TIMER_SPAWN_MIN;

        roll = 2;
        rollTimer = 0;
      //  rolls = new Animation[5];

        //TextureRegion[][] rollSpriteSheet = TextureRegion.split(new Texture("rick2.png"), person.PERSON_WIDTH_PIXEL, person.PERSON_HEIGHT_PIXEL);

        //rolls[0] = new Animation(PERSON_ANIMATION_SPEED, rollSpriteSheet[2]);//All left
        //rolls[1] = new Animation(PERSON_ANIMATION_SPEED, rollSpriteSheet[1]);
      //  rolls[2] = new Animation(person.PERSON_ANIMATION_SPEED, rollSpriteSheet[0]);//No tilt
        //rolls[3] = new Animation(PERSON_ANIMATION_SPEED, rollSpriteSheet[3]);
        //rolls[4] = new Animation(PERSON_ANIMATION_SPEED, rollSpriteSheet[4]);//Right


    }

    public void shootingCode(float delta){


        //Shooting code
        person.shootTimer += delta;
        if (model.isShooting() && person.shootTimer >= person.SHOOT_WAIT_TIME && nrbananas >= 0) {
            person.shootTimer = 0;

            int offset = 4;
            if (roll == 1 || roll == 3)//Slightly tilted
                offset = 8;

            if (roll == 0 || roll == 4)//Fully tilted
                offset = 16;

            nrbananas--;


            bullets.add(new BulletModel(person.getxposition() ));
            //bullets.add(new BulletModel(person.getxposition() + offset));
            //bullets.add(new BulletModel(x + PERSON_WIDTH - offset));

        }

    }

    public void spawnZombies(float delta){

        //Spawn Zombies
        timerBetweenZombieSpawn -= delta;
        if  (timerBetweenZombieSpawn <= 0) {
            timerBetweenZombieSpawn = random.nextFloat() * (ZOMBIE_TIMER_SPAWN_MAX - ZOMBIE_TIMER_SPAWN_MIN) + ZOMBIE_TIMER_SPAWN_MIN;
            zombies.add(new ZombieModel(random.nextInt(ZombieInvaders.WIDTH - ZombieModel.WIDTH)));
        }

    }


    public void spawnBananas(float delta){
        //Spawn Bananas
        timerBetweenBananasSpawn -= delta;
        if  (timerBetweenBananasSpawn <= 0) {
            timerBetweenBananasSpawn = random.nextFloat() * (BANANAS_TIMER_SPAWN_MAX - BANANAS_TIMER_SPAWN_MIN) + BANANAS_TIMER_SPAWN_MIN;
            bananas.add(new BananasModel(random.nextInt(ZombieInvaders.WIDTH - ZombieModel.WIDTH)));
        }

    }

    public void spawnMorangos(float delta){
        //Spawn Moranos
        timerBetweenMorangosSpawn -= delta;
        if  (timerBetweenMorangosSpawn <= 0) {
            timerBetweenMorangosSpawn = random.nextFloat() * (MORANGOS_TIMER_SPAWN_MAX - MORANGOS_TIMER_SPAWN_MIN) + MORANGOS_TIMER_SPAWN_MIN;
            morangos.add(new MorangoModel(random.nextInt(ZombieInvaders.WIDTH - ZombieModel.WIDTH)));
        }

    }

    ArrayList<MorangoModel> morangosToRemove = new ArrayList<MorangoModel>();
    public void updateMorangos(float delta){
        //Update Morangos
        for (MorangoModel morango: morangos) {
            morango.update(delta);
             //if(morango.remove)
              //morangosToRemove.add(morango);

        }
    }


    ArrayList<BananasModel> bananasToRemove = new ArrayList<BananasModel>();
    public void updateBananas(float delta){
        //Update Bananas
        for (BananasModel banana: bananas) {
            banana.update(delta);
           // if(banana.remove)
              //  bananasToRemove.add(banana);

        }
    }


    ArrayList<ZombieModel> zombiesToRemove = new ArrayList<ZombieModel>();
    public void updateZombies(float delta){

        //Update Zombies

        for (ZombieModel zombie: zombies) {
            zombie.update(delta);
            if(zombie.remove)
                zombiesToRemove.add(zombie);

        }
    }


    ArrayList<BulletModel> bulletsToRemove = new ArrayList<BulletModel>();
    public void updateBullets(float delta){
        //Update bullets


        for (BulletModel bullet : bullets) {
            bullet.update(delta);
            if (bullet.remove)
                bulletsToRemove.add(bullet);
        }
    }

    public void updateExplosions(float delta){

        //Atualizar as explosões
        ArrayList<ExplosionModel> explosionToRemove = new ArrayList<ExplosionModel>();
        for (ExplosionModel explosion: explosions){
            explosion.update(delta);
            if (explosion.remove)
                explosionToRemove.add(explosion);
        }
        explosions.removeAll(explosionToRemove);
    }


    public void treatLeftMovement(float delta){

        if (model.isLeft()) {

            if(areWeTesting)
            {
                person.x -= TESTING_VELOCITY;
            }
            else person.x -= person.SPEED * Gdx.graphics.getDeltaTime() ;

            if (person.x < 0)
                 person.x = 0;

            //Update roll if button just clicked
            if (model.isJustLeft() && !model.isRight() && roll > 0) {
                rollTimer = 0;
                //roll--;
            }

            //Update roll
            if(areWeTesting)
            {
                rollTimer -= TESTING_VELOCITY;
            }
            else rollTimer -= Gdx.graphics.getDeltaTime() ;


            if (Math.abs(rollTimer) > person.ROLL_TIMER_SWITCH_TIME && roll > 0) {
                rollTimer -= person.ROLL_TIMER_SWITCH_TIME;
                // roll--;
            }
        } else {
            if (roll < 2) {
                //Update roll to make it go back to center
                rollTimer += Gdx.graphics.getDeltaTime();
                if (Math.abs(rollTimer) > person.ROLL_TIMER_SWITCH_TIME && roll < 4) {
                    rollTimer -= person.ROLL_TIMER_SWITCH_TIME;
                    // roll++;
                }
            }
        }
    }


    public void treatRightMovement(float delta) {

        if (model.isRight() ) {
            if(areWeTesting)
            {
                person.x += TESTING_VELOCITY;
            }
            else person.x += person.SPEED * Gdx.graphics.getDeltaTime() ;


            if (person.x + person.PERSON_WIDTH > ZombieInvaders.WIDTH)
                person.x = ZombieInvaders.WIDTH - person.PERSON_WIDTH;

            if (model.isJustRight() && !model.isLeft() && roll > 0) {
                rollTimer = 0;
                // roll--;
            }

            //Update roll
            if(areWeTesting)
            {
                rollTimer += TESTING_VELOCITY;
            }
            else rollTimer += Gdx.graphics.getDeltaTime() ;
            if (Math.abs(rollTimer) > person.ROLL_TIMER_SWITCH_TIME && roll < 4) {
                rollTimer -= person.ROLL_TIMER_SWITCH_TIME;
                //roll++;
            }
        } else {
            if (roll > 2) {
                //Update roll
                rollTimer -= Gdx.graphics.getDeltaTime();
                if (Math.abs(rollTimer) > person.ROLL_TIMER_SWITCH_TIME && roll > 0) {
                    rollTimer -= person.ROLL_TIMER_SWITCH_TIME;
                    // roll--;
                }
            }
        }
    }

    public void verifyCollisions(float delta){
        //Verificar Colisões
        for (BulletModel bullet: bullets){
            for (ZombieModel zombie: zombies){
                if (bullet.getShapeCollision().checkCollision(zombie.getCollisionRect())){
                    zombie_bullet = true;
                    bulletsToRemove.add(bullet);
                    zombiesToRemove.add(zombie);
                    explosions.add(new ExplosionModel(zombie.getXposition(), zombie.getYposition()));
                    thescore+=1;
                }
            }
        }

        zombies.removeAll(zombiesToRemove);
        bullets.removeAll(bulletsToRemove);

        for( ZombieModel zombie: zombies){
            if (zombie.getCollisionRect().checkCollision(healthBar)){
                zombiesToRemove.add(zombie);
                health -= 10;

                //Verificar a vida
                if(health <= 0){
                    // this.dispose(); ver
                    game.setScreen(new EndScreen(game, thescore));
                }
            }
        }

        for( BananasModel banana: bananas){
            if (banana.getCollisionRect().checkCollision(healthBar)){
                bananasToRemove.add(banana);
                nrbananas += 20;

            }
        }


        for( MorangoModel morango: morangos){
            if (morango.getCollisionRect().checkCollision(healthBar)){
                morango_person = true;
                morangosToRemove.add(morango);
                health += 10;


            }
        }

        morangos.removeAll(morangosToRemove);
        bananas.removeAll(bananasToRemove);
        zombies.removeAll(zombiesToRemove);

    }


    public void render (float delta) {

        shootingCode(delta);

        spawnZombies(delta);

        spawnBananas(delta);

        spawnMorangos(delta);

        updateZombies(delta);

        updateBananas(delta);

        updateMorangos(delta);

        updateBullets(delta);

        updateExplosions(delta);

        treatLeftMovement(delta);

        treatRightMovement(delta);

        //Depois do movimento do jogador, atualizar collisao
        healthBar.move(person.x,person.y);

        verifyCollisions(delta);

        stateTime += delta;



    }



   /* public Animation<TextureRegion>[] getRolls(){
        return rolls;
    }
*/
    public float getStateTime(){
        return stateTime;
    }

    public ArrayList<BulletModel> getBullets(){return bullets;}

    public ArrayList<BananasModel> getBananas(){return bananas;}

    public ArrayList<MorangoModel> getMorangos(){return morangos;}

    public ArrayList<ZombieModel> getZombies(){
        return zombies;
    }

    public ArrayList<ExplosionModel> getExplosions(){
        return explosions;
    }

    public int getThescore(){
        return thescore;
    }

    public int getThenrbananas(){
        return nrbananas;
    }

    public int getHealth(){
        return health;
    }

    public int getRoll(){
        return roll;
    }

    public float getx(){
        return person.x;
    }

    public float gety(){
        return person.y;
    }

}
