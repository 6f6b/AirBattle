package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;

import javax.management.Notification;
import javax.swing.ImageIcon;

import UIKit.Rect;

/*
 * 飞机
 * */
abstract public class Plane extends Equipment implements IFighterPlane{
	//弹仓
	protected Magazine magazine;

	public Plane(GamePanel panel, int rate, String imgName) {
		super(panel, null, imgName);
		this.rate = rate;
		this.loadWeapons();
	}

	public void moveTo(Point location) {
		this.location = location;
		System.out.println("拖动放飞机");
	}
	
	//起飞
	public void takeOff(Point initialLocation,FlyDirection direction) {
		this.location = initialLocation;
		this.direction = direction;
		
		Thread t = new Thread(this);
		t.start();
	}
	
	public void fireBullet() {
		Weapon bullet = this.magazine.takeBullet();
		if(bullet == null) {
			System.out.println(this.getClass().toString()+"子弹告罄");
			return;
		}
		FlyDirection direction = this.direction == FlyDirection.VerticalDown ? FlyDirection.VerticalDown : FlyDirection.VerticalUp;
		bullet.launch(new Point(location.x, location.y), direction);
	}
	
	public void fireMissile() {
		Weapon missile = this.magazine.takeMissile();
		if(missile == null) {
			System.out.println(this.getClass().toString()+"导弹告罄");
			return;
		}
		FlyDirection direction = this.direction == FlyDirection.VerticalDown ? FlyDirection.VerticalDown : FlyDirection.VerticalUp;
		missile.launch(new Point(location.x, location.y), direction);
	}
	
    public void handleNotification(Notification notification, Object handback) {
    	Equipment e = (Equipment) notification.getSource();
    	if(e != this) {
        	Rect rect = e.getRect();
    		//被武器攻击
        	if(e instanceof Weapon) {
				Weapon weapon = (Weapon) e;
				boolean standStill2verticalDown = this.direction == FlyDirection.StandsStill && weapon.direction == FlyDirection.VerticalDown;
				boolean verticalDown2VerticalUp = this.direction == FlyDirection.VerticalDown && weapon.direction == FlyDirection.VerticalUp;

				if(standStill2verticalDown || verticalDown2VerticalUp) {
					Rect thisRect = this.getRect();
					boolean in = rect.inRect(thisRect);
					if(in){
						System.out.println(this.getClass().toString()+"被武器撞上");
						System.out.println(this.getClass().toString()+"原始生命值:"+this.hp+"生命值减少:"+weapon.damage+"还剩:"+(this.hp-weapon.damage));
						this.hp -= weapon.damage;
						if(this.hp <= 0) {
							this.panel.removeEquipment(this);
						}
					}
        		}
        	}
    	}
    }
}
