package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.ImageIcon;
/*
 * 背景类
 * */
public class Background {
	public int bx;
	public int by;
	public Image imbk;
	public Panel nowp;
	
	public Background(Panel p) {
		this.bx = 0;
		this.by = 0;
		this.imbk = new ImageIcon("sourcefiles/backGround.gif").getImage();
		this.nowp = p;
	}
	
	public void drawBackground(Graphics g) {
		g.drawImage(imbk, bx, by, nowp);
		System.out.println("画背景"+bx);
	}

}
