package com.merciless.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {
	public static void createWindow(int Width, int Height) 
	{
		try {
			Display.setDisplayMode(new DisplayMode(Width, Height));
			Display.create();
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setTitle(String Title) {
		Display.setTitle(Title);
	}
	
	public static void render()
	{
		Display.update();
	}
	
	public static void cleanUp()
	{
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}
	
	public static boolean isCloseRequested()
	{
		return Display.isCloseRequested();
	}
}
