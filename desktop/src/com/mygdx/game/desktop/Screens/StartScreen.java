package com.mygdx.game.desktop.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.desktop.FourSeasons;

public class StartScreen implements Screen {
    public Stage stage;
    private Viewport portS;
    private Game game;
    Texture texture;
    SpriteBatch batch;

    public StartScreen(Game game){
        this.game = game;
        portS = new FillViewport(FourSeasons.vWidth, FourSeasons.vHeight, new OrthographicCamera());
        stage = new Stage(portS, ((FourSeasons) game).batch);
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("images.jpg"));
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Label.LabelStyle font2 = new Label.LabelStyle(new BitmapFont(), Color.BLACK);
        Label.LabelStyle font3 = new Label.LabelStyle(new BitmapFont(), Color.BLUE);

        Table tab = new Table();
        tab.center();
        tab.setFillParent(true);

        Label gOLabel = new Label("Four Seasons", font2);
        Label pALabel = new Label("Click to play!", font2);
        Label controlLabel = new Label("Press spacebar to learn how to play!", font3);
        //Button test = new Button
        tab.add(gOLabel).expandX();
        tab.row();
        tab.add(pALabel).expandX().padTop(10);
        tab.row();
        tab.add(controlLabel).expandX().padTop(10);

        stage.addActor(tab);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            game.setScreen(new PlayScreen((FourSeasons) game));
            dispose();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            game.setScreen(new ControlScreen(game));
            dispose();
        }
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       /* float x = 125;
        float y = 50;
        int srcX = 100;
        int srcY = 30;
        int srcWidth = FourSeasons.vWidth;
        int srcHeight = FourSeasons.vHeight;
        batch.begin();
        //batch.draw(texture, x, y, srcX, srcY, srcWidth, srcHeight);
        batch.draw(texture, 10, 5);
        batch.end();*/
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
