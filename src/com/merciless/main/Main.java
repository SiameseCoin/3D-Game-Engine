package com.merciless.main;

public class Main {
	
	public static int Width = 800;
	public static int Height = 600;
	public static String Title = "3D Game Engine";
	public static boolean running = false;
	public static final double FRAME_CAP = 5000.0;
	private Game game;
	
	public Main()
	{
		RenderUtil.initGraphics();
		game = new Game();
	}
	
	public void start()
	{
		running = true;
		run();
	}
	
	public static void stop()
	{
		running = false;
		System.err.println("Shutting Down Now!");
	}
	
	public void run()
	{
		running = true;
	
		int frames = 0;
				
		long frameCounter = 0;
		
		final double frameTime = 1.0 / FRAME_CAP;
		
		long lastTime = Time.getTime();
		
		double unprocessedTime = 0;
		
		while(running) {
			boolean render = false;
			
			long startTime = Time.getTime();
			
			long passedTime = startTime-lastTime;
			
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double)Time.SECOND;
			frameCounter += passedTime;
			
			while(unprocessedTime > frameTime) 
			{
				render = true;
				
				unprocessedTime -= frameTime;
			
				if(Window.isCloseRequested()) 
				{
					stop();
				}
				
				Time.setDelta(frameTime);
				
				Input.update();
				
				game.input();
				game.update();
				
				if(frameCounter >= Time.SECOND) {
					System.out.println(frames);
					String FPS = "FPS:" + frames;
					Window.setTitle(Title + " " + FPS);
					DrawText.drawString(FPS, 100, 100);
					frames=0;
					frameCounter=0;
				}
			}
			if(render){
				render();
				frames++;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
			
		cleanUp();
	}
	
	public void render()
	{
		RenderUtil.clearScreen();
		game.render();
		Window.render();
	}
	
	public void cleanUp()
	{
		Window.cleanUp();
	}
	
	public static void main(String[] args) 
	{
		Window.createWindow(Width, Height);
		Window.setTitle(Title);
		Main game = new Main();
		game.start();
	}
}
