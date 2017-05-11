package com.lpoo.zombieinvaders.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lpoo.zombieinvaders.GUI.Scenes.Hud;
import com.lpoo.zombieinvaders.ZombieInvaders;

/**
 * Created by bernardoleite on 11/05/17.
 */

public class PlayScreen implements Screen {

    private ZombieInvaders game;          //objeto principal game
    private OrthographicCamera gamecam;  //camera
    private Viewport gamePort;           //camera
    private Hud hud;                    //tabelas

    public PlayScreen(ZombieInvaders game){
        this.game = game; //variável jogo
        gamecam = new OrthographicCamera();

        //Neste caso, a melhor porta para Desktop
        gamePort = new FitViewport(ZombieInvaders.V_WIDTH,ZombieInvaders.V_HEIGHT,gamecam);

        hud = new Hud(game.batch);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        //Apagar o ecrã
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Hud
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }


    //Ajudas o tamanho de ecrã
    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
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
