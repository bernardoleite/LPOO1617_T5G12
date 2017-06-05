package com.lpoo.zombieinvaders;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.lpoo.zombieinvaders.GUI.Screens.EndScreen;
import com.lpoo.zombieinvaders.GUI.Screens.GameMenu;
import com.lpoo.zombieinvaders.GUI.Screens.GameScreen;
import com.lpoo.zombieinvaders.Tools.ViewCamera;

public class ZombieInvaders extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 720;
	public static boolean MOBILE = false;

	public SpriteBatch batch;

	public static AssetManager manager;

	public ViewCamera mycam;

	@Override
	public void create () {
		batch = new SpriteBatch();

		mycam = new ViewCamera(WIDTH, HEIGHT);

		if(Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS)
			MOBILE = true;

		//MOBILE = true;
		manager = new AssetManager();
		manager.load("arcade.ogg", Music.class);
		manager.finishLoading();

		this.setScreen(new GameMenu(this));
	}

	@Override
	public void render () {
		batch.setProjectionMatrix(mycam.combined());

		super.render();
	}



	@Override
	public void resize(int width, int height) {
		mycam.update(width, height);
		super.resize(width, height);
	}


}
