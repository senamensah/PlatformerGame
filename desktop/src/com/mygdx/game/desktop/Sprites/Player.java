package com.mygdx.game.desktop.Sprites;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.desktop.FourSeasons;
import com.mygdx.game.desktop.Scenes.Hud;
import com.mygdx.game.desktop.Screens.PlayScreen;

public class Player extends Sprite {
   // private static boolean playerDead;

    public enum State {DEAD, ALIVE, WIN};
    public  static State currentState;
    public World world;
    public Body body;
    private TextureRegion stand;
    private  static boolean playerDead;
    public static boolean playerWon;

    public Player(World world, PlayScreen screen){
        super(screen.getAtlas().findRegion("F"));
        this.world = world;
        definePlayer();
        stand = new TextureRegion(getTexture(), 3, 3, 16, 16);
        setBounds(0,0, 16/FourSeasons.PPM, 16/FourSeasons.PPM);
        setRegion(stand);
        currentState = State.ALIVE;
        playerWon = false;
    }

    public void update(float delta){
        setPosition(body.getPosition().x - getWidth()/2, body.getPosition().y - getHeight()/2);
    }
    public void definePlayer(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(17/ FourSeasons.PPM,100/FourSeasons.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(7/FourSeasons.PPM);
        fdef.filter.categoryBits = FourSeasons.playerB;
        fdef.filter.maskBits = FourSeasons.defaultB | FourSeasons.fruitB | FourSeasons.waterB | FourSeasons.endB;

        fdef.shape = shape;
        body.createFixture(fdef);

        EdgeShape feet = new EdgeShape();
        feet.set(new Vector2(2/FourSeasons.PPM, -7/FourSeasons.PPM), new Vector2(-2/FourSeasons.PPM, -7/FourSeasons.PPM));
        fdef.shape = feet;
        fdef.isSensor = true;

        body.createFixture(fdef).setUserData("feet");
    }

    public static boolean die(){
        if(Hud.getLives() == 0){
            FourSeasons.assMan.get("audio/music/gameLoop3", Music.class).stop();
            FourSeasons.assMan.get("audio/sounds/gameOver", Sound.class).play();
            playerDead = true;
            currentState = State.DEAD;
            return true;
        }
        return false;
    }

    public boolean isDead(){
        return playerDead;
    }

}
