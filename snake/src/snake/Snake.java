package snake;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import utilities.GDV5;
import utilities.SoundDriverHo;

public class Snake extends GDV5{
	
	Slither slither = new Slither(GDV5.getMaxWindowX() / 2, GDV5.getMaxWindowY() / 2);
	Color lw = new Color(255, 255, 255, 100);
	ArrayList<Pill> pills;
	ArrayList<Particle> particles;
	Images images = new Images();
	String state = "main menu";
	String difficulty = "none";
	int tick = 0;
	static Font font;
	AlphaComposite pale = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f);
	AlphaComposite full = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
	Stroke stroke = new BasicStroke(4F);
	int score = 0;
	Mouse mouse = new Mouse();
	SoundDriverHo s1;
	String[] filenames = new String[2];
	boolean levelStart = false;
	int timer = 0;
	
	public Snake() {
		setFrames(120);
		particles = new ArrayList<Particle>();
		pills = new ArrayList<Pill>();
		addMouseListener(mouse);
		filenames[0] = "music.wav";
		filenames[1] = "chomp.wav";
		s1 = new SoundDriverHo(filenames, this);
		s1.loop(0);
	}
	
	public static void main(String[] args) { //Main method
		Snake snake = new Snake();
		snake.start();
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Dancing Minotaur.ttf")).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Dancing Minotaur.ttf")));
			
		} 
		catch(IOException | FontFormatException e) {}
	}

	@Override
	public void update() {
		state = mouse.state;
		if (mouse.levelStart) {
			mouse.levelStart = false;
			slither.reset();
			pills = new ArrayList<Pill>();
			addPill();
			addPill();
			addPill();
			addPill();
			addPill();
			timer = 500;
			if (mouse.difficulty == "easy") slither.tick = 70;
			else if (mouse.difficulty == "medium") slither.tick = 40;
			else if (mouse.difficulty == "hard") slither.tick = 10;
		}
		switch (state) {
		case "main menu":
			break;
		case "game":
			if (slither.body.size() > 0) score = slither.body.size();
			slither.update(this);
			slither.keyPressed();
			break;
		case "lose":
			break;
		}
		keyCheck();
	}

	@Override
	public void draw(Graphics2D win) {
		switch (state) {
		case "main menu":
			win.setColor(Color.green);
			win.setFont(font.deriveFont(130F));
			win.drawString("SNAKE", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(130F)).stringWidth("SNAKE")) / 2, GDV5.getMaxWindowY() / 4 - win.getFontMetrics(font.deriveFont(130F)).getHeight() / 2 + 60);
			win.setFont(font.deriveFont(40F));
			win.drawString("PLAY", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(40F)).stringWidth("PLAY")) / 2, GDV5.getMaxWindowY() / 2 + win.getFontMetrics(font.deriveFont(40F)).getHeight() / 2 - 10);
			win.setStroke(stroke);
			win.drawRoundRect(GDV5.getMaxWindowX() / 2 - 150, GDV5.getMaxWindowY() / 2 - 40, 300, 80, 20, 20);
			win.setFont(font.deriveFont(40F));
			win.drawString("HOW TO PLAY", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(40F)).stringWidth("HOW TO PLAY")) / 2, GDV5.getMaxWindowY() / 2 + win.getFontMetrics(font.deriveFont(40F)).getHeight() / 2 + 210);
			win.setStroke(stroke);
			win.setFont(font.deriveFont(20F));
			win.drawRoundRect(GDV5.getMaxWindowX() / 2 - 150, GDV5.getMaxWindowY() / 2 + 180, 300, 80, 20, 20);
			win.drawString("SUBHASH PRASAD", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(20F)).stringWidth("SUBHASH PRASAD")) / 2, GDV5.getMaxWindowY() - win.getFontMetrics(font.deriveFont(20F)).getHeight());
			break;
		case "difficulty": 
			win.setColor(Color.white);
			win.setFont(font.deriveFont(40F));
			win.drawString("EASY", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(40F)).stringWidth("EASY")) / 2, GDV5.getMaxWindowY() / 2 + win.getFontMetrics(font.deriveFont(40F)).getHeight() / 2 - 140);
			win.setStroke(stroke);
			win.drawRoundRect(GDV5.getMaxWindowX() / 2 - 150, GDV5.getMaxWindowY() / 2 - 170, 300, 80, 20, 20);
			win.setFont(font.deriveFont(40F));
			win.drawString("MEDIUM", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(40F)).stringWidth("MEDIUM")) / 2, GDV5.getMaxWindowY() / 2 + win.getFontMetrics(font.deriveFont(40F)).getHeight() / 2);
			win.setStroke(stroke);
			win.drawRoundRect(GDV5.getMaxWindowX() / 2 - 150, GDV5.getMaxWindowY() / 2 - 30, 300, 80, 20, 20);
			win.setFont(font.deriveFont(40F));
			win.drawString("HARD", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(40F)).stringWidth("HARD")) / 2, GDV5.getMaxWindowY() / 2 + win.getFontMetrics(font.deriveFont(40F)).getHeight() / 2 + 140);
			win.setStroke(stroke);
			win.drawRoundRect(GDV5.getMaxWindowX() / 2 - 150, GDV5.getMaxWindowY() / 2 + 110, 300, 80, 20, 20);
			break;
		case "game":
			win.setFont(font.deriveFont(100F));
			Color white = new Color(255, 255, 255, 150);
			win.setColor(white);
			win.drawString("" + score, GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(100F)).stringWidth("" + score)) / 2 + 5, GDV5.getMaxWindowY() / 2 + win.getFontMetrics(font.deriveFont(100F)).getHeight() / 2);
			if (pills.size() > 0) {
				for (Pill x : pills) {
					win.drawImage(images.pill, x.x, x.y, this);
				}
			}
			for (int i = particles.size() - 1; i >= 0; i--) {
				Particle p = particles.get(i);
				p.run(win, slither);
				if (p.isDead()) particles.remove(i);
			}
			slither.draw(win, images, this);
			break;
		case "how to play":
			win.setColor(Color.white);
			win.setFont(font.deriveFont(30F));
			win.drawString("use the arrow keys to move the snake.", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(30F)).stringWidth("use the arrow keys to move the snake.")) / 2, GDV5.getMaxWindowY() / 2 + win.getFontMetrics(font.deriveFont(30F)).getHeight() / 2 - 220);
			win.drawString("eat pills to grow longer.", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(30F)).stringWidth("eat pills to grow longer.")) / 2, GDV5.getMaxWindowY() / 2 + win.getFontMetrics(font.deriveFont(30F)).getHeight() / 2 - 180);
			win.drawString("make sure not to ram into yourself or the walls!", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(30F)).stringWidth("make sure not to ram into yourself or the walls!")) / 2, GDV5.getMaxWindowY() / 2 + win.getFontMetrics(font.deriveFont(30F)).getHeight() / 2 - 140);
			
			win.setColor(Color.white);
			win.drawString("press escape at any time to go back to main menu.", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font.deriveFont(30F)).stringWidth("press escape at any time to go back to main menu.")) / 2, GDV5.getMaxWindowY() / 2 + win.getFontMetrics(font.deriveFont(30F)).getHeight() / 2 + 100);
			break;
		case "lose":
			win.setColor(Color.green);
			win.setFont(font);
			win.drawString("YOU LOSE!", GDV5.getMaxWindowX() / 2 - win.getFontMetrics(font).stringWidth("YOU LOSE!") / 2, GDV5.getMaxWindowY() / 2 - 10 - 50);
			win.setFont(font);
			win.drawString("RESTART", GDV5.getMaxWindowX() / 2 - (win.getFontMetrics(font).stringWidth("RESTART")) / 2, GDV5.getMaxWindowY() / 2 + 55 + win.getFontMetrics(font).getHeight() / 2);
			win.setStroke(stroke);
			win.drawRoundRect(GDV5.getMaxWindowX() / 2 - 100, GDV5.getMaxWindowY() / 2 + 30, 200, 60, 20, 20);
			break;
		}
	}
	
	public void addPill() {
		boolean okay = false;
		int xval = 0;
		int yval = 0;
		while (!okay) {
			xval = (int)(Math.random() * 40) * 20;
			yval = (int)(Math.random() * 40) * 20;
			for (BodyPart bp : slither.body) {
				if (xval == bp.x || yval == bp.y) okay = false;
				else okay = true;
			}
		}
		pills.add(new Pill(xval, yval));
	}
	
	public void keyCheck() {
		if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE]) {
			mouse.state = "main menu";
		}
	}
	
}
