package com.mygdx.game.desktop.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.desktop.FourSeasons;

public class WinScreen implements Screen {
    public Stage stage;
    private Viewport portW;
    private Game game;

    public WinScreen(Game game){
        this.game = game;
        portW = new FillViewport(FourSeasons.vWidth, FourSeasons.vHeight, new OrthographicCamera());
        stage = new Stage(portW, ((FourSeasons) game).batch);
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Label.LabelStyle font2 = new Label.LabelStyle(new BitmapFont(), Color.BLACK);
        Label.LabelStyle font3 = new Label.LabelStyle(new BitmapFont(), Color.YELLOW);

        Table tab = new Table();
        tab.center();
        tab.setFillParent(true);

        Label gOLabel = new Label("YOU WIN!!", font2);
        Label pALabel = new Label("Click to PLAY AGAIN", font2);
        Label sSLabel = new Label("Press spacebar to go to main screen", font3);
        tab.add(gOLabel).expandX();
        tab.row();
        tab.add(pALabel).expandX().padTop(10f);
        tab.row();
        tab.add(sSLabel).expandX().padTop(10f);

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
            game.setScreen(new StartScreen(game));
            dispose();
        }
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
