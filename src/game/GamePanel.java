package game;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
/*
 * 游戏面板类
 * */
import java.awt.Panel;
public class GamePanel extends Panel{
	public Background bg;
	public HeroPlane heroPlane;
	
	public GamePanel() {
		this.bg = new Background(this);

		Image img = new ImageIcon("sourcefiles/heroPlane1.png").getImage();
		this.heroPlane = new HeroPlane(img,this);
	}

	public void paint(Graphics g) {
		this.bg.drawBackground(g);
		this.heroPlane.drawPlane(g);
	}

}
