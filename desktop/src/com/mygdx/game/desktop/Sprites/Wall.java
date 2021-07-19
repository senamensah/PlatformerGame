package com.mygdx.game.desktop.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.desktop.FourSeasons;

public class Wall extends TileObject {
    public Wall(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        fix.setUserData(this);
    }

    @Override
    public void hit() {
        Gdx.app.log("wall","hit");
    }
}
