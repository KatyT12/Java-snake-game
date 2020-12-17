package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Apple extends Cube{

	Random r = new Random();
	ID id = ID.Apple;
	
	
	
	public Apple(int x,int y) {
		
		super(x,y,ID.Apple,Color.green);
	
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		this.renderMethod(g);
		
	}
	

}
