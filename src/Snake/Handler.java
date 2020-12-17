package Snake;

import java.awt.Graphics;
import java.util.LinkedList;






public class Handler {
  LinkedList<Cube> object = new LinkedList<Cube>();
  
  
  public void tick() {
		for (int i=0;i<object.size();i++) { //goes through every game object
			
			Cube tempObject = object.get(i);
		    tempObject.tick(); //That game object will go through its own tick method
		}
	}

  public void render(Graphics g) {
		for (int i=0;i<object.size();i++) { 
			Cube tempObject = object.get(i);
		    tempObject.render(g); 
		}
	};//Renders all game objects
	
	
	public void addObject(Cube object) {
		this.object.add(object); 
	}//Adds objects to the linked list

	public void removeObject(Cube object) {
		this.object.remove(object);
	}//Removes objects from the linked list


}