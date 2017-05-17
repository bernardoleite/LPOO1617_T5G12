package com.lpoo.zombieinvaders.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lpoo.zombieinvaders.GUI.Scenes.Hud;
import com.lpoo.zombieinvaders.GUI.Entities.RickGrimes;
import com.lpoo.zombieinvaders.GUI.Tools.B2WorldCreator;
import com.lpoo.zombieinvaders.Logic.ZombieInvaders;

/**
 * Created by bernardoleite on 11/05/17.
 */

public class PlayScreen implements Screen {

    //11 - Music

    private Music music;

    //criar Textura da personagem - 10
    private TextureAtlas atlas;

    //objeto principal game
    private ZombieInvaders game;

    //camera pode ser usada para seguir a personagem ao longo do jogo
    private OrthographicCamera gamecam;

    //Criado para manter um "aspect ratio" independetemente do tamanho do ecrã
    private Viewport gamePort;

    //Criador de Hud para informar scores/tempos/níveis
    private Hud hud;

    //Coisas do mapa
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer; //faz o render do mapa para a screen - 6

    //Box2d - 7
    private World world;
    private Box2DDebugRenderer b2dr;

    //Rick class object - 8
    private RickGrimes player;

    public PlayScreen(ZombieInvaders game){

        //criar Textura da personagem - 10
        atlas = new TextureAtlas("Mario_and_Enemies.pack");

        this.game = game;

        gamecam = new OrthographicCamera();

        //Neste caso, a melhor porta para Desktop
        gamePort = new FitViewport(ZombieInvaders.V_WIDTH /ZombieInvaders.PPM, ZombieInvaders.V_HEIGHT / ZombieInvaders.PPM,gamecam );

        //criar a Hud - 4
        hud = new Hud(game.batch);

        //carregar mapa - 6
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / ZombieInvaders.PPM);

        //inicialmente coloca gamecam centrada no ínicio do mapa
        gamecam.position.set(gamePort.getWorldWidth() /2, gamePort.getWorldHeight() / 2, 0);



        //box2d: colocar 0 de gravidade em X e -10 em Y - 7
        world = new World(new Vector2(0,-10), true); //gravidade

        //faz o debug das linhas da box2d
        b2dr = new Box2DDebugRenderer();

        //16 - Refactoring
        //Criar as Layers do Mundo - 9 (adicionado segundo argumento em 10)
        new B2WorldCreator(this);

        //Inicializar Rick - 8
        player = new RickGrimes(this);

        //11 - Music
        music = ZombieInvaders.manager.get("audio/music/mario_music.ogg", Music.class);
        music.setLooping(true);
        music.play();

    }




    //Criado para criar Personagem - 10

    public TextureAtlas getAtlas(){

        return atlas;
    }






    @Override
    public void show() {



    }

    //Input Rato - 8
    public void handleInput(float dt){
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && player.getCanJump())
            player.b2body.applyLinearImpulse(new Vector2(0,4f), player.b2body.getWorldCenter(), true);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2)
            player.b2body.applyLinearImpulse(new Vector2(0.1f,0), player.b2body.getWorldCenter(), true);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x >= -2)
            player.b2body.applyLinearImpulse(new Vector2(-0.1f,0), player.b2body.getWorldCenter(), true);

        // if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2)
        //gamecam.position.x += 10 / MarioBros.PPM;
    }

    //criada para fazer o update do jogo (inputs) - 6
    public void update(float dt){

        //input do utilizador
        handleInput(dt);

        //toma 1 passo na simulação de física( 60 vezes por segundo) - 8
        world.step(1/60f, 6, 2);

        //Criação de Sprite em torno da circunferência - 10
        player.update(dt);

        //Sempre que a personagem se move , utiliza-se isto para o seguir
        //Reparar que isto aplica-se ao movimento nos eixo do x apenas - 8
        gamecam.position.x = player.b2body.getPosition().x;

        //update a gamecam com as corretas coordenadas depois de eventuais mudanças
        gamecam.update();

        //dizer ao render para desenhar apenas o que a câmera pode ver no mundo
        renderer.setView(gamecam);

    }

    @Override
    public void render(float delta) {

        //separar a atualiação da lógica do reder - 6
        update(delta);

        //Apagar o ecrã com preto
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Render o game map - Tile Map - 6
        renderer.render();

        //render Box2dDebugLines - 7
        b2dr.render(world,gamecam.combined);


        //Criação de Sprite em torno da circunferência - 10
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        player.draw(game.batch);
        game.batch.end();


        //Hud - 4
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();


    }


    //Ajudas o tamanho de ecrã
    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
    }


    //16 -  Zombie Anatomy
    public TiledMap getMap(){
        return map;
    }

    public World getWorld(){
        return world;
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

    // 9
    @Override
    public void dispose() {

        //fazer o dispose de todos os recursos abertos
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();
    }
}
