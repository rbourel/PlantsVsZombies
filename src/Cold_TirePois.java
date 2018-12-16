
public class Cold_TirePois extends Plant {
	private static final int cost = 175; //Choisis comme dans le jeu
	private int hp = 300; //300
	private static final int cooldown = 5;
	private static final double TirePois_SIZE = 0.08;
	private Timer timepois; //1.5s
	private static Timer timer = new Timer(cooldown * 1000);
	private static boolean statut;
	private static boolean dispo;
	private boolean takeDamage = false;

	public Cold_TirePois(double x, double y) {
		super(cost, cooldown, x, y);
		timepois = new Timer(1750);
		timer.restart();
		statut = false;
	}
	public void step() {
		if (timepois.hasFinished()) {
			GameWorld.buffCreate.add(new ColdPea(this.position.getX(), this.position.getY())) ; //(new Projectile(this.position.getX(), this.position.getY())); //this.position.getX(), this.position.getY()
			timepois.restart();
		}
		if(hp <= 0) supprPlantGrid();
	}

	public Position hitbox() {
		Position p = new Position(getX() + 0.05, getY());
		return p;
	}

	public void dessine() {
		//StdDraw.setPenColor(StdDraw.GREEN);
		if(takeDamage) {
			StdDraw.picture(this.position.getX(), this.position.getY(),GameWorld.repoImages + "/NoColdTirePois.png"
					,TirePois_SIZE,TirePois_SIZE*Main.mult);
			takeDamage = false;
		}
		else
			StdDraw.picture(this.position.getX(), this.position.getY(), GameWorld.repoImages + "/coldTirePois.png"
					,TirePois_SIZE,TirePois_SIZE*Main.mult);
	}
	/**
	 * Permet de verifier la disponibilite de la Plante
	 * @return true ssi la Plante est disponible a ce moment precis
	 */
	static boolean getDispo() {
		if (timer.hasFinished())
			statut = true;
		if ((statut & GameWorld.money >= cost)) {
			dispo = true;
		} else {
			dispo = false;
		}
		return dispo;
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
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub

	}

}