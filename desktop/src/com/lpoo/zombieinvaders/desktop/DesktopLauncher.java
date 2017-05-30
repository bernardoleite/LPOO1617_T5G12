package com.lpoo.zombieinvaders.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lpoo.zombieinvaders.ZombieInvaders;

public class DesktopLauncher {
	public static void main (String[] arg) {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.foregroundFPS = 60;
			config.width = ZombieInvaders.WIDTH;
			config.height = ZombieInvaders.HEIGHT;
			//config.resizable = false;
			new LwjglApplication(new ZombieInvaders(), config);
	}
}
