package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

/*
 * 飞机
 * */
public class Plane {
	public Image img;
	public int px;
	public int py;
	private	Panel p;
	
	public Plane(Image img,Panel p) {
		this.img = img;
		this.p = p;
	}
	
	public void drawPlane(Graphics g) {
		g.drawImage(img, px, py, p);
		System.out.println("画飞机"+px);
	}

}
