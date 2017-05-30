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
import com.lpoo.zombieinvaders.ZombieInvaders;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

/**
 * Created by bernardoleite on 27/05/17.
 */

public class EndScreen implements Screen {

    int myscore, bestScore;
    ZombieInvaders game;

    Texture theEndflag;
    BitmapFont fontScore;

    private static final int FLAG_WIDTH = 350;
    private static final int FLAG_HEIGHT = 100;

    public EndScreen(ZombieInvaders game, int myscore){
        this.game = game;
        this.myscore = myscore;

        //Para obter o melhor score
        Preferences conf = Gdx.app.getPreferences("zombieinvaders");
        this.bestScore = conf.getInteger("bestScore", 0);


        //Verificar se o score bate o melhorScore

        if(myscore > bestScore){
            conf.putInteger("bestScore", 0);
            conf.flush();
        }


        //Carregar texturas e fontes
        theEndflag = new Texture("game_over.png");
        fontScore = new BitmapFont(Gdx.files.internal("score.fnt"));
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        game.batch.draw(theEndflag, ZombieInvaders.WIDTH / 2 - FLAG_WIDTH
        / 2, ZombieInvaders.HEIGHT - FLAG_HEIGHT - 15, FLAG_WIDTH, FLAG_HEIGHT);

        GlyphLayout scoreShape = new GlyphLayout(fontScore, "Score: \n" + myscore, Color.WHITE, 0, Align.left, false);
        GlyphLayout bestScoreShape = new GlyphLayout(fontScore, "Best Score: \n" + myscore, Color.WHITE, 0, Align.left, false);

        fontScore.draw(game.batch, scoreShape, ZombieInvaders.WIDTH / 2 - scoreShape.width / 2, ZombieInvaders.HEIGHT - FLAG_HEIGHT - 15 * 2 );
        fontScore.draw(game.batch, bestScoreShape, ZombieInvaders.WIDTH / 2 - bestScoreShape.width / 2, ZombieInvaders.HEIGHT - FLAG_HEIGHT - scoreShape.height - 15 * 3 );

        GlyphLayout replayShape = new GlyphLayout(fontScore, "Replay");
        GlyphLayout backMenuShape = new GlyphLayout(fontScore, "Back to Menu");

        float replayA = ZombieInvaders.WIDTH / 2 - replayShape.width / 2;
        float replayB = ZombieInvaders.HEIGHT / 2 - replayShape.height / 2;
        float backMenuA = ZombieInvaders.WIDTH / 2 - backMenuShape.width / 2;
        float backMenuB = ZombieInvaders.HEIGHT / 2 - backMenuShape.height / 2 - replayShape.height - 15;

        float clickA = game.mycam.getInputInGameWorld().x;
        float clickB = ZombieInvaders.HEIGHT - game.mycam.getInputInGameWorld().y;


        if (Gdx.input.isTouched()) {
            if (clickA > replayA && clickA < replayA + replayShape.width && clickB > replayB - replayShape.height && clickB < replayB) {
                this.dispose();
                game.batch.end();
                game.setScreen(new GameScreen(game));
                return;
            }

            if (clickA > backMenuA && clickA < backMenuA + backMenuShape.width && clickB > backMenuB - backMenuShape.height && clickB < backMenuB) {
                this.dispose();
                game.batch.end();
                game.setScreen(new GameMenu(game));
                return;
            }

        }

        fontScore.draw(game.batch, replayShape, replayA,replayB);
        fontScore.draw(game.batch, backMenuShape, backMenuA, backMenuB);

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
