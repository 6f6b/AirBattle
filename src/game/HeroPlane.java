package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class HeroPlane extends Plane {
	
	public HeroPlane(GamePanel panel) {
		super(panel, 0, "heroPlane1.png");
		this.hp = 1000;
	}
	
	public void loadWeapons() {
		//装配子弹
		ArrayList<HeroBullet> bullets = new ArrayList<HeroBullet>();
		for(int i=0;i<10000;i++) {
			bullets.add(new HeroBullet(panel));
		}
		//装配导弹
		ArrayList<Missile> missiles = new ArrayList<Missile>();
		for(int i=0;i<10;i++) {
			missiles.add(new Missile(panel));
		}
		this.magazine = new Magazine(bullets, missiles);
	}
	
	@Override
	public void heartBeat() {
		// TODO Auto-generated method stub
		super.heartBeat();
		Random r = new Random();
		int num = r.nextInt();
		if(num%5 == 0) {
			this.fireBullet();
		}
		if(num%10 == 0) {
			this.fireMissile();
		}
	}
}
