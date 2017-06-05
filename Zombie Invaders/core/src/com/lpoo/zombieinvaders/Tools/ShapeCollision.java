package com.lpoo.zombieinvaders.Tools;

/**
 * Created by bernardoleite on 27/05/17.
 */

public class ShapeCollision {

    public float x, y;
    int width, height;

    public ShapeCollision(float x, float y, int width, int height) {

        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    //funcao que faz o check da colisão (imaginar colisão entre retangulos)
    public boolean checkCollision (ShapeCollision rect){
        return  x < rect.x + rect.width &&
                y < rect.y + rect.height &&
                x + width > rect.x &&
                y + height > rect.y;
    }

    public void move(float x, float y) {
        this.x = x; this.y = y;
    }




}
