
public abstract class Entite {

	// la position de l'entite
	protected Position position;

	public Entite(double x, double y) {
		position = new Position(x, y);
	}

	public abstract Position hitbox();

	public double getX() {
		return position.getX();
	}

	public double getY() {
		return this.position.getY();
	}

	public abstract void moinsHp(int hp);

	public void setPosition(Position p){
		this.position = p;
	}

	// met a jour l'entite : deplacement, effectuer une action
	public abstract void step();

	// dessine l'entite, aux bonnes coordonnees
	public abstract void dessine();


	/**
	 * @return true ssi il y a collision entre une Plante et un Zombie
	 */
	public boolean colPlant()  {
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Plant)) && (entite.hitbox().equals(hitbox()))) {
				return true;
			}
		}
		return false;
	}	
	
	/**
	 * @param x fait des dommage egale a x � la Plante 
	 */
	public void damagePlant(int x) {
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Plant)) && (entite.hitbox().equals(hitbox())))
				entite.moinsHp(x);
		}
	}

	/**
	 * Cette fonction est utilis� dans la Collision entre un Pois et un Zombie
	 * @return true si il y a collision entre un Zombie et un Projectile, false sinon
	 */
	public Zombies colZombies()	  {
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Zombies)) && (entite.hitbox().equals(hitbox()))) {
				return (Zombies)entite;
			}
		}
		return null;
	}
	/**
	 * 
	 * @param x le nombre de degat que prend le Zombie quand il recoie un Projectile sur lui
	 */
	public void damageZombie(int x) { 
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Zombies)) && (entite.hitbox().equals(hitbox())))
				entite.moinsHp(x);			
			
		}
	}
	
	/**
	 * 
	 * @return true si le Zombie est sur la ligne et � droite du Jalapeno
	 */
	public boolean JalapenoLigne()	  {
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Zombies)) && (entite.hitbox().ligneJalapeno(hitbox()))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean colColdPea()	  {
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Zombies)) && (entite.hitbox().equals(hitbox()))) {
				return true;
			}
		}
		return false;
	}
	

	public void setSpeedZombie(double x) { 
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Zombies)) && (entite.hitbox().equals(hitbox())))
				entite.setSpeedZombie(0.01);
		}
	}
	
	
	/**
	 * 
	 * @param x fait des dommage egale � x a tout les zombie present sur la ligne et � droite du Jalapeno
	 */
	public void damageJalapeno(int x) { 
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Zombies)) && (entite.hitbox().ligneJalapeno(hitbox())))
				entite.moinsHp(x);
		}
	}
	
	




}
