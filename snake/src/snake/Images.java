package snake;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	BufferedImage pill; {
		try {
			File file = new File("src/images/pill.png");
			FileInputStream fis = new FileInputStream(file);
			pill = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snakebodyhor; {
		try {
			File file = new File("src/images/snakebodyhor.png");
			FileInputStream fis = new FileInputStream(file);
			snakebodyhor = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snakebodyvert; {
		try {
			File file = new File("src/images/snakebodyvert.png");
			FileInputStream fis = new FileInputStream(file);
			snakebodyvert = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snakeheadup; {
		try {
			File file = new File("src/images/snakeheadup.png");
			FileInputStream fis = new FileInputStream(file);
			snakeheadup = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snakeheadright; {
		try {
			File file = new File("src/images/snakeheadright.png");
			FileInputStream fis = new FileInputStream(file);
			snakeheadright = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snakeheaddown; {
		try {
			File file = new File("src/images/snakeheaddown.png");
			FileInputStream fis = new FileInputStream(file);
			snakeheaddown = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snakeheadleft; {
		try {
			File file = new File("src/images/snakeheadleft.png");
			FileInputStream fis = new FileInputStream(file);
			snakeheadleft = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snaketailleft; {
		try {
			File file = new File("src/images/snaketailleft.png");
			FileInputStream fis = new FileInputStream(file);
			snaketailleft = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snaketailright; {
		try {
			File file = new File("src/images/snaketailright.png");
			FileInputStream fis = new FileInputStream(file);
			snaketailright = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snaketailup; {
		try {
			File file = new File("src/images/snaketailup.png");
			FileInputStream fis = new FileInputStream(file);
			snaketailup = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snaketaildown; {
		try {
			File file = new File("src/images/snaketaildown.png");
			FileInputStream fis = new FileInputStream(file);
			snaketaildown = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snakecurvebl; {
		try {
			File file = new File("src/images/snakecurvebl.png");
			FileInputStream fis = new FileInputStream(file);
			snakecurvebl = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snakecurveul; {
		try {
			File file = new File("src/images/snakecurveul.png");
			FileInputStream fis = new FileInputStream(file);
			snakecurveul = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snakecurveur; {
		try {
			File file = new File("src/images/snakecurveur.png");
			FileInputStream fis = new FileInputStream(file);
			snakecurveur = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage snakecurvebr; {
		try {
			File file = new File("src/images/snakecurvebr.png");
			FileInputStream fis = new FileInputStream(file);
			snakecurvebr = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage bg; {
		try {
			File file = new File("src/images/bg.jpg");
			FileInputStream fis = new FileInputStream(file);
			bg = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
}
