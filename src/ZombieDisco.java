import Picture.ModifyWayPicture;
public class ZombieDisco extends Zombies{

	private int hp = 500;

	private static final int damage = 40;
	private final double taille = 0.09;
	private boolean bouge;
	/** Vitesse d'attaque du Zombie */
	private Timer attackSpeed;
	/** Vitesse du Zombie */
	private double vitesse;
	/** Renvoie True si le Zombie a pris des degats */
	private boolean takeDamage = false;
	/** Permet de faire Spawnez les Zombie autour du Zombie Disco, equivalent a un Timer mais avec des Int*/
	private int spawnZ = 0;
	/** Permet de gelez un certains temps le Zombie, equivalent a un Timer mais avec des Int */
	private Timer timerFreeze;

	public ZombieDisco (double x, double y) {
		super(damage,x,y);
		bouge = true;
		attackSpeed = new Timer(1000);
		vitesse = speed;
		timerFreeze = new Timer(1100);
	}
	public void step() {
		// TODO Auto-generated method stub


		if(spawnZ < 60) {
			spawnZ++;
		}
		if(spawnZ == 60) {

			GameWorld.buffCreate.add(new BasicZombie(getX() + 0.8, getY()));
			GameWorld.buffCreate.add(new BasicZombie(getX() - 0.8, getY()));
			if(getY() + 1 < 5)
				GameWorld.buffCreate.add(new BasicZombie(getX() , getY() + 1));
			if(getY()- 1 > 0)
				GameWorld.buffCreate.add(new BasicZombie(getX() , getY() - 1));
			spawnZ++;
		}

		if (colPlant()) {
			bouge = false;
			if (attackSpeed.hasFinished()) {
				damagePlant(damage);
				attackSpeed.restart();
			}
		} else bouge = true;

		if (bouge) { 
			position.setX(position.getX() - vitesse);
		}

		if (hp <= 0) { 
			GameWorld.buffDelete.add(this);
			GameWorld.nbZombieKilled +=1;
		}

		if(timerFreeze.hasFinished())
			setSpeed(speed);


	}
	
	@Override
	public void moinsHp(int h) {
		hp -= h;
		takeDamage = true;
		timerFreeze.restart();
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpeed(double speed) {
		vitesse = speed;
	}

	@Override
	public Position hitbox() {
		double y = getY()*Grid.CASE_SIZE_Y+Grid.CASE_SIZE_Y/2;
		double x = getX()/(Grid.NB_CASE_X-1);
		x += 0.04;
		Position p = new Position(x, y);
		return p;

	}

	public void dessine() {
		// TODO Auto-generated method stub
		if(takeDamage) {
			double Ymax = Grid.MaxHaut.getY();
			StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2,
					GameWorld.repoImages + "/DamageDiscoZombie.png"
					,taille,taille*Main.mult);
			takeDamage = false;
		}

		if(vitesse != speed) {
			double Ymax = Grid.MaxHaut.getY();
			StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2,
					GameWorld.repoImages + "/ColdDiscoZombie.png"
					,taille,taille*Main.mult);

		}
		else {
			double Ymax = Grid.MaxHaut.getY();
			StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2,
					GameWorld.repoImages + "/DiscoZombie.png"
					,taille,taille*Main.mult);
		}
	}

}