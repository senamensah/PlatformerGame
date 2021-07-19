package com.mygdx.game.desktop.WorldStuff;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.desktop.FourSeasons;
import com.mygdx.game.desktop.Sprites.*;

public class GameWorld {
    public GameWorld(World world, TiledMap map){
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //water
        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Water(world, map, rect);
        }

        //ground
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth()/2)/FourSeasons.PPM, (rect.getY() + rect.getHeight()/2)/FourSeasons.PPM);
            body = world.createBody(bdef);
            shape.setAsBox((rect.getWidth()/2)/FourSeasons.PPM, (rect.getHeight()/2)/FourSeasons.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        //fruits
        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Fruits(world,map,rect);
        }

        //wall
        for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Wall(world, map, rect);
        }

        //end
        for(MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new End(world, map, rect);
        }

        //ceiling
        for(MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Ceiling(world, map, rect);
        }
    }
}
