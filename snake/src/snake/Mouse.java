package snake;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import utilities.GDV5;

public class Mouse extends MouseAdapter{
	
	String state = "main menu";
	String difficulty = "none";
	boolean levelStart = false;
	
	public void mouseClicked(MouseEvent e) {
		switch (state) {
		case "main menu":
			if (((e.getX() > GDV5.getMaxWindowX() / 2 - 150) && (e.getX() < GDV5.getMaxWindowX() / 2 + 150)) && ((e.getY() > GDV5.getMaxWindowY() / 2 - 40) && (e.getY() < GDV5.getMaxWindowY() / 2 + 40))) {
				state = "difficulty";
			}
			if (((e.getX() > GDV5.getMaxWindowX() / 2 - 150) && (e.getX() < GDV5.getMaxWindowX() / 2 + 150)) && ((e.getY() > GDV5.getMaxWindowY() / 2 + 180) && (e.getY() < GDV5.getMaxWindowY() / 2 + 260))) {
				state = "how to play";
			}
			break;
		case "difficulty":
			if (((e.getX() > GDV5.getMaxWindowX() / 2 - 150) && (e.getX() < GDV5.getMaxWindowX() / 2 + 150)) && ((e.getY() > GDV5.getMaxWindowY() / 2 - 170) && (e.getY() < GDV5.getMaxWindowY() / 2 - 90))) {
				state = "game";
				levelStart = true;
				difficulty = "easy";
			}
			if (((e.getX() > GDV5.getMaxWindowX() / 2 - 150) && (e.getX() < GDV5.getMaxWindowX() / 2 + 150)) && ((e.getY() > GDV5.getMaxWindowY() / 2 - 30) && (e.getY() < GDV5.getMaxWindowY() / 2 + 50))) {
				state = "game";
				levelStart = true;
				difficulty = "medium";
			}
			if (((e.getX() > GDV5.getMaxWindowX() / 2 - 150) && (e.getX() < GDV5.getMaxWindowX() / 2 + 150)) && ((e.getY() > GDV5.getMaxWindowY() / 2 + 110) && (e.getY() < GDV5.getMaxWindowY() / 2 + 190))) {
				state = "game";
				levelStart = true;
				difficulty = "hard";
			}
			break;
		case "lose":
			if (((e.getX() > GDV5.getMaxWindowX() / 2 - 100) && (e.getX() < GDV5.getMaxWindowX() / 2 + 100)) && ((e.getY() > GDV5.getMaxWindowY() / 2 + 30) && (e.getY() < GDV5.getMaxWindowY() / 2 + 90))) {
				state = "game";
				levelStart = true;
			}
			break;
		}
	}

}
