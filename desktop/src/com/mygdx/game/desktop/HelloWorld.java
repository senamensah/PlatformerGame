package com.mygdx.game.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class HelloWorld extends ApplicationAdapter{
    ShapeRenderer shapeRenderer;

    float circleX = 300;
    float circleY = 100;

    float xSpeed = 100;
    float ySpeed = 100;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render () {
        if(Gdx.input.isTouched()){
            circleX = Gdx.input.getX();
            circleY = Gdx.graphics.getHeight() - Gdx.input.getY();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            circleY++;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            circleY--;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            circleX++;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            circleX--;
        }
      /*  circleX += xSpeed * Gdx.graphics.getDeltaTime();;
        circleY += ySpeed * Gdx.graphics.getDeltaTime();;*/

        if(circleX < 0 || circleX > Gdx.graphics.getWidth()){
            xSpeed *= -1;
        }

        if(circleY < 0 || circleY > Gdx.graphics.getHeight()){
            ySpeed *= -1;
        }

        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.circle(circleX, circleY, 50);
        shapeRenderer.end();
    }

    @Override
    public void dispose () {
        shapeRenderer.dispose();
    }
}
