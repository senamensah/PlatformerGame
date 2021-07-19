package com.mygdx.game.desktop.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.desktop.FourSeasons;
import com.mygdx.game.desktop.Sprites.Player;

public class Hud implements Disposable {
    public Stage stage;
    private Viewport portHUD;

    private Integer worldTimer;
    private float time;
    private static Integer life;
    private static Integer fruits;

    private static Label numLivesLabel;
    private static Label  numFruitsLabel;
    private Label fruitLabel;
    private Label lifeLabel;

    public Hud(SpriteBatch batch){
        worldTimer = 300;
        time = 0;
        life = 10;
        fruits = 0;
        portHUD = new FitViewport(FourSeasons.vWidth,FourSeasons.vHeight, new OrthographicCamera());
        stage = new Stage(portHUD, batch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);


        numLivesLabel = new Label(String.format("%02d", life), new Label.LabelStyle(new BitmapFont(), Color.BLACK));

        numFruitsLabel = new Label(String.format("%02d", fruits), new Label.LabelStyle(new BitmapFont(), Color.BLACK));;
        fruitLabel = new Label("FRUITS", new Label.LabelStyle(new BitmapFont(), Color.BLACK));;
        lifeLabel = new Label("LIVES", new Label.LabelStyle(new BitmapFont(), Color.BLACK));;

        table.add(lifeLabel).expandX().padTop(10);
        table.add(fruitLabel).expandX().padTop(10);
        table.row();
        table.add(numLivesLabel).expandX();
        table.add(numFruitsLabel).expandX();

        stage.addActor(table);
        if(life == 0){
            Player.die();
        }

    }

    public static void addFruits(int numFruits){
       fruits += numFruits;
       numFruitsLabel.setText(String.format("%02d", fruits));
    }

    public static void subLives(int lives){
        life -= lives;
        numLivesLabel.setText(String.format("%02d", life));
    }

    public static Integer getLives(){
        return life;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
