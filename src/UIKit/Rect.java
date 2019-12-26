package UIKit;

import java.awt.Point;

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
	
	public boolean inRect(Rect rect) {
		boolean horizontalIn = (this.origin.x+this.size.width > rect.origin.x) || (this.origin.x < rect.origin.x+rect.size.width);
		boolean verticalIn = (this.origin.y+this.size.height > rect.origin.y) || (this.origin.y < rect.origin.y+rect.size.height);
		return horizontalIn && verticalIn;
	}
	
}
