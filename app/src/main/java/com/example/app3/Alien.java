package com.example.app3;

import com.example.app3.globals.GameDifficulty;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Alien {

	private GameView gameView;
	public Bitmap texture1;
	public Bitmap texture2;
	public int x=0;
	public int y=-50;
	public int verticalSpeed=GameDifficulty.active.get(0);
	public int horizontalSpeed=GameDifficulty.active.get(1);
	private boolean right = false;
	private boolean _bottom = false;
	public boolean dead = false;
	
	public Alien(GameView gameView, int t1, int t2) {
		gameView = gameView;
		texture1 = BitmapFactory.decodeResource(gameView.getResources(), t1);
		texture2 = BitmapFactory.decodeResource(gameView.getResources(), t2);
	}
	
	public boolean move(int height, int width) {
		if (right){
			if(x<width-texture1.getWidth()){				
				x=x+horizontalSpeed;
			}
			else{
				right=false;
				y=y+verticalSpeed;
			}
		}
		else {
			if(x>0){
				x=x-horizontalSpeed;
			}
			else{
				right=true;
				y=y+verticalSpeed;
			}
		}
		
		if (y >= height - texture1.getHeight()){
			return false;
		}
		
		if(y > 0) {
			int random = (int)(Math.random() * (101-1)) + 1;
			if(random == 10) {
				dead = true;
			}
		}
		
		return true;
	}
	
}
