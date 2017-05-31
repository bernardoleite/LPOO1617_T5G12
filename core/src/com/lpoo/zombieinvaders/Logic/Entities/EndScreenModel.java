package com.lpoo.zombieinvaders.Logic.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.lpoo.zombieinvaders.ZombieInvaders;

/**
 * Created by bernardoleite on 28/05/17.
 */

public class EndScreenModel {


    int myscore, bestScore;
    ZombieInvaders game;

    Texture theEndflag;
    BitmapFont fontScore;

    public static final int FLAG_WIDTH = 350;
    public static final int FLAG_HEIGHT = 100;


    public EndScreenModel(ZombieInvaders game, int myscore){

        this.game = game;
        this.myscore = myscore;

        //Para obter o melhor score
        Preferences conf = Gdx.app.getPreferences("zombieinvaders");
        this.bestScore = conf.getInteger("bestScore", 0);


        //Verificar se o score bate o melhorScore

        if(myscore > bestScore){
            conf.putInteger("bestScore", myscore);
            conf.flush();
        }


        //Carregar texturas e fontes
        theEndflag = new Texture("game_over.png");
        fontScore = new BitmapFont(Gdx.files.internal("score.fnt"));

    }

    public void updateOptions(){

    }

    public int getMyscore(){
        return myscore;
    }

    public int getBestScore(){
        return bestScore;
    }

    public Texture getTheEndflag(){
        return theEndflag;
    }

    public BitmapFont getFontScore(){
        return fontScore;
    }
}
