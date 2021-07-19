package com.mygdx.game.desktop.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class Ceiling extends TileObject{
    public Ceiling(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        fix.setUserData(this);
    }

    @Override
    public void hit() {
        Gdx.app.log("ceiling","hit");
    }
}
