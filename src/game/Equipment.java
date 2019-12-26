package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;

import javax.management.Notification;
import javax.management.NotificationListener;
import javax.swing.ImageIcon;
import UIKit.Rect;
import UIKit.Size;

public abstract class Equipment implements IDraw,Runnable,NotificationListener,ISpaceInfo {
	//所处的平面
	protected GamePanel panel;
	//位置
	protected Point location;
	//飞行方向
	protected FlyDirection direction;
	//速度
	protected int rate;
	//装饰
	protected Image img;
	protected long heartCount;
	//装饰图片名字
	private String imgName;
	//生命值 
	protected int hp;
	//伤害值
	protected int damage; 
	
	public Equipment(GamePanel panel, Point location,String imgName) {
		super();
		this.panel = panel;
		this.panel.addEquipment(this);
		this.location = location;
		this.imgName = imgName;
		Image img = new ImageIcon("sourcefiles/"+imgName).getImage();
		this.img = img;
		this.heartCount = 0;
		
		NotificationCenter.defaultCenter().addNotificationListener(this, null, null);;
	}

	protected void finalize() {
		System.out.println(this+"销毁");
	}
	
	public void draw(Graphics g) {
		if(img == null || location == null || panel == null) {return;}
		g.drawImage(img, this.location.x-img.getWidth(panel)/2, this.location.y-img.getHeight(panel)/2, this.panel);
	}
	
	public Rect getRect() {
		Point origin = new Point(location.x, location.y);
		Size size = new Size(img.getWidth(panel), img.getHeight(panel));
		return new Rect(origin, size);
	}
	
	public void heartBeat() {
		
	}
	
	public void run() {
		while(true) {
			if(this.direction == FlyDirection.VerticalDown) {
				this.location.y += this.rate;
			}
			if(this.direction == FlyDirection.VerticalUp) {
				this.location.y -= this.rate;
			}
			Rectangle r = this.panel.getBounds();
			Rect panelBounds = new Rect(r.x, r.y, r.width, r.height);
			
			if(!this.getRect().inRect(panelBounds)) {
				System.out.println("销毁操作");
				this.panel.removeEquipment(this);
			}
			this.heartCount += 1;
			this.heartBeat();
			
			Notification noti = new Notification("location changed", this, 1);
			NotificationCenter.defaultCenter().sendNotification(noti);
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				
			}
		}
	}
	
    public void handleNotification(Notification notification, Object handback) {
    	
    }
}
