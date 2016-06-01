package com.example.app3;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameOverActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_game_over);
		
		Button playAgain = (Button) findViewById(R.id.btn_menu_play_again);
		playAgain.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent myIntent = new Intent(GameOverActivity.this, MainActivity.class);
	        	startActivity(myIntent);
            }
        });
	}
}
