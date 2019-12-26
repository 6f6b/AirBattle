package game;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
/*
 * 游戏面板类
 * */
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
public class GamePanel extends Panel implements Runnable,MouseMotionListener{
	public Background bg;
	private ArrayList<Equipment> equipments;
	public HeroPlane heroPlane;
	
	public GamePanel() {
		this.equipments = new ArrayList<Equipment>();
		
		this.bg = new Background(this);
		this.heroPlane = new HeroPlane(this);
		this.heroPlane.takeOff(new Point(200, 600),FlyDirection.StandsStill);
		
		
		
		this.addMouseMotionListener(this);
		Thread t = new Thread(this);
		t.start();
	}

	public void addEquipment(Equipment equipment) {
		this.equipments.add(equipment);
	}
	
	public void removeEquipment(Equipment equipment) {
		this.equipments.remove(equipment);
	}
	
	public void paint(Graphics g) {
		this.bg.draw(g);
		for(int i=0;i<this.equipments.size();i++) {
			Equipment equip = this.equipments.get(i);
			equip.draw(g);
		}
	}
	
	private void putEnemyPlane() {
		EnemyPlane enemyPlane = new EnemyPlane(this);
		Random r = new Random();
		int num = r.nextInt();
		int x = num % 200;
		int y = num % 100;
		enemyPlane.takeOff(new Point(x, y), FlyDirection.VerticalDown);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//投放敌机
			Random r = new Random();
			int num = r.nextInt();
			if(num%10 == 0) {
				this.putEnemyPlane();
			}
			
			try {
				Thread.sleep(100);
				this.repaint();
			}catch(InterruptedException e){
				
			}
		}
	}
	
	//MouseMotionListener
    public void mouseDragged(MouseEvent e) {
    	this.heroPlane.moveTo(new Point(e.getX(), e.getY()));
    }

    public void mouseMoved(MouseEvent e) {
    	
    }
}
