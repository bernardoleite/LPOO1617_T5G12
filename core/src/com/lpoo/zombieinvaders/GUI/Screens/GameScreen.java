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

private GameModel mygame;
    private ZombieInvaders game;
    private Texture background ;

    public GameScreen (ZombieInvaders game) {
/*
        music = ZombieInvaders.manager.get("arcade.ogg", Music.class);
        music.setLooping(true);
        music.play();
*/

      mygame = new GameModel(game);
        this.game = game;
        background =  new Texture("road.png");

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

        GlyphLayout ScoreDisplay = new GlyphLayout(mygame.getLevel().getMyscore(), "" + mygame.getLevel().getThescore(), Color.WHITE, 0, Align.left, false);
        mygame.getLevel().getMyscore().draw(game.batch, ScoreDisplay, ZombieInvaders.WIDTH / 2 - ScoreDisplay.width / 2 - 150,ZombieInvaders.HEIGHT - ScoreDisplay.height - 10);

        GlyphLayout BananasDisplay = new GlyphLayout(mygame.getLevel().getMybananas(), "" + mygame.getLevel().getThenrbananas(), Color.YELLOW, 0, Align.left, false);
        mygame.getLevel().getMyscore().draw(game.batch, BananasDisplay, ZombieInvaders.WIDTH / 2 - BananasDisplay.width / 2,ZombieInvaders.HEIGHT - BananasDisplay.height - 10);

        GlyphLayout LifeDisplay = new GlyphLayout(mygame.getLevel().getMylife(), "" + mygame.getLevel().getHealth(), Color.RED, 0, Align.left, false);
        mygame.getLevel().getMyscore().draw(game.batch, LifeDisplay, ZombieInvaders.WIDTH / 2 - LifeDisplay.width / 2 + 150,ZombieInvaders.HEIGHT - LifeDisplay.height - 10);

        for (BulletModel bullet : mygame.getLevel().getBullets()) {
            bullet.render(game.batch);
        }

        for (ZombieModel zombie : mygame.getLevel().getZombies()) {
            zombie.render(game.batch);
        }

        for (BananasModel banana : mygame.getLevel().getBananas()) {
            banana.render(game.batch);
        }

        for (MorangoModel morango : mygame.getLevel().getMorangos()) {
            morango.render(game.batch);
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


        game.batch.draw(mygame.getLevel().getWhiteshape(), 0 , 0, ZombieInvaders.WIDTH * mygame.getLevel().getHealth(), 5);
        game.batch.setColor(Color.WHITE);

        game.batch.draw(mygame.getLevel().getRolls()[mygame.getLevel().getRoll()].getKeyFrame(mygame.getLevel().getStateTime(), true), mygame.getLevel().getx(), mygame.getLevel().gety(), 41, 58);

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
