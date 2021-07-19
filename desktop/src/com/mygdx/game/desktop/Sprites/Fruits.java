package com.mygdx.game.desktop.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.desktop.FourSeasons;
import com.mygdx.game.desktop.Scenes.Hud;

public class Fruits extends TileObject{
    public Fruits(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        fix.setUserData(this);
        setCatFilter(FourSeasons.fruitB);
    }

    @Override
    public void hit() {
        Gdx.app.log("fruit","hit");
        setCatFilter(FourSeasons.disappearB);
        Hud.addFruits(1);
        FourSeasons.assMan.get("audio/sounds/getFruit.wav", Sound.class).play();
        //getCell().setTile(null);
    }
}
