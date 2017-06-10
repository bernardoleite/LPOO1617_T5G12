package com.lpoo.zombieinvaders.Tools;

/**
 * Created by bernardoleite on 06/06/17.
 */

public class Ability {

    private int DURATION;

    private long activatedAt = Long.MAX_VALUE;

    public Ability(){

        DURATION = 6000 + (int)(Math.random() * 10000);

    }

    public void activate() {
        activatedAt = System.currentTimeMillis();
    }

    public boolean isActive() {
        long activeFor = System.currentTimeMillis() - activatedAt;

        return activeFor >= 0 && activeFor <= DURATION;
    }
}
