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



	//13&16 - Box2D Collision Bits
	public static final short GROUND_BIT = 1;
	public static final short RICK_BIT = 2;
	public static final short BRICK_BIT = 4;
	public static  final short COIN_BIT = 8;
	public static final short DESTROYED_BIT = 16 ;

	public static final short OBJECT_BIT = 32;
	public static final short ENEMY_BIT = 64;

	//17 - Stomping Walker
	public static  final short ENEMY_HEAD_BIT = 128;


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
