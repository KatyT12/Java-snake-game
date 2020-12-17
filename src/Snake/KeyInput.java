package Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	static int turnPos;
   // 1 = left  2 = right  3 = up  4 = down
	
	boolean[] keysHeld = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		for (int i=0;i<4;i++) {
			keysHeld[i] = false;
		}
		
		
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i=0;i<handler.object.size();i++) {
			Cube temp = handler.object.get(i);
			
			if (temp.id == ID.SnakeHead) {
				int[] point = null;
				if(key == KeyEvent.VK_LEFT) {
	        		
					if (!keysHeld[0]) {
					keysHeld[0] =  true;
					point = new int[]{temp.head[0],temp.head[1],1,temp.body.size()};
					
					point[3] = temp.body.size();
					
					if (temp.check(point)) {
					temp.addTurn(point);
					  }
					}
				  
				 }
	        	 if (key == KeyEvent.VK_RIGHT) {
	        		    
	        		 if (!keysHeld[1]) {
	        		 keysHeld[1] = true;
					 point = new int[]{temp.head[0],temp.head[1],2,0};
		        	 point[3] = temp.body.size();
		        	 if (temp.check(point)) {
		        	 temp.addTurn(point);  	 
		        	     
	        	       }
	        		 }
	                }
	        	 if (key == KeyEvent.VK_UP) {
	        		 
	        		if (!keysHeld[2]) {
	        		 keysHeld[2] = true;
					 point = new int[]{temp.head[0],temp.head[1],3,temp.body.size()};
		        	 
					
		        	 if (temp.check(point)) {
		        	 
					 temp.addTurn(point);  	
		        	 }
	        		
	        		}
	        	
		        	
	        	 }
	        	 if (key == KeyEvent.VK_DOWN) {
	        		   
	        		 if (!keysHeld[3]) {
	        		 keysHeld[3] = true;
					 point = new int[]{temp.head[0],temp.head[1],4,0};
		        	 point[3] = temp.body.size();
		        	 if (temp.check(point)) {
		        	   
		        		 temp.addTurn(point); 	 
		        	 }
	        		}
	        	    
	        	 }
			}
		}
    }
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i=0;i<handler.object.size();i++) {
			Cube temp = handler.object.get(i);
			
			if (temp.id == ID.SnakeHead) {
			
				if(key == KeyEvent.VK_LEFT) {
	        		keysHeld[0] = false;
					
				 }
	        	 if (key == KeyEvent.VK_RIGHT) {
	        		 keysHeld[1] = false;   
	        		
	                }
	        	 if (key == KeyEvent.VK_UP) {
	        		 
	        		
	        		keysHeld[2] = false;
	        	
		        	
	        	 }
	        	 if (key == KeyEvent.VK_DOWN) {
	        		   
	        		keysHeld[3] = false;
	        	    
	        	 }
			}
		}
	}
	
	
	
	
}




			
//error info
/*
 * When holding a button i get lots of errors especially when i press
 * others. This is probably because it's messing with the turns stack
 * changing some of them after the head so the individual squares fly
 * off. I need a way to make sure that if a button is being held down and
 * another is pressed that button is ignored until it is released and press
 * again. 
 * 
 * 
 * 
 */
		
		
	
	
	