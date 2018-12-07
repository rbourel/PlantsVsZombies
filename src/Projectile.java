import Picture.ModifyWayPicture;

public class Projectile extends Entite {

	private static final double TRUC_MOVE_X = 0.005; // 0.5case/s = Grid.caseSizeX / (1000/20)
	private static final double TRUC_SIZE = 0.02;
	private final int damage = 50; //20
	public Projectile(double x, double y) {
		super(x, y);	
	}
	public Position hitbox() {
	    Position p = new Position(getX() + 0.07, getY());
	    return p;
	  }

	@Override
	public void step() {
		this.position.setX(this.position.getX() + TRUC_MOVE_X);
		if(this.position.getX() > 1)
			GameWorld.buffDelete.add(this);

		if (colZombies() != null) {
		      GameWorld.buffDelete.add(this);
		      damageZombie(damage);
		    }


	}

	@Override
	public void dessine() {
		StdDraw.setPenColor(0,150,0);
		//StdDraw.filledEllipse(this.position.getX()+0.04, this.position.getY()+Grid.CASE_SIZE_Y/2-0.05, TRUC_SIZE/Main.mult, TRUC_SIZE);
		StdDraw.picture(this.position.getX()+0.04, this.position.getY()+0.05, GameWorld.repoImages + "/pea.png"
				,TRUC_SIZE,TRUC_SIZE*Main.mult);
	}

	@Override
	public void moinsHp(int h) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub
		
	}

}
