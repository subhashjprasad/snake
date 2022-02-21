package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class BodyPart extends Rectangle {
	
	String direction = "left";
	String curve = "none";
	
	public BodyPart(int x, int y, String dir) {
		// TODO Auto-generated constructor stub
		super(x, y, 20, 20);
		direction = dir;
	}

	public void drawHead(Graphics2D win, Images images, Snake s) {
		if (direction == "right") win.drawImage(images.snakeheadright, x, y, s);
		if (direction == "left") win.drawImage(images.snakeheadleft, x, y, s);
		if (direction == "up") win.drawImage(images.snakeheadup, x, y, s);
		if (direction == "down") win.drawImage(images.snakeheaddown, x, y, s);
	}
	
	public void drawTail(Graphics2D win, Images images, Snake s) {
			if (direction == "right") win.drawImage(images.snaketailleft, x, y, s);
			if (direction == "left") win.drawImage(images.snaketailright, x, y, s);
			if (direction == "up") win.drawImage(images.snaketaildown, x, y, s);
			if (direction == "down") win.drawImage(images.snaketailup, x, y, s);
	}
	
	public void drawBody(Graphics2D win, Images images, Snake s) {
		if (curve == "none") {
			if (direction == "right" || direction == "left") win.drawImage(images.snakebodyhor, x, y, s);
			if (direction == "up" || direction == "down") win.drawImage(images.snakebodyvert, x, y, s);
		} else if (curve == "bl") {
			win.drawImage(images.snakecurvebl, x, y, s);
		} else if (curve == "ul") {
			win.drawImage(images.snakecurveul, x, y, s);
		} else if (curve == "ur") {
			win.drawImage(images.snakecurveur, x, y, s);
		} else if (curve == "br") {
			win.drawImage(images.snakecurvebr, x, y, s);
		}
	}
	
	public void explode(Snake s) {
		int count = 0;
		while (count < 10) {
			int randg = (int)(Math.random() * 135) + 120;
			int randb = (int)(Math.random() * 59) + 105;
			Color col = new Color(0, randg, randb);
			s.particles.add(new Particle(new Vect(x, y), col));
			count++;
		}
	}

}
