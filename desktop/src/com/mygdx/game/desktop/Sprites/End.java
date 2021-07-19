package com.mygdx.game.desktop.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.desktop.FourSeasons;

public class End extends TileObject{
    public End(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        fix.setUserData(this);
        setCatFilter(FourSeasons.endB);
    }

    @Override
    public void hit() {
        Gdx.app.log("end","hit");
        setCatFilter(FourSeasons.disappearB);
        Player.playerWon = true;
       // FourSeasons.assMan.get("audio/music/success.ogg", Music.class).play();

    }
}

