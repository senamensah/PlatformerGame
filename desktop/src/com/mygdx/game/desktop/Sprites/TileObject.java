package com.mygdx.game.desktop.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.desktop.FourSeasons;

public abstract class TileObject {
    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;
    protected Fixture fix;

    public TileObject(World world, TiledMap map, Rectangle bounds){
        this.world = world;
        this.map = map;
        this.bounds = bounds;

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape poly = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/ FourSeasons.PPM, (bounds.getY() + bounds.getHeight()/2)/FourSeasons.PPM);
        body = world.createBody(bdef);
        poly.setAsBox((bounds.getWidth()/2)/FourSeasons.PPM, (bounds.getHeight()/2)/FourSeasons.PPM);
        fdef.shape = poly;
        fix = body.createFixture(fdef);
    }

    public abstract void hit();
    public void setCatFilter(short filterBit){
        Filter fil = new Filter();
        fil.categoryBits = filterBit;
        fix.setFilterData(fil);
    }

}
