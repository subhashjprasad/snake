package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import utilities.GDV5;

public class Slither {
	
	ArrayList<BodyPart> body = new ArrayList<BodyPart>();
	int move = 0;
	int add = 0;
	String direction = "left";
	boolean changed = true;
	int tick = 30;
	int spawnx = 0;
	int spawny = 0;
	int resetTimer = 0;
	
	public Slither(int x, int y) {
		spawnx = x;
		spawny = y;
	}
	
	public void update(Snake s) {
		move++;
		if (move == tick) {
			move = 0;

			
			int temp_x = body.get(0).x;
			int temp_y = body.get(0).y;
			String temp_dir = body.get(0).direction;
			
			if (direction.equals("left")) {
				if ((body.get(1).direction == "up" || temp_dir == "up") && body.get(1).curve != "ur") body.get(0).curve = "ur";
				else if ((body.get(1).direction == "down" || temp_dir == "down") && body.get(1).curve != "br") body.get(0).curve = "br";
				else body.get(0).curve = "none";
				body.get(0).x-= 20;
				body.get(0).direction = "left";
			}
			else if (direction.equals("right")) {
				if ((body.get(1).direction == "up" || temp_dir == "up") && body.get(1).curve != "ul") body.get(0).curve = "ul";
				else if ((body.get(1).direction == "down" || temp_dir == "down") && body.get(1).curve != "bl") body.get(0).curve = "bl";
				else body.get(0).curve = "none";
				body.get(0).x+= 20;
				body.get(0).direction = "right";
			}
			else if (direction.equals("up")) {
				if ((body.get(1).direction == "right" || temp_dir == "right") && body.get(1).curve != "br") body.get(0).curve = "br";
				else if ((body.get(1).direction == "left" || temp_dir == "left") && body.get(1).curve != "bl") body.get(0).curve = "bl";
				else body.get(0).curve = "none";
				body.get(0).y-= 20;
				body.get(0).direction = "up";
			}
			else if (direction.equals("down")) {
				if ((body.get(1).direction == "right" || temp_dir == "right") && body.get(1).curve != "ur") body.get(0).curve = "ur";
				else if ((body.get(1).direction == "left" || temp_dir == "left") && body.get(1).curve != "ul") body.get(0).curve = "ul";
				else body.get(0).curve = "none";
				body.get(0).y+= 20;
				body.get(0).direction = "down";
			}
			
			String temp_curve = body.get(0).curve;
			
			for (int i = 1; i < body.size(); i++) {
				int current_x = body.get(i).x;
				int current_y = body.get(i).y;
				String current_dir = body.get(i).direction;
				String current_curve = body.get(i).curve;
				body.get(i).x = temp_x;
				body.get(i).y = temp_y;
				body.get(i).curve = temp_curve;
				body.get(i).direction = temp_dir;
				temp_x = current_x;
				temp_y = current_y;
				temp_dir = current_dir;
				temp_curve = current_curve;
				
				if (body.get(0).intersects(body.get(i))) {
					lose(s);
				} else if (body.get(0).x < 0 || body.get(0).x > 780 || body.get(0).y < 0 || body.get(0).y > 780) {
					lose(s);
				}
				
			}
			if (body.size() > 0) body.get(body.size() - 1).direction = body.get(body.size() - 2).direction;
			
//			add++;
//			if (add == 5) {
//				add = 0;
//				body.add(new BodyPart(temp_x, temp_y, temp_dir));
//			}
			
			if (body.size() > 0) {
				for (int i = 0; i < s.pills.size(); i++) {
					if (body.get(0).intersects(s.pills.get(i))) {
						body.add(new BodyPart(temp_x, temp_y, temp_dir));
						s.pills.get(i).explode(s);
						s.pills.remove(i);
						s.addPill();
						s.s1.play(1);
					}
				}
			}
			
		}
		
		if (resetTimer > 0) {
			add = 0;
			move = 0;
			resetTimer--;
			if (resetTimer == 0) s.mouse.state = "lose";
		}
		
		
	}
	
	public void lose(Snake s) {
		for (int j = body.size() - 1; j >= 0; j--) {
			body.get(j).explode(s);
			body.remove(j);
		}
		add = 0;
		move = 0;
		
		resetTimer = 200;
	}
	
	public void reset() {
		body = new ArrayList<BodyPart>();
		tick = 30;
		int num = 0;
		while (num < 3) {
			body.add(new BodyPart(spawnx + (num * 20), spawny, "left"));
			num++;
		}
		add = 0;
		move = 0;
		direction = "left";
	}
	
	public void draw(Graphics2D win, Images images, Snake s) {
		if (body.size() > 0) {
			body.get(0).drawHead(win, images, s);
			body.get(body.size() - 1).drawTail(win, images, s);
		}
		for (int i = 1; i < body.size() - 1; i++) {
			(body.get(i)).drawBody(win, images, s);
		}
	}
	
	public void keyPressed() { //Checks for keys being pressed
		if (body.size() > 0) {
			if (GDV5.KeysPressed[KeyEvent.VK_LEFT]) {
				if (!(body.get(0).x == body.get(1).x + 20 && body.get(0).y == body.get(1).y)) {
					direction = "left";
				}
			}
			if (GDV5.KeysPressed[KeyEvent.VK_RIGHT]) {
				if (!(body.get(0).x == body.get(1).x - 20 && body.get(0).y == body.get(1).y)) {
					direction = "right";
				}
			}
			if (GDV5.KeysPressed[KeyEvent.VK_UP]) {
				if (!(body.get(0).x == body.get(1).x && body.get(0).y == body.get(1).y + 20)) {
					direction = "up";
				}
			}
			if (GDV5.KeysPressed[KeyEvent.VK_DOWN]) {
				if (!(body.get(0).x == body.get(1).x && body.get(0).y == body.get(1).y - 20)) {
					direction = "down";
				}
			}
		}
		
	}
}