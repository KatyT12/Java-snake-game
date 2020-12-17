package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

public abstract class Cube {

	Stack<int[]> turnPos;
	protected ID id;
	protected int sizeBtwn = Game.WIDTH/30;
	protected Color color;
	protected int x;
	protected int y;
	
	
	int[] head = new int[3];
	
	
	Stack<int[]> body = new Stack<int[]>();
	
	
	public Cube(int x, int y,ID id,Color color) {
	 
	  this.head[0] = x;
	  this.head[1] = y;
	
	  this.id = id;
	  this.color = color;
	
	  this.body.push(this.head);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	

public void renderMethod(Graphics g) {
	g.setColor(color);
	
	
	for (int i=0;i<body.size();i++) {
		int[] square = convert(body.get(i));
		g.fillRect(square[0]+1, square[1]+1, sizeBtwn-2, sizeBtwn-2);
	
	}
}
	

public int[] convert(int[] square) {
	int col =square[0]*sizeBtwn;
	int row =square[1]*sizeBtwn;
	int[] newSquare = {col,row};
	return newSquare;
	
	}

public void setX(int x) {
	head[0] = x;
}
public void setY(int y) {
	head[1] = y;
}

public float getX() {
	  return head[0];
}

public float getY() {
	  return head[1];
}

public void setID(ID id) {
	  this.id = id;
	  
}

public ID getID() {
	  return this.id;
}



public void addTurn(int[] point) {
	// TODO Auto-generated method stub
	
}
public boolean check(int[] point) {
	return true;
}


}
