
public class Zombies extends Entite {
	/** Nombre de point de vie du Zombie */
	private int hp;
	/** Vitesse du Zombie, global a tout les Zombie ici */
	protected double speed = 0.0125;
	/** Nombre de dommage inflige par les Zombie au Plante par coup */
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
	@Override
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub
		
	}
	

	
	

}
