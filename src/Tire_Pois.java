import Picture.ModifyWayPicture;

public class Tire_Pois extends Plant {
	private static final int cost = 100; //100
	private int hp = 300; //300
	private static final int cooldown = 5;
	private static final double TirePois_SIZE = 0.08;
	private Timer timepois; //1.5s
	private static Timer timer = new Timer(cooldown * 1000);
	private static boolean statut;
	private static boolean dispo;
	private boolean takeDamage = false;

	public Tire_Pois(double x, double y) {
		super(cost, cooldown, x, y);
		timepois = new Timer(2000);
		timer.restart();
		statut = false;
	}
	public void step() {
		if (timepois.hasFinished()) {
			GameWorld.buffCreate.add(new Projectile(this.position.getX(), this.position.getY())) ; //(new Projectile(this.position.getX(), this.position.getY())); //this.position.getX(), this.position.getY()
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
			StdDraw.picture(this.position.getX(), this.position.getY(),ModifyWayPicture.NoSunFlowerURL
					,TirePois_SIZE,TirePois_SIZE*Main.mult);
			takeDamage = false;
		}
		else
		StdDraw.picture(this.position.getX(), this.position.getY(), ModifyWayPicture.PeaShooterURL
				,TirePois_SIZE,TirePois_SIZE*Main.mult);
	}
	static boolean getDispo()
	  {
	    if (timer.hasFinished())
	      statut = true;
	    if ((statut & GameWorld.money >= 50)) {
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
	
}