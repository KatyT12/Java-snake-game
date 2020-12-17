package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;



public class Snake extends Cube{

	private int place = 0;
	Handler handler;
	public Stack<int[]> turnPos = new Stack<int[]>();
	//Each turnPos has 4 values.
	// The first two are the coords. The third is the direction and the fourth is the timer until it needs to be popped
	
	public Snake(int x, int y, ID id, Color color,Handler handler) {
		super(x,y,id, color);
		head[2] = 0;
		
		this.handler = handler;
		
	}

	@Override
	public void tick() {
		
		changeDirs();
		move();
		collision();
		
	}
	
	@Override
	public void render(Graphics g) {
		
		this.renderMethod(g);
	}

	private void collision() {
		for (int i=0;i<handler.object.size();i++) {
			Cube tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Apple){
				if (tempObject.getX() == head[0] && tempObject.getY() == head[1]) {
					handler.removeObject(tempObject);
					grow();
					
					for(int j=0;j<turnPos.size();j++) {
						turnPos.get(j)[3] +=1;
					}
					
				}
			}
			
		}
	}
	
	private void grow() {
		int last = body.size()-1;
		int[] lastItem = body.get(last);
		int[] newItem;
		
		if (lastItem[2] == 1) { //If going left
			newItem = new int[]{lastItem[0]+1,lastItem[1],lastItem[2]};
		}
		else if (lastItem[2] == 2) { //If going right
			newItem = new int[]{lastItem[0]-1,lastItem[1],lastItem[2]};
		}
		
		else if (lastItem[2] == 3) { //if going up
			newItem = new int[]{lastItem[0],lastItem[1]+1,lastItem[2]};
		}
		else if (lastItem[2] == 4) { //if going down
			newItem = new int[]{lastItem[0],lastItem[1]-1,lastItem[2]};
		}
		else {
			newItem = new int[] {};
		}
		
		addCube(newItem);
		
		
 	
		
	}
	
	private void changeDirs() {
	
		for (int i=0;i<body.size();i++) {
			int[] temp = body.get(i);
			
			for(int j=0;j<turnPos.size();j++) {
			    
			 
			    if (checkPos()) {
			    	j--;
			    	//System.out.println("Delete");
			    	continue;
			    }
			    int[] tempTurn = turnPos.get(j);
			    if (temp[0] == tempTurn[0] && temp[1] == tempTurn[1]) {
					tempTurn[3] --;
					temp[2] = tempTurn[2];
				
			}
		  }
		}
	}
	
	
	private boolean checkPos() {
		for (int i=0;i<turnPos.size();i++) {
			int[] temp = turnPos.get(i);
			if (temp[3] <= 0) {
				turnPos.remove(temp);
				return true;
			}
		}
		return false;
			
	}
	
	private void move() {
		
		for (int i=0;i<body.size();i++) {
			int[] temp = body.get(i);
			if (temp[2] == 1) {
				temp[0]-= 1;
			
			}
			else if(temp[2] == 2){
				temp[0]+= 1;
				
			}
			else if(temp[2] == 3) {
				temp[1]-= 1;
			}
			else if(temp[2] == 4) {
				temp[1]+= 1;
			}
		//place +=1;
		//if (place == body.size()) {
			//place = 0;
		}
	}
			
		
	
	
	
	public void addTurn(int[] turn) {
		turnPos.push(turn);
	}
	
	
	private void printall(Stack<int[]> stack) {
		for (int i=0;i<stack.size();i++) {
			for (int j=0;j<stack.get(i).length;j++) {
			  System.out.println(stack.get(i)[j]);
			}
		System.out.println("--------------");
		}
		System.out.println("ALL");
	}
	
	private void addCube(int[] cube) {
		body.add(cube);
	}
	
	
public boolean check(int[] turn) {
		
		if(turnPos != null) {
		for (int i=0;i<turnPos.size();i++) {
			int[] temp = turnPos.get(i);
			System.out.println(""+temp[0] +" " +temp[1]+" "+turn[0]+" "+" "+turn[1]+"");
			if (temp[0] == turn[0] && temp[1] == turn[1]) {
				System.out.println("False");
				return false;
			}
		}
	}
	
		return true;
	}
}
