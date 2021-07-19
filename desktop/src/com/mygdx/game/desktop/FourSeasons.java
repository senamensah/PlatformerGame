package com.mygdx.game.desktop;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.desktop.Screens.PlayScreen;
import com.badlogic.gdx.Game;
import com.mygdx.game.desktop.Scenes.Hud;
import com.mygdx.game.desktop.Screens.StartScreen;

public class FourSeasons extends Game {
    public SpriteBatch batch;
    public static final int vWidth = 400;
    public static final int vHeight = 425;
    public static final float PPM = 100;
    public static final short defaultB = 1;
    public static final short playerB = 2;
    public static final short fruitB = 4;
    public static final short waterB = 8;
    public static final short endB = 16;
    public static final short disappearB = 32;
    public static AssetManager assMan;

    @Override
    public void create() {
        batch = new SpriteBatch();
        assMan = new AssetManager();
        assMan.load("audio/music/gameLoop3.ogg", Music.class);
        assMan.load("audio/music/success.ogg", Music.class);
        assMan.load("audio/sounds/getFruit.wav", Sound.class);
        assMan.load("audio/sounds/gameOver2.wav", Sound.class);
        assMan.load("audio/sounds/hitWater.wav", Sound.class);
        assMan.finishLoading();
        setScreen(new StartScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        assMan.dispose();
        batch.dispose();
    }
}
