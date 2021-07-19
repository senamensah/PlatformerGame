package com.mygdx.game.desktop.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class Start extends TileObject{
    public Start(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);

    }

    @Override
    public void hit() {

    }
}

