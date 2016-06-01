package com.example.app3;
import com.example.app3.globals.GameDifficulty;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{

	private Alien[] aliens;
	public GameActivity gameActivity;
	private Bitmap bmp;
	private SurfaceHolder holder;
	public GameLoopThread gameLoopThread;
	private int x=0;
	private int y=0;
	//public int verticalSpeed=GameDifficulty.active.get(0);
	//public int horizontalSpeed=GameDifficulty.active.get(1);
	private boolean right=true;
	private boolean _bottom = false;
	private MediaPlayer mPlayer;
	
	public GameView(Context context){
	super(context);
	gameActivity = (GameActivity) context;
	gameLoopThread= new GameLoopThread(this);
	holder=getHolder();
	holder.addCallback(this);
	bmp=BitmapFactory.decodeResource(getResources(), R.drawable.space_invaders100x100);

	aliens = new Alien[60];	
	for(int i = 0; i<20; i++) {
		aliens[i] = new Alien(this, R.drawable.alien_1_1, R.drawable.alien_1_2);
		aliens[i].x = 50*i;
	}
	for(int i = 20; i<40; i++) {
		aliens[i] = new Alien(this, R.drawable.alien_2_1, R.drawable.alien_2_2);
		aliens[i].x = 50*i;
	}
	for(int i = 40; i<60; i++) {
		aliens[i] = new Alien(this, R.drawable.alien_3_1, R.drawable.alien_3_2);
		aliens[i].x = 50*i;
	}
	
	mPlayer = MediaPlayer.create(context, R.raw.space_invaders_soundtrack); // in 2nd param u have to pass your desire ringtone
	 //mPlayer.prepare();
	mPlayer.setLooping(true);
	mPlayer.start();
	}
		
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			boolean retry=true;
			gameLoopThread.setRunning(false);
			
			while (retry){
				try{
					gameLoopThread.join();
					retry=false;
				}catch(InterruptedException e){}
				
			}
			
		}
		
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			/*Canvas c=holder.lockCanvas(null);
			onDraw(c);
			holder.unlockCanvasAndPost(c);*/
			gameLoopThread.setRunning(true);
			gameLoopThread.start();
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
			
		}

	@Override
	protected void onDraw(Canvas canvas){
		canvas.drawColor(Color.BLACK);
		
		if (!_bottom){
			move(bmp,canvas);
		}

		
	}

private void move(Bitmap bmp, Canvas canvas) {
		
		/*if (right){
			if(x<getWidth()-bmp.getWidth()){				
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
		}*/
		
		/*if (y >= getHeight() - bmp.getHeight()){
			gameLoopThread.setRunning(false);
			gameLoopThread.interrupt();
			
			gameActivity.gameOver(10);
		}*/
		
		for(int i = 0; i<60; i++) {
			Alien alien = aliens[i];
			
			if(!alien.dead) {
				if(!alien.move(getHeight(), getWidth())) {
					gameLoopThread.setRunning(false);
					gameLoopThread.interrupt();
					
					mPlayer.stop();
					mPlayer = MediaPlayer.create(getContext(), R.raw.mario_game_over); // in 2nd param u have to pass your desire ringtone
					 //mPlayer.prepare();
					mPlayer.setLooping(false);
					mPlayer.start();
				
					gameActivity.gameOver(10);
				} else {
					if(!alien.dead) {
						if(alien.y % 100 == 0) {
							canvas.drawBitmap(alien.texture1, alien.x, alien.y, null);
						} else {
							canvas.drawBitmap(alien.texture2, alien.x, alien.y, null);
						}
					} else {
						canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.alien_dead), alien.x, alien.y, null);
					}
				}
			}
		}
	
		
	}
	
}
