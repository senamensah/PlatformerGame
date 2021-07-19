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
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.desktop.FourSeasons;

public class ControlScreen implements Screen {
    public Stage stage;
    private Viewport portC;
    private Game game;

    public ControlScreen(Game game){
        this.game = game;
        portC = new FillViewport(FourSeasons.vWidth, FourSeasons.vHeight, new OrthographicCamera());
        stage = new Stage(portC, ((FourSeasons) game).batch);
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Label.LabelStyle font2 = new Label.LabelStyle(new BitmapFont(), Color.YELLOW);
        //Button.ButtonStyle butt = new Button.ButtonStyle();

        Table tab = new Table();
        tab.center();
        tab.setFillParent(true);

        Label gOLabel = new Label("Use the arrow keys or WAD to jump, move left and right", font);
        Label pALabel = new Label("Jump on the fruits to pick from them to save for the winter! ", font);
        Label pA2Label = new Label("Don't fall in the water!", font);
        Label clickLabel = new Label("Click to go back", font2);
        tab.add(gOLabel).expandX();
        tab.row();
        tab.add(pALabel).expandX().padTop(5f);
        tab.row();
        tab.add(pA2Label).expandX().padTop(5f);
        tab.row();
        tab.add(clickLabel).expandX().padTop(5f);

        stage.addActor(tab);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            game.setScreen(new StartScreen(game));
            dispose();
        }

        Gdx.gl.glClearColor(0, 0, 1, 1);
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
