package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;

public class HeroPlane extends Plane {

	public HeroPlane(Image img, Panel p) {
		super(img, p);
		this.px = 100;
		this.py = 200;
		
	}


}
