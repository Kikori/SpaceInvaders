package com.example.app3;

import com.example.app3.globals.GameDifficulty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();		
		setContentView(R.layout.activity_settings);
		
		SeekBar seekBar = (SeekBar)findViewById(R.id.gameSpeed_seekbar);
		final TextView seekBarValue = (TextView)findViewById(R.id.difficultyValue); 

		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

			   @Override 
			   public void onProgressChanged(SeekBar seekBar, int progress, 
					   boolean fromUser) { 
				   			switch (progress){
				   			case 0:
				   				seekBarValue.setText("Too easy man");
				   				GameDifficulty.active = GameDifficulty.veryeasy;
				   				break;
				   			case 1:
				   				seekBarValue.setText("You can do this");
				   				GameDifficulty.active = GameDifficulty.easy;
				   				break;
				   			case 2:
				   				seekBarValue.setText("Good luck");
				   				GameDifficulty.active = GameDifficulty.medium;
				   				break;
				   			case 3:
				   				seekBarValue.setText("You stand no chance");
				   				GameDifficulty.active = GameDifficulty.hard;
				   				break;
				   			case 4:
				   				seekBarValue.setText("This is just insane");
				   				GameDifficulty.active = GameDifficulty.veryhard;
				   				break;
				   			}
			    //seekBarValue.setText(String.valueOf(progress)); 
			   } 

			   @Override 
			   public void onStartTrackingTouch(SeekBar seekBar) { 
			   } 

			   @Override 
			   public void onStopTrackingTouch(SeekBar seekBar) { 
			   } 
       });
	}

	    
}
