import Picture.ModifyWayPicture;

public class Jalapeno extends Plant {
	private static final int cost = 150;
	private int hp = 200;
	private static final int cooldown = 5;
	private static Timer timer = new Timer(2000);
	private static boolean statut;
	private static boolean dispo;
	private int taillePlus = 0;
	
	private double JalapenoSize = 0.07;
	
	
	public Jalapeno(double x, double y) {
		super(cost, cooldown, x, y);
		timer.restart();
		statut = false;
	}

	@Override
	public Position hitbox() {
		// TODO Auto-generated method stub
		   Position p = new Position(getX() + 0.05, getY());
		    return p;
	}


	@Override
	public void step() {
		taillePlus++;
		if(taillePlus > 50) {
			if (JalapenoLigne()) {
			      damageJalapeno(1000);
			    }
			hp = 0;
		}
		if(hp <= 0) GameWorld.buffDelete.add(this);
		if(hp <= 0) supprPlantGrid();
		// TODO Auto-generated method stub
	}
	
	static boolean getDispo()	{
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
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dessine() {
		//StdDraw.setPenColor(StdDraw.GREEN);
		if(taillePlus < 10) {
			StdDraw.picture(this.position.getX(), this.position.getY(),ModifyWayPicture.jalapeno
					,JalapenoSize,JalapenoSize*Main.mult);
		}
		else if(taillePlus > 10){
			JalapenoSize += 0.001;
		StdDraw.picture(this.position.getX(), this.position.getY(), ModifyWayPicture.jalapeno
				,JalapenoSize,JalapenoSize*Main.mult);
		}
		if(taillePlus >=50) {
			StdDraw.setPenColor(StdDraw.RED);
			//StdDraw.filledRectangle((getX()+1)/2, getY(), (1-getX())/2, Grid.CASE_SIZE_Y/2);
			StdDraw.picture((getX()+1)/2, getY(),ModifyWayPicture.fireJalapeno, (1-getX()), Grid.CASE_SIZE_Y);
		}
				
	}

	@Override
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub
		
	}

}
