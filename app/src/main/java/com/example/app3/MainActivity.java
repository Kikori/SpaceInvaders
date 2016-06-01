package com.example.app3;

import com.example.app3.globals.GameDifficulty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GameDifficulty.active = GameDifficulty.medium;
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
		//setContentView(new GameView(this));
        
        Button start = (Button) findViewById(R.id.btn_menu_play);
        start.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startGame();
            }
        });
       
        Button settings = (Button) findViewById(R.id.btn_menu_settings);
        settings.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                displaySettings();
            }
        });
        
        Button quit = (Button) findViewById(R.id.btn_menu_quit);
        quit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                quit();
            }
        });
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
     public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
	        case R.id.menu_settings:
	          displaySettings();
	          return true;
	        case R.id.menu_quit:
	        	Toast.makeText(this, "Leaving app", Toast.LENGTH_SHORT).show();
	          quit();
	          return true;           
	        default:
	          return super.onOptionsItemSelected(item);
        } 
    }
     
    public void startGame(){
    	Intent myIntent = new Intent(MainActivity.this, GameActivity.class);
    	myIntent.putExtra("level", 5);
    	startActivity(myIntent);
    }
    
    public void displaySettings(){
    	Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
    	MainActivity.this.startActivity(myIntent);
    	
    }
    
    public void quit(){
    	finish();
        System.exit(0);
    }
 
}
