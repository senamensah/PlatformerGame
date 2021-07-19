package com.mygdx.game.desktop.WorldStuff;

import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.desktop.Sprites.TileObject;

public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        if ("feet".equals(fixA.getUserData()) || "feet".equals(fixB.getUserData())) {
            Fixture h = fixA.getUserData() == "feet" ? fixA : fixB;
            Fixture obj = h == fixA ? fixB : fixA;

            if (obj.getUserData() != null && TileObject.class.isAssignableFrom(obj.getUserData().getClass())) {
                ((TileObject) obj.getUserData()).hit();
            }
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
