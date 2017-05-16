package com.lpoo.zombieinvaders.Logic;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoo.zombieinvaders.GUI.PlayScreen;

public class ZombieInvaders extends Game {

	//Tamanho virtuais para mandar para PlayScreen
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM = 100; // Utilizar para escalar - 8

	public SpriteBatch batch;


	@Override
	public void create () {
		batch = new SpriteBatch();

		setScreen (new PlayScreen(this)); //enviar objeto jogo para a GUI

	}

	@Override
	public void render () {
		super.render();
	}


}
