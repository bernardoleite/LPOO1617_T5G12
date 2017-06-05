package com.lpoo.zombieinvaders.GUI.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.lpoo.zombieinvaders.ZombieInvaders;

/**
 * Created by bernardoleite on 27/05/17.
 */

public class GameMenu implements Screen {

    private static final int EXIT_BUTTON_WIDTH = 250;
    private static final int EXIT_BUTTON_HEIGHT = 120;
    private static final int PLAY_BUTTON_WIDTH = 300;
    private static final int PLAY_BUTTON_HEIGHT = 120;
    private static final int EXIT_BUTTON_Y = 100;
    private static final int PLAY_BUTTON_Y = 230;
    public static final int FLAG_WIDTH = 350;
    public static final int FLAG_HEIGHT = 100;

    ZombieInvaders game;

    Texture playButtonActive;
    Texture playButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture title, background ;

    public GameMenu (ZombieInvaders game) {
        this.game = game;
        playButtonActive = new Texture("play_button_active.png");
        playButtonInactive = new Texture("play_button_inactive.png");
        exitButtonActive = new Texture("exit_button_active.png");
        exitButtonInactive = new Texture("exit_button_inactive.png");
        title = new Texture("title.png");
        background = new Texture("background.jpg");
    }

    @Override
    public void show () {

    }

    @Override
    public void render (float delta) {


        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(background,0,0);
        game.batch.draw(title, ZombieInvaders.WIDTH / 2 - FLAG_WIDTH / 2, ZombieInvaders.HEIGHT - FLAG_HEIGHT - 15, FLAG_WIDTH, FLAG_HEIGHT);

        int x = ZombieInvaders.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;

        if (game.mycam.getInputInGameWorld().x < x + EXIT_BUTTON_WIDTH && game.mycam.getInputInGameWorld().x > x && ZombieInvaders.HEIGHT - game.mycam.getInputInGameWorld().y < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && ZombieInvaders.HEIGHT - game.mycam.getInputInGameWorld().y > EXIT_BUTTON_Y) {
            game.batch.draw(exitButtonActive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            if (Gdx.input.isTouched()) {
                Gdx.app.exit();
            }
        } else {
            game.batch.draw(exitButtonInactive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }

        x = ZombieInvaders.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;
        if (game.mycam.getInputInGameWorld().x < x + PLAY_BUTTON_WIDTH && game.mycam.getInputInGameWorld().x > x && ZombieInvaders.HEIGHT - game.mycam.getInputInGameWorld().y < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && ZombieInvaders.HEIGHT - game.mycam.getInputInGameWorld().y > PLAY_BUTTON_Y) {
            game.batch.draw(playButtonActive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
            if (Gdx.input.justTouched()) {
                this.dispose();
                game.setScreen(new GameScreen(game));
            }
        } else {
            game.batch.draw(playButtonInactive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }

        game.batch.end();
    }

    @Override
    public void resize (int width, int height) {

    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {

    }

}
