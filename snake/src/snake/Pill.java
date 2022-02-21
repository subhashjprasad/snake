package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pill extends Rectangle {
	
	public Pill(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y, 5, 5);
	}
	
	public void explode(Snake s) {
		int count = 0;
		while (count < 10) {
			int randr = (int)(Math.random() * 128) + 127;
			Color col = new Color(randr, 0, 0);
			s.particles.add(new Particle(new Vect(x, y), col));
			count++;
		}
	}
}
