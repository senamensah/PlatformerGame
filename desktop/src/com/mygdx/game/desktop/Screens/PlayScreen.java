package com.mygdx.game.desktop.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.*;
import com.mygdx.game.desktop.FourSeasons;
import com.mygdx.game.desktop.Scenes.Hud;
import com.mygdx.game.desktop.Sprites.Player;
import com.mygdx.game.desktop.WorldStuff.GameWorld;
import com.mygdx.game.desktop.WorldStuff.WorldContactListener;

public class PlayScreen implements Screen{
    private FourSeasons game;
    private OrthographicCamera cam;
    private Viewport port;
    private Hud hud;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private Player player;
    private TextureAtlas atlas;
    private Music music;




    public PlayScreen(FourSeasons game){
        //aspectRatio = (float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();
        atlas = new TextureAtlas("Player.txt");
        this.game = game;
        cam = new OrthographicCamera();//(25*aspectRatio, 25);
        port = new FitViewport(FourSeasons.vWidth/FourSeasons.PPM,FourSeasons.vHeight/FourSeasons.PPM, cam);
        hud = new Hud(game.batch);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("seasons.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/FourSeasons.PPM);
        cam.position.set(port.getWorldWidth()/2, port.getWorldHeight()/2, 0);
        world = new World(new Vector2(0,-10), true);
        debugRenderer = new Box2DDebugRenderer();
        new GameWorld(world, map);
        player = new Player(world, this);
        //world.setContactListener();
        music = FourSeasons.assMan.get("audio/music/gameLoop3.ogg", Music.class);
        music.setLooping(true);
        music.play();



    }
    @Override
    public void show() {

    }

    public TextureAtlas getAtlas(){
        return atlas;
    }

    public void handleInput(float delta){
        if(player.currentState != Player.State.DEAD) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP) || Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                player.body.applyLinearImpulse(new Vector2(0, 3f), player.body.getWorldCenter(), true);
            }
            if ((Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) && player.body.getLinearVelocity().x <= 2) {
                player.body.applyLinearImpulse(new Vector2(0.08f, 0), player.body.getWorldCenter(), true);
            }
            if ((Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) && player.body.getLinearVelocity().x >= -2) {
                player.body.applyLinearImpulse(new Vector2(-0.08f, 0), player.body.getWorldCenter(), true);
            }
        }
        else{Player.die();}
    }

    public void update(float delta){
        handleInput(delta);
        world.step(1/50f, 6, 2);
        player.update(delta);
        cam.position.x = player.body.getPosition().x;
        cam.update();
        renderer.setView(cam);


    }

    public boolean win(){
        if(Player.playerWon == true){
            return true;
        }
        return false;
    }
    public boolean gameOver(){
        if(Hud.getLives() == 0){
            return true;
        }
        return false;
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();

        game.batch.setProjectionMatrix(cam.combined);
        game.batch.begin();
        player.draw(game.batch);
        game.batch.end();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        //debugRenderer.render(world, cam.combined);
        world.setContactListener(new WorldContactListener());

        if(gameOver()){
            FourSeasons.assMan.get("audio/music/gameLoop3.ogg", Music.class).stop();
            FourSeasons.assMan.get("audio/sounds/gameOver2.wav", Sound.class).play();
            game.setScreen(new GameOver(game));
            dispose();
        }

        if(win()){
            FourSeasons.assMan.get("audio/music/gameLoop3.ogg", Music.class).stop();
            FourSeasons.assMan.get("audio/music/success.ogg", Music.class).play();
            game.setScreen(new WinScreen(game));
            dispose();
        }

    }

    @Override
    public void resize(int width, int height) {
        port.update(width, height);
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

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        debugRenderer.dispose();
        world.dispose();
        hud.dispose();
    }
}
