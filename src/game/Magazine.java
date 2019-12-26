package game;

import java.util.List;

public class Magazine {
	//子弹
	private List<Weapon> bullets;
	//导弹
	private List<Weapon> missiles;
	
	public Magazine(List bullets, List missiles) {
		super();
		this.bullets = bullets;
		this.missiles = missiles;
	}
	
	//取子弹
	public Weapon takeBullet() {
		Weapon bullet = null;
		if(this.bullets.size() > 0) {
			bullet = this.bullets.get(0);
			this.bullets.remove(0);
		}
		return bullet;
	}
	
	//取导弹
	public Weapon takeMissile() {
		Weapon missile = null;
		if(this.missiles.size() > 0) {
			missile = this.missiles.get(0);
			this.missiles.remove(0);
		}
		return missile;
	}
}
