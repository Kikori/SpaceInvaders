package com.example.app3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class GameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//setContentView(R.layout.activity_game);
		
		Intent intent = getIntent();
		
		setContentView(new GameView(this));
	}
	
	public void gameOver(int score) {
		Intent myIntent = new Intent(GameActivity.this, GameOverActivity.class);
		myIntent.putExtra("score", score);
    	startActivity(myIntent);
	}
}
