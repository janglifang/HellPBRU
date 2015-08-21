package janglifang;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;


	//**
	private Texture myTexture;  	//ตัวแปรชื่อ my Ctrl + Space ใช้เก็บรูปภาพ
	private int xAnInt;            //x กด Ctrl + space
	private Texture myWallpeper;  // wallpeper
	private boolean statusABoolean = true;
	@Override

	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		myTexture = new Texture("icon_cow.png");  //**ภาพ
		myWallpeper = new Texture("backgroundNun.png"); //พื้นหลัง
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		//batch.draw(img, 0, 0);
		//batch.draw(myTexture,0,0);

		batch.draw(myWallpeper, 0, 0);   //* ใช้ตัวแปรเข้ามาในการกำหนดพื้นหลัง

		batch.draw(myTexture, xAnInt, 200);  //* ใช้ตัวแปรเข้ามาในการกำหนดพื้นที่
		//ทุกครั้งที่มีการกระพริบ กำหนดให้เคลื่อนที่
		batch.end();
		//xAnInt += 100 * Gdx.graphics.getDeltaTime();


		//ทำให้ วัวเคลื่อนที่ไปกลับ
		if (statusABoolean) {
			//Increase xAnInt
			if (xAnInt < 921) {
				xAnInt += 100*Gdx.graphics.getDeltaTime();
			} else {
				statusABoolean = !statusABoolean;
			}
		} else {
			//Decrease xAnInt
			if (xAnInt > 0) {
				xAnInt -= 100 * Gdx.graphics.getDeltaTime();
			} else {
				statusABoolean = !statusABoolean;
			}
		}

	}
}
