package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.ImageIcon;

/*
 * 飞机
 * */
public class Plane implements Runnable,IDraw{
	/*
	 * 飞机图片、位置
	 * */
	//图片名
	private String imgName;
	//图片
	private Image  img;
	//x坐标
	private int x;
	//y坐标
	private int y;
	//所处的平面
	private	Panel panel;
	//速度
	private  int rate;
	//飞行方向
	public FlyDirection direction;
	
	public Plane(String imgName,Panel panel) {
		this(imgName,panel,0,0);
	}
	public Plane(String imgName, Panel panel, int x, int y) {
		this(imgName,panel,0,x,y);
	}	
	public Plane(String imgName, Panel panel, int rate,int x, int y) {
		super();
		this.imgName = imgName;
		Image img = new ImageIcon("sourcefiles/"+this.imgName).getImage();
		this.img = img;
		this.x = x;
		this.y = y;
		this.panel = panel;
		this.rate = rate;
		this.direction = FlyDirection.VerticalDown;
		
		Thread t = new Thread(this);
		t.start();
	}

	public void moveTo(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	//IDraw
	public void draw(Graphics g) {
		g.drawImage(img, this.x-img.getWidth(panel)/2, this.y-img.getHeight(panel)/2, this.panel);
	}
	
	//Runnable
	public void run() {
		while(true) {
			if(this.direction == FlyDirection.VerticalDown) {
				y += this.rate;
			}	
			if(this.direction == FlyDirection.VerticalUp) {
				y -= this.rate;
			}
			if(y < 0) {
			}
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				
			}
		}
	}
}
