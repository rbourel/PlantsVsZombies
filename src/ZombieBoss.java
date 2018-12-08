/**
 * 
 * Class Non utilise pour le moment, peut etre utilise pour rajouter un type de Zombie rapidement
 *
 */
public class ZombieBoss extends Zombies {
	private static int hp = 1000;
	Timer timeFreeze = new Timer(1000);
	private static final int damage = 30;
	private final double taille = 0.09;
	private boolean bouge;
	private double vitesse;
	private Timer dps;
	private boolean takeDamage = false;

	public ZombieBoss (double x, double y) {
		super(damage,x,y);
		bouge = true;
		vitesse = speed;
	}
	public void step() {
		// TODO Auto-generated method stub


		if (colPlant()) {
			bouge = false;
			if (dps.hasFinished()) {
				damagePlant(damage);
				dps.restart();
			}
		} else bouge = true;
		if (bouge) { 
			position.setX(position.getX() - vitesse);
		}

		if (hp <= 0) { 
			GameWorld.buffDelete.add(this);
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
		StdDraw.setPenColor(StdDraw.BLACK);
		if(takeDamage) {
			double Ymax = Grid.MaxHaut.getY();
			StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2
					,GameWorld.repoImages + "/ZombieA.png"
					,taille,taille*Main.mult);
		}
		else {
			double Ymax = Grid.MaxHaut.getY();
			StdDraw.picture(this.position.getX()/(Grid.NB_CASE_X-1), this.position.getY()*(Ymax/Grid.NB_CASE_Y)+Grid.CASE_SIZE_Y/2
					,GameWorld.repoImages + "/ZombieA.png"
					,taille,taille*Main.mult);
		}
	}



}