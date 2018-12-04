import Picture.ModifyWayPicture;

public class ArmorZombie extends Zombies {
	private int hp = 560;
	private double speed = 0.0125;
	public double coldSpeed = speed/2;
	Timer timeFreeze = new Timer(1000);
	private static final int damage = 30;
	private final double taille = 0.09;
	private boolean bouge = true;
	private Timer dps;
	private boolean takeDamage = false;
	
	public ArmorZombie (double x, double y) {
		super(damage,x,y);
		
		this.hp = 560;
		dps = new Timer(1250);
	}
	public void step() {
		// TODO Auto-generated method stub
		
		//if(getX() <= 0) GameWorld.gameLost = true;
		

		if (colPlant()) {
			bouge = false;
			if (dps.hasFinished()) {
				damagePlant(damage);
				dps.restart();
			}
		} else bouge = true;
		if (bouge) { 
			position.setX(position.getX() - speed);
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
					ModifyWayPicture.DamageArmor
					,taille,taille*Main.mult);
			takeDamage = false;
		}
		else {
		double Ymax = Grid.MaxHaut.getY();
		StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2,ModifyWayPicture.ArmorZombieURL
				,taille,taille*Main.mult);
		}
	}
}