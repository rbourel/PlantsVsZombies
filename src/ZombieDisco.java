import Picture.ModifyWayPicture;
public class ZombieDisco extends Zombies{

	private int hp = 1000;

	private static final int damage = 30;
	private final double taille = 0.09;
	private boolean bouge;
	private Timer attackSpeed;
	private double vitesse;
	private boolean takeDamage = false;
	Timer timeFreeze = new Timer(800);
	private int spawnZ = 0;

	public ZombieDisco (double x, double y) {
		super(damage,x,y);
		bouge = true;
		attackSpeed = new Timer(1500);
		vitesse = speed;
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


	}
	@Override
	public void moinsHp(int h) {
		hp -= h;
		takeDamage = true;
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
		//System.out.println(position.getX());
		Position p = new Position(x, y);
		return p;

	}

	public void dessine() {
		// TODO Auto-generated method stub
		if(takeDamage) {
			double Ymax = Grid.MaxHaut.getY();
			StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2,
					ModifyWayPicture.DamageZombieDisco
					,taille,taille*Main.mult);
			takeDamage = false;
			timeFreeze.restart();
		}

		if(vitesse != speed) {
			double Ymax = Grid.MaxHaut.getY();
			StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2,
					ModifyWayPicture.ColdZombieDisco
					,taille,taille*Main.mult);

			if(timeFreeze.hasFinished())
				speedZombie(0.0125);
		}
		else {
			double Ymax = Grid.MaxHaut.getY();
			StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2,ModifyWayPicture.ZombieDisco
					,taille,taille*Main.mult);
		}
	}



}