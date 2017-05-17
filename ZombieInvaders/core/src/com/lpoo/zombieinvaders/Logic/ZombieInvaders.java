package com.lpoo.zombieinvaders.Logic;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoo.zombieinvaders.GUI.PlayScreen;

public class ZombieInvaders extends Game {

	//Tamanho virtuais para mandar para PlayScreen
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM = 100; // Utilizar para escalar - 8

	public SpriteBatch batch;

	//11 - Music
	public static AssetManager manager;

	@Override
	public void create () {
		batch = new SpriteBatch();

		//11 - Music
		manager = new AssetManager();
		manager.load("audio/music/mario_music.ogg", Music.class);
		manager.load("audio/sounds/coin.wav", Sound.class);
		manager.load("audio/sounds/bump.wav", Sound.class);
		manager.load("audio/sounds/breakblock.wav", Sound.class);
		manager.finishLoading();

		setScreen (new PlayScreen(this)); //enviar objeto jogo para a GUI

	}

	@Override
	public void render () {

		super.render();

	}


}
