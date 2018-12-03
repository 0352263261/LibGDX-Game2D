package com.hdev.game.shape;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ImageExample extends ApplicationAdapter {
    SpriteBatch spriteBatch;
    Texture texture;
    float x;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        // Anh de trong assets
        texture= new Texture(Gdx.files.internal("badlogic.jpg"));
        x = 0;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Bắt đầu vẽ
        spriteBatch.begin();
        spriteBatch.draw(texture, 10, 100);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
