import Picture.ModifyWayPicture;

public class BasicZombie extends Zombies {
	private int hp;
	private static final int damage = 30;
	private final double taille = 0.08;
	private boolean bouge;
	private double vitesse;
	private Timer dps;
	private Timer timeFreeze = new Timer(2000);
	private int freeze = 0;
	private Timer timerFreeze;
	
	
	
	private boolean takeDamage = false;

	public BasicZombie (double x, double y) {
		super(damage,x,y);
		this.hp = 200;
		dps = new Timer(1250);
		bouge = true;
		vitesse = speed;
		timerFreeze = new Timer(1100);
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
		
		} 
		else bouge = true;
		if (bouge) { 
			position.setX(position.getX() - vitesse);
		}

		if (hp <= 0) { 
			GameWorld.buffDelete.add(this);
			GameWorld.nbZombieKilled ++;
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
		//System.out.println(position.getX());
	    Position p = new Position(x, y);
	    return p;
	  }


	public void dessine() {
		// TODO Auto-generated method stub
		
		if(takeDamage) {
			double Ymax = Grid.MaxHaut.getY();
			StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2,
					GameWorld.repoImages + "/DamageZombie.png"
					,taille,taille*Main.mult);
				
			takeDamage = false;
			//timeFreeze.restart();			
		}
		if(vitesse != speed) {
			
			double Ymax = Grid.MaxHaut.getY();
			StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2,
					GameWorld.repoImages + "/ColdZombie.png"
					,taille,taille*Main.mult);
			
			
			
		}
		
		else {
		double Ymax = Grid.MaxHaut.getY();
		StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2,
				GameWorld.repoImages + "/Zombie_(PVZ-_DA).png"
				,taille,taille*Main.mult);  
		}
	}
}
