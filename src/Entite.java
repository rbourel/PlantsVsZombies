/**
 * 
 * @author Rodrigue
 *	
 */
/**
 * 
 * Class Entite, la class Mere de toutes les Entites que nous creeront
 * 
 *
 */
public abstract class Entite {

	// la position de l'entite
	protected Position position;
	/**
	 * 
	 * @param x position x
	 * @param y position y
	 */
	public Entite(double x, double y) {
		position = new Position(x, y);
	}
	/**
	 * Ce n'est pas vraiment une hitbox mais reste dans le meme principe car cette fontion permet de savoir quand il y a collision entre 2 Entites
	 * @return la distance x,y qui separe le centre de l'Entite de sa hitbox 
	 */
	public abstract Position hitbox();
	/** @return la position X de l'Entite */
	public double getX() {
		return position.getX();
	}
	/** @return la position Y de l'Entite */
	public double getY() {
		return this.position.getY();
	}
	/**
	 * Permet de changez le nombre de point de vie de chaque entite,
	 * d'avoir une animation de degat avec takeDamage
	 * Reinitialiser un Timer
	 * @param hp un nombre d'hp (Ici ce sera le nombre de point de vie perdu)
	 * 
	 */
	public abstract void moinsHp(int hp);

	/*
	 * Change la vitesse des Entite, particulierement utilse pour les Zombie qui peuvent changer de vitesse si ils sont touchez par un Pois Gele (class ColdPea)
	 */
	public abstract void setSpeed(double speed);

	/**
	 * 
	 * @param p une position
	 * Change la position de l'Entite en la Position p, utile pour pouvoir deplacer les Entites dans le Monde 
	 */
	public void setPosition(Position p){
		this.position = p;
	}

	/** met a jour l'entite : deplacement, effectuer une action */
	public abstract void step();

	/** dessine l'entite, aux bonnes coordonnees */
	public abstract void dessine();


	/**
	 * Cette fonction est utilisé dans la Collision entre une Plante et un Zombie
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
	 * Cette fonction permet de reduire le nombre d'hp de la Plante lorsqu'elle est touche
	 *
	 * @param x fait des dommage egale a x a la Plante 
	 */
	public void damagePlant(int x) {
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Plant)) && (entite.hitbox().equals(hitbox())))
				entite.moinsHp(x);
		}
	}

	/**
	 * Cette fonction est utilisé dans la Collision entre un Pois et un Zombie
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
	 * Cett fonction permet de reduire le nombre d'hp du Zombie lorsqu'il est touche
	 * @param x le nombre de degat que prend le Zombie quand il recoie un Projectile sur lui
	 */
	public void damageZombie(int x) { 
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Zombies)) && (entite.hitbox().equals(hitbox())))
				entite.moinsHp(x);			

		}
	}

	/**
	 * Cette fonction permet de savoir qu'elle Zombie sont sur la ligne et a droite du Jalapeno
	 * @return true si le Zombie est sur la ligne et a droite du Jalapeno
	 */
	public boolean JalapenoLigne()	  {
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Zombies)) && (entite.hitbox().ligneJalapeno(hitbox()))) {
				return true;
			}
		}
		return false;
	}


	/**
	 * Cette fonction permet de tuez tout les Zombie sur la ligne et a droite du Jalapeno
	 * @param x fait des dommage egale a x a tout les zombie present sur la ligne et seulement a droite du Jalapeno
	 */
	public void damageJalapeno(int x) { 
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Zombies)) && (entite.hitbox().ligneJalapeno(hitbox())))
				entite.moinsHp(x);
		}
	}


	/**
	 * La fonction va changer la vitesse du Zombie, principalement utilise ici lors d'une collision entre un Zombie et un Pois Gele
	 * @param x la nouvelle vitesse du Zombie
	 * 
	 */
	public void speedZombie(double x) { 
		for (Entite entite : GameWorld.entites) {
			if (((entite instanceof Zombies)) && (entite.hitbox().equals(hitbox())))
				entite.setSpeed(x);

		}
	}












}
