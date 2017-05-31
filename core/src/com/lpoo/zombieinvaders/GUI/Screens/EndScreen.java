package com.lpoo.zombieinvaders.GUI.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.lpoo.zombieinvaders.Logic.Entities.EndScreenModel;
import com.lpoo.zombieinvaders.ZombieInvaders;

import java.util.ArrayList;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

/**
 * Created by bernardoleite on 27/05/17.
 */

public class EndScreen implements Screen {

    GlyphLayout replayShape;
    GlyphLayout backMenuShape;


    private float replayA;
    private float replayB;
    private float backMenuA;
    private float backMenuB;

    float clickA;
    float clickB;


    private EndScreenModel endScreenModel;
    ZombieInvaders game ;


    public EndScreen(ZombieInvaders game, int myscore){

        endScreenModel = new EndScreenModel(game, myscore);

        this.game = game;

    }

    public int optionMenu(){

        replayShape = new GlyphLayout(endScreenModel.getFontScore(), "Play Again");
        backMenuShape = new GlyphLayout(endScreenModel.getFontScore(), "Return Menu");

        replayA = ZombieInvaders.WIDTH / 2 - replayShape.width / 2;
        replayB = ZombieInvaders.HEIGHT / 2 - replayShape.height / 2;
        backMenuA = ZombieInvaders.WIDTH / 2 - backMenuShape.width / 2;
        backMenuB = ZombieInvaders.HEIGHT / 2 - backMenuShape.height / 2 - replayShape.height - 15;

        clickA = game.mycam.getInputInGameWorld().x;
        clickB = ZombieInvaders.HEIGHT - game.mycam.getInputInGameWorld().y;

        if (Gdx.input.isTouched()) {
            if (clickA > replayA && clickA < replayA + replayShape.width && clickB > replayB - replayShape.height && clickB < replayB) {
                this.dispose();
                game.batch.end();
                game.setScreen(new GameScreen(game));
                return 1;
            }

            if (clickA > backMenuA && clickA < backMenuA + backMenuShape.width && clickB > backMenuB - backMenuShape.height && clickB < backMenuB) {
                this.dispose();
                game.batch.end();
                game.setScreen(new GameMenu(game));
                return 1;
            }

        }

        return 0;

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        game.batch.draw(endScreenModel.getTheEndflag(), ZombieInvaders.WIDTH / 2 - endScreenModel.FLAG_WIDTH
        / 2, ZombieInvaders.HEIGHT - endScreenModel.FLAG_HEIGHT - 15, endScreenModel.FLAG_WIDTH, endScreenModel.FLAG_HEIGHT);

        GlyphLayout scoreShape = new GlyphLayout(endScreenModel.getFontScore(), "Score: \n" + endScreenModel.getMyscore(), Color.WHITE, 0, Align.left, false);
        GlyphLayout bestScoreShape = new GlyphLayout(endScreenModel.getFontScore(), "Max Score: \n" + endScreenModel.getBestScore(), Color.WHITE, 0, Align.left, false);

        endScreenModel.getFontScore().draw(game.batch, scoreShape, ZombieInvaders.WIDTH / 2 - scoreShape.width / 2, ZombieInvaders.HEIGHT - endScreenModel.FLAG_HEIGHT - 15 * 2 );
        endScreenModel.getFontScore().draw(game.batch, bestScoreShape, ZombieInvaders.WIDTH / 2 - bestScoreShape.width / 2, ZombieInvaders.HEIGHT - endScreenModel.FLAG_HEIGHT - scoreShape.height - 15 * 3 );

        if( optionMenu() == 1)
            return;

        endScreenModel.getFontScore().draw(game.batch, replayShape, replayA,replayB);
        endScreenModel.getFontScore().draw(game.batch, backMenuShape, backMenuA, backMenuB);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
