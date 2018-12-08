
public class Tournesol extends Plant {
	private static final int cost = 50; //50
	private int hp = 300; //300
	private static final int cooldown = 5; 
	private Timer timeSun;
	private static final double Tournesol_SIZE = 0.09;
	private static Timer timerDispo = new Timer(cooldown * 1000); //5s
	private static boolean statut;
	private static boolean dispo;
	private boolean takeDamage = false;

	public Tournesol(double x, double y) {
		super(cost, cooldown, x, y);
		timeSun = new Timer(24000); //24s demande
		statut = false;
		timerDispo.restart();
	}
	//	public void spawn() {
	//			GameWorld.buffCreate.add(new Sun(this.position.getX(), this.position.getY()-0.02));
	//	}

	public void step() {
		if(timeSun.hasFinished()) {
			int posX = (int)Grid.worldToGrid(this.position.getX(), this.position.getY()).getX();
			int posY = (int)Grid.worldToGrid(this.position.getX(), this.position.getY()).getY();
			GameWorld.buffCreate.add(new Sun(posX,posY));
			timeSun.restart();
		}
		if(hp <= 0) supprPlantGrid();
	}


	public void dessine() {
		//StdDraw.setPenColor(StdDraw.YELLOW);
		if(takeDamage) {
			StdDraw.picture(this.position.getX(), this.position.getY(),GameWorld.repoImages + "/DamageTournesol.png"
					,Tournesol_SIZE,Tournesol_SIZE*Main.mult);
			takeDamage = false;
		}
		else {
			StdDraw.picture(this.position.getX(), this.position.getY(),GameWorld.repoImages + "/HD_Sunflower.png"
					,Tournesol_SIZE,Tournesol_SIZE*Main.mult);
		}
	}

	static boolean getDispo()	{
		if (timerDispo.hasFinished())
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
	public void moinsHp(int h) {
		hp -= h;
		takeDamage = true;
		System.out.println(hp);
	}

	@Override
	public Position hitbox() {
		Position p = new Position(getX() + 0.05, getY());
		return p;
	}

	@Override
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub

	}


}
