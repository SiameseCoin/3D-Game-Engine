package com.merciless.main;

import org.lwjgl.input.Keyboard;

public class Game {
	public Game() {

	}

	public void input() {
		if(Input.getKeyDown(Keyboard.KEY_UP)) {
			System.out.println("UP");
		}
		
		if(Input.getKeyUp(Keyboard.KEY_UP)) {
			System.out.println("Down");
		}
		if(Input.getKeyDown(Keyboard.KEY_ESCAPE)) {
			Main.stop();
		}

		if(Input.getMouseDown(1)) {
			System.out.println("Right Clicked at" + Input.getMousePosition());
		}
		if(Input.getMouseUp(1)) {
			System.out.println("Release RightClick");
		}
		
	}

	public void update() {

	}

	public void render() {

	}
}
