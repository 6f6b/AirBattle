package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.ImageIcon;
/*
 * 背景类
 * */
public class Background implements Runnable,IDraw{
	public int bx;
	public int by;
	public Image imbk;
	public Panel nowp;
	
	public Background(Panel p) {
		this.bx = 0;
		this.by = 0;
		this.imbk = new ImageIcon("sourcefiles/backGround.png").getImage();
		this.nowp = p;
		Thread t = new Thread(this);
		t.start();
	}
	
	//IDraw
	public void draw(Graphics g) {
		g.drawImage(imbk, bx, by-660, nowp);
		g.drawImage(imbk, bx, by, nowp);
	}

	//Runnable
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			this.by += 2;
			if(this.by >= 660) {
				this.by = 0;
			}
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				
			}
		}
	}
}
