package game;

public class Rect {
	public Point origin;	
	public Size  size;
	
	public Rect(Point origin, Size size) {
		super();
		this.origin = origin;
		this.size = size;
	}

	public Rect(int x,int y,int width,int height) {
		super();
		this.origin = new Point(x, y);
		this.size = new Size(width, height);
	}

}
