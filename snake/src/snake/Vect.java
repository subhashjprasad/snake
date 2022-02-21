package snake;

public class Vect {
	
	double x, y;
	
	public Vect(double xval, double yval) {
		x = xval;
		y = yval;
	}
	
	void add(Vect v) {
		y += v.y;
		x += v.x; 
	}
	
	Vect get() {
		return this;
	}

}
