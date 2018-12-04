
public class Zombies extends Entite {
	private int hp;
	private double speed;
	private int damage;
	
	public Zombies(int damage, double x, double y) {
		super(x,y);
		this.speed = 0.0125;
		this.damage = damage;
	}
	@Override
	public void step() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dessine() {
		// TODO Auto-generated method stub

	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double x) {
		this.speed = x;
	}

	public int getDamage() {
		return damage;
	}
	@Override
	public Position hitbox() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void moinsHp(int hp) {
		// TODO Auto-generated method stub
		
	}
	

	
	

}
