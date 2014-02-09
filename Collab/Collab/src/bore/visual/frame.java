package bore.visual;

import org.lwjgl.*;
import org.lwjgl.input.*;
import org.lwjgl.opengl.*;

public class frame {
	
	private static final String TITLE = "BLANK";
	
	private static boolean running = true;
	
	public static void main(String[] args) 
	{
		frame Frame = new frame();
		
		Frame.run();
	}
	
	public static void init(int WIDTH, int HEIGHT) throws LWJGLException
	{	
		DisplayMode[] dm = Display.getAvailableDisplayModes();
		
		for(DisplayMode mode : dm)
		{
			if(mode.getWidth() == WIDTH && mode.getHeight() == HEIGHT && mode.getBitsPerPixel() == 32)
			{
				Display.setDisplayMode(mode);
			}
		}
		Display.setTitle(TITLE);
		Display.create();
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		
		GL11.glOrtho(0, Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight(), 0, -1, 1);
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.4f);
		
		GL11.glClearColor(0.1f, 0.5f, 1.0f, 1.0f);
		
	}
	
	public void run() 
	{
		try
		{
			init(800, 600);
		}
		catch (LWJGLException e)
		{
			e.printStackTrace();
		}
		while(running)
		{
			input();
			Display.update();
			render();
			
		}
		
		cleanup();
		
	}
	
	public static void input() 
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
		{
			running = false;
		}
	}
	
	public static void update()
	{
		Display.destroy();
	}
	
	public static void render() 
	{
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glLoadIdentity();
	}
	
	public static void cleanup() 
	{
		
	}

}
