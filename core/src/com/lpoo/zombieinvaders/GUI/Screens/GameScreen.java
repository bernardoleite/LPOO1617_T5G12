package com.lpoo.zombieinvaders.GUI.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Align;
import com.lpoo.zombieinvaders.Logic.Entities.BananasModel;
import com.lpoo.zombieinvaders.Logic.Entities.BulletModel;
import com.lpoo.zombieinvaders.Logic.Entities.ExplosionModel;
import com.lpoo.zombieinvaders.Logic.Entities.GameModel;
import com.lpoo.zombieinvaders.Logic.Entities.MorangoModel;
import com.lpoo.zombieinvaders.Logic.Entities.ZombieModel;
import com.lpoo.zombieinvaders.Tools.ShapeCollision;
import com.lpoo.zombieinvaders.ZombieInvaders;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bernardoleite on 27/05/17.
 */

public class GameScreen implements Screen {

    public static final int PERSON_WIDTH_PIXEL = 32;
    public static final int PERSON_HEIGHT_PIXEL = 45;
    public static final float PERSON_ANIMATION_SPEED = 0.5f;

    Animation<TextureRegion>[] rolls;
    private static Animation<TextureRegion> explosion = null;

    private static Texture texturebananas;
    private static Texture texturebanana;
    private static Texture texturemorango;
    private static Texture texturezombie;
    private static Texture textureexplosion;

    private GameModel mygame;
    private ZombieInvaders game;
    private Texture background ;

    BitmapFont myscore;
    BitmapFont mybananas;
    BitmapFont mylife;

    TextureRegion[][]  rollSpriteSheet;

    public GameScreen (ZombieInvaders game) {
/*
        music = ZombieInvaders.manager.get("arcade.ogg", Music.class);
        music.setLooping(true);
        music.play();
*/
        texturebananas = new Texture("bananas2.png");
        texturebanana= new Texture("banana2.png");
        texturemorango = new Texture("morango.png");
        texturezombie = new Texture("zombie2.png");


        mygame = new GameModel(game);
        this.game = game;
        background =  new Texture("road.png");

        myscore = new BitmapFont(Gdx.files.internal("score.fnt"));
        mybananas = new BitmapFont(Gdx.files.internal("score.fnt"));
        mylife = new BitmapFont(Gdx.files.internal("score.fnt"));

        rolls = new Animation[5];

        rollSpriteSheet = TextureRegion.split(new Texture("rick2.png"), PERSON_WIDTH_PIXEL, PERSON_HEIGHT_PIXEL);

        rolls[2] = new Animation(PERSON_ANIMATION_SPEED, rollSpriteSheet[0]);//No tilt
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        mygame.getLevel().render(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(background,0,0);

        GlyphLayout ScoreDisplay = new GlyphLayout(myscore, "" + mygame.getLevel().getThescore(), Color.WHITE, 0, Align.left, false);
        myscore.draw(game.batch, ScoreDisplay, ZombieInvaders.WIDTH / 2 - ScoreDisplay.width / 2 - 150,ZombieInvaders.HEIGHT - ScoreDisplay.height - 10);

        GlyphLayout BananasDisplay = new GlyphLayout(mybananas, "" + mygame.getLevel().getThenrbananas(), Color.YELLOW, 0, Align.left, false);
        mybananas.draw(game.batch, BananasDisplay, ZombieInvaders.WIDTH / 2 - BananasDisplay.width / 2,ZombieInvaders.HEIGHT - BananasDisplay.height - 10);

        GlyphLayout LifeDisplay = new GlyphLayout(mylife, "" + mygame.getLevel().getHealth(), Color.RED, 0, Align.left, false);
        mylife.draw(game.batch, LifeDisplay, ZombieInvaders.WIDTH / 2 - LifeDisplay.width / 2 + 150,ZombieInvaders.HEIGHT - LifeDisplay.height - 10);

        for (BulletModel bullet : mygame.getLevel().getBullets()) {
            game.batch.draw(texturebanana, bullet.getX(), bullet.getY());
        }

        for (ZombieModel zombie : mygame.getLevel().getZombies()) {
            game.batch.draw(texturezombie, zombie.getXposition(), zombie.getYposition());
        }

        for (BananasModel banana : mygame.getLevel().getBananas()) {
            game.batch.draw(texturebananas, banana.getXposition(), banana.getYposition());
        }

        for (MorangoModel morango : mygame.getLevel().getMorangos()) {
            game.batch.draw(texturemorango, morango.getXposition(), morango.getYposition());
        }

        for (ExplosionModel explosion : mygame.getLevel().getExplosions()){
            explosion.render(game.batch);
        }

        if (mygame.getLevel().getHealth() > 0.6f)
            game.batch.setColor(Color.GREEN);

        else if (mygame.getLevel().getHealth() > 0.3f )
            game.batch.setColor(Color.ORANGE);
        else
            game.batch.setColor(Color.RED);



        //multiplicação serve para gerar proporção na barra da vida


        //game.batch.draw(mygame.getLevel().getWhiteshape(), 0 , 0, ZombieInvaders.WIDTH * mygame.getLevel().getHealth(), 5);
        game.batch.setColor(Color.WHITE);

        game.batch.draw(rolls[2].getKeyFrame(mygame.getLevel().getStateTime(), true), mygame.getLevel().getx(), mygame.getLevel().gety(), 41, 58);

        game.batch.end();

    }

    @Override
    public void resize (int width, int height) {

    }

    @Override
    public void pause () {

    }

    @Override
    public void resume () {

    }

    @Override
    public void hide () {

    }

    @Override
    public void dispose () {

    }

}
