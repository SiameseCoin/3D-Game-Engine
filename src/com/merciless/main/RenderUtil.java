package com.merciless.main;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class RenderUtil {
	public RenderUtil() {
		
	}
	
	public static void clearScreen() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); //TODDO: Stencil Buffer
	}
	
	public static void initGraphics() {
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		
		glFrontFace(GL_CW);
		glCullFace(GL_BACK);
		glEnable(GL_CULL_FACE);
		glEnable(GL_DEPTH_TEST);
		
		//TODO: Depth Clamp for later
		
		glEnable(GL_FRAMEBUFFER_SRGB);
	}
	
}
