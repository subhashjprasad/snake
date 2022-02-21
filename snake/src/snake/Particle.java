package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Particle {
	  Vect location;
	  Vect velocity;
	  Vect acceleration;
	  double lifespan;
	  Color col;
	  int xtarget;
	  int ytarget;
	 
	  Particle(Vect l, Color c) {
	    velocity = new Vect(Math.random() * 2 - 1, Math.random() * 2 - 1);
	    acceleration = new Vect(velocity.x * -0.005, velocity.y * -0.005);
	    location = l.get();
	    lifespan = 400.0;
	    col = c;
	  }
	 
	  void run(Graphics2D win, Slither s) {
	    update(s);
	    display(win);
	  }
	 
	  void update(Slither s) {
	    velocity.add(acceleration);
	    location.add(velocity);
	    lifespan -= 2.0;
	  }
	 
	  void display(Graphics2D win) {
		col = new Color(col.getRed(), col.getGreen(), col.getBlue(), max(min((int)lifespan, 255), 0));
	    win.setColor(col);
	    win.fill(new Rectangle((int)location.x, (int)location.y, 4, 4));
	  }
	 
	  private int min(int x, int y) {
		if (x < y) return x;
		else return y;
	}
	  
	  private int max(int x, int y) {
			if (x > y) return x;
			else return y;
	  }

	boolean isDead() {
	    if (lifespan < 0.0) return true;
	    if (location.x > 800 || location.x < 0 || location.y > 800 || location.y < 0) return true;
	    return false;
	  }
	}