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
		boolean horizontalLeftIn = this.origin.x >= rect.origin.x && this.origin.x<=rect.origin.x+rect.size.width;
		boolean horizontalRightIn = this.origin.x+this.size.width >= rect.origin.x && this.origin.x+this.size.width<=rect.origin.x+rect.size.width;
		boolean verticalTopIn = this.origin.y >= rect.origin.y && this.origin.y<=rect.origin.y+rect.size.height;
		boolean verticalBottomIn = this.origin.y+this.size.height >= rect.origin.y && this.origin.y+this.size.height<=rect.origin.y+rect.size.height;

		boolean horizontalIn = horizontalLeftIn || horizontalRightIn;
		boolean verticalIn = verticalTopIn || verticalBottomIn;
		return horizontalIn && verticalIn;
	}
	
}
