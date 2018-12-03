package com.hdev.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hdev.game.shape.ShapeExample;

public class Game2DDemo extends ApplicationAdapter {
	private int width_screen;
	private int height_screen;
	// Vẽ hình
	private SpriteBatch batch;
	private Texture img;
	// Vẽ chuỗi
	private BitmapFont bitmapFont;
	private final String MSG = "Hoang DevPro";
	private final String WELCOME = "Welcome!";
	private ShapeExample shapeExample;
	private boolean success = false;
	private int current_location = 0;
	
	@Override
	public void create () {
		//TODO 1. Khởi tạo game
		batch = new SpriteBatch();
		img = new Texture("mario.jpg");
		bitmapFont = new BitmapFont();
		getSizeScreen();
		Gdx.app.log("Width: " , ""+width_screen);
	}

	@Override
	public void resize(int width, int height) {
		// TODO 2. Thay đổi kích thước trong game theo thiết bị.
		super.resize(width, height);
	}

	@Override
	public void render () {
		// TODO 3. Xử lý vòng lặp game
		setBackgroundColor();
		setTextStyle();
		shapeExample = new ShapeExample();
		//Bắt đầu vẽ
		batch.begin();
		startDraw();
		batch.end();
	}

	@Override
	public void pause() {
		// TODO 3. Pause game
		super.pause();
	}

	@Override
	public void resume() {
		// Chuyen tu pause -> start
		super.resume();
	}

	@Override
	public void dispose() {
		// Được gọi khi kết thúc game
		batch.dispose();
	}

	public void setBackgroundColor(){
		// Thiết lập màu nền
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	public void setTextStyle(){
		// Thiết lập cỡ chữ, màu chữ
		bitmapFont.getData().setScale(2f, 2f);
		bitmapFont.setColor(Color.BLUE);
	}

	public void startDraw(){
		// Vẽ hình
		//batch.draw(img, current_location, height_screen/2);
		if (!success) {
			run_animation();
		}else {
			batch.draw(img, 0, height_screen/2);
			bitmapFont.draw(batch, WELCOME, width_screen/2, (float) (height_screen*0.1));
		}
		// Vẽ chuỗi ký tự
		bitmapFont.draw(batch, MSG, width_screen/3, (float) (height_screen * 0.9));
	}

	private void run_animation(){
		if (current_location < width_screen){
			batch.draw(img, current_location, height_screen/2);
			current_location += 50;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			success = true;
		}
	}

	private void getSizeScreen(){
		width_screen = Gdx.graphics.getWidth();
		height_screen = Gdx.graphics.getHeight();
	}
}
