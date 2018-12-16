
public class Noix extends Plant {
	private static final int cost = 50;
	private int hp = 1500;
	private static final int cooldown = 10; //20
	private static final double Noix_SIZE = 0.07;
	private static Timer timer = new Timer(cooldown * 1000); //20s
	private static boolean statut;
	private static boolean dispo;
	private boolean takeDamage = false;

	public Noix(double x, double y) {
		super(cost, cooldown, x, y);
		GameWorld.money -= cost;
		statut = false;
		//timer.restart();
	}
	/**
	 * Permet de verifier la disponibilite de la Plante
	 * @return true ssi la Plante est disponible a ce moment precis
	 */
	static boolean getDispo()  {
		if (timer.hasFinished())
			statut = true;
		if ((statut & GameWorld.money >= 50)) {
			dispo = true;
		} else {
			dispo = false;
		}
		return dispo;
	}

	@Override
	public void step() {
		if(hp <= 0) supprPlantGrid();
	}



	public void dessine() {
		if(takeDamage) {
			StdDraw.picture(this.position.getX(), this.position.getY(),GameWorld.repoImages + "/DamageNoix.png"
					,Noix_SIZE, Noix_SIZE*Main.mult);
			takeDamage = false;
		} else {
			StdDraw.picture(this.position.getX(), this.position.getY(), GameWorld.repoImages + "/noix.png"
					, Noix_SIZE,Noix_SIZE*Main.mult); 
		}
	}

	public static int getPrize() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public void moinsHp(int h) {
		hp -= h;
		takeDamage = true;
		// TODO Auto-generated method stub

	}

	@Override
	public Position hitbox() {
		Position p = new Position(getX() + 0.05, getY());
		//  System.out.println("Noix " + p.getX());
		return p;
	}

	@Override
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub

	}
}
