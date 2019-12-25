package game;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
/*
 * 游戏面板类
 * */
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class GamePanel extends Panel implements Runnable,MouseMotionListener{
	public Background bg;
	public HeroPlane heroPlane;
	
	public GamePanel() {
		this.bg = new Background(this);
		
		this.heroPlane = new HeroPlane("heroPlane1.png", this, 100, 600);
		this.heroPlane.direction = FlyDirection.VerticalUp;
		
		this.addMouseMotionListener(this);
		Thread t = new Thread(this);
		t.start();
	}

	public void paint(Graphics g) {
		this.bg.draw(g);
		this.heroPlane.draw(g);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(10);
				this.repaint();
			}catch(InterruptedException e){
				
			}
		}
	}
	
	//MouseMotionListener
    public void mouseDragged(MouseEvent e) {
    	this.heroPlane.moveTo(e.getX(), e.getY());
    }

    public void mouseMoved(MouseEvent e) {
    	
    }
}
