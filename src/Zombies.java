
public class Zombies extends Entite {
	/** Nombre de point de vie du Zombie */
	private int hp;
	/** Vitesse du Zombie, global a tout les Zombie ici */
	protected double speed;
	/** Nombre de dommage inflige par les Zombie au Plante par coup */
	private int damage;

	public Zombies(int damage, double x, double y) {
		super(x,y);
		this.speed = 0.0075;
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
	/**
	 * Recupere le nombre de point de vie du Zombie
	 * @return le nombre de point de vie du Zombie
	 */
	public int getHp() {
		return hp;
	}
	/**
	 * Modifier le nombre de point de vie du Zombie
	 * @param hp modifie le nombre d'hp du Zombie
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	/**
	 * Recupere la vitesse du Zombie
	 * @return la vitesse du Zombie
	 */
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
	/**
	 * Change la vitesse des Entite, particulierement utilse pour les Zombie qui peuvent changer de vitesse si ils sont touchez par un Pois Gele (class ColdPea)
	 */
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub

	}





}
