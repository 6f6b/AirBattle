package game;
import java.awt.Image;
import java.awt.Point;

import javax.management.Notification;

import UIKit.Rect;

abstract public class Weapon extends Equipment{
	
	public Weapon(GamePanel panel,  String imgName,int rate,int damage) {
		super(panel, null, imgName);
		this.rate = rate;
		this.damage = damage;
	}
	
	public void launch(Point initialLocation,FlyDirection direction) {
		this.location = initialLocation;
		this.direction = direction;
		
		Thread t = new Thread(this);
		t.start();
	}
	
    public void handleNotification(Notification notification, Object handback) {
    	Equipment e = (Equipment) notification.getSource();
    	if(e != this) {
        	Rect rect = e.getRect();
    		//被武器攻击
        	if(e instanceof Weapon) {
        		if(rect.inRect(this.getRect())) {
        		}
        	}
    	}
    }
}
