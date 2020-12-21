package Snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable{


	private static final long serialVersionUID = -3700397241969520048L;

	public static final int WIDTH = 600, HEIGHT = 600;
	
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private Cube player;
	
	public Game() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		Random r = new Random();
		
		new Window(WIDTH,HEIGHT,"Snake game",this);
		
      
		handler.addObject(new Snake(5,5,ID.SnakeHead,Color.yellow,handler));
		handler.addObject(new Apple(1,10));
		handler.addObject(new Apple(25,4));
		handler.addObject(new Apple(18,10));
		handler.addObject(new Apple(12,6));
		handler.addObject(new Apple(20,26));
		handler.addObject(new Apple(3,15));
		handler.addObject(new Apple(28,24));
	}
	
	
	
	public synchronized void run() {
		this.requestFocus(); //So you don't have to click on the game window to move
		long lastTime = System.nanoTime(); 
	    double amountOfTicks = 20.0; //Running amount of ticks at 60 per second
	    double ns = 1000000000/amountOfTicks;
	    double delta = 0;
	    long timer = System.currentTimeMillis();
	    int frames = 0;
	    while (running) {
	    	long now = System.nanoTime();
	    	delta += (now-lastTime)/ns; //change in time in ticks (1/60 of a second in this case)
	    	lastTime = now;
	    	while (delta >= 1) { //While more than one ticks have past
	    		tick();
	    		delta--;
	    	
	    	}
	    if (running) { //If still running render
	    	
	    	render();
	    	frames++;
	    	
	    }
	    
	    
	    if (System.currentTimeMillis()-timer >= 1000) { //If a second or more has passed print fps
	    	timer += 1000;
	    	//System.out.println("FPS :" + frames);
	    	frames = 0;
	    	
	    }
	     }
	    stop();
	}

	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
			}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		drawGrid(g);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
		
		
	}
	
	
	private void drawGrid(Graphics g) {
		g.setColor(Color.white);
		int sizeBtwn = WIDTH/30;
		int x = 0;
		int y = 0;
		
		for (int i=0;i<30;i++) {
			x += sizeBtwn;
			y += sizeBtwn;
			
			g.drawLine(x, 0, x, WIDTH);
			g.drawLine(0, y, WIDTH, y);
		
		}
		g.setColor(Color.black);
		
	}
	
	private void tick() {
		handler.tick();
	}
	
	
	public synchronized void start() {
	       thread = new Thread(this);	//Creates new thread
		   thread.start();              //Because this class is runnable it will start the run method (Game loop)
		   running = true;              //Game loop can start
		}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}
		catch(Exception e) {
			e.printStackTrace();
		    
		}
		
	}
	
	
	
public static void main(String[] args) {
		new Game();

	}
}
