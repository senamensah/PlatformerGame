package com.mygdx.game.desktop.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.desktop.FourSeasons;
import com.mygdx.game.desktop.Scenes.Hud;

public class Water extends TileObject{
    public Water(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        fix.setUserData(this);
        setCatFilter(FourSeasons.waterB);
    }

    @Override
    public void hit() {
        Gdx.app.log("water","hit");
        Hud.subLives(1);
        System.out.println(Hud.getLives());
        FourSeasons.assMan.get("audio/sounds/hitWater.wav", Sound.class).play();
    }
}
