package com.lpoo.zombieinvaders;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.lpoo.zombieinvaders.ZombieInvaders;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config = new AndroidApplicationConfiguration();
		config.useGyroscope = false;  //default is false
//you may want to switch off sensors that are on by default if they are no longer needed.
		config.useAccelerometer = true;
		config.useCompass = false;
		initialize(new ZombieInvaders(), config);
	}
}
