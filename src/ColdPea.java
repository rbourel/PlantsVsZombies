import java.sql.Time;

import Picture.ModifyWayPicture;

public class ColdPea extends Entite {

	private static final double TRUC_MOVE_X = 0.005; // 0.5case/s = Grid.caseSizeX / (1000/20)
	private static final double TRUC_SIZE = 0.02;
	private final int damage = 50; //20
	
//	private boolean coldTouch = false;
//	private Timer timeFreeze;
	public ColdPea(double x, double y) {
		super(x, y);	
	}
	public Position hitbox() {
	    Position p = new Position(getX() + 0.1, getY());
	    return p;
	  }

	@Override
	public void step() {
		this.position.setX(this.position.getX() + TRUC_MOVE_X);
		if(this.position.getX() > 1)
			GameWorld.buffDelete.add(this);
		
		if(colZombies() != null) {
			speedZombie(0.005);
		}
		
		if (colZombies() != null) {
		      GameWorld.buffDelete.add(this);
		      damageZombie(damage);
		      
		   	
		      
//		      timeFreeze = new Timer(2000);
//				coldTouch = true;
		      
		    }

	}

	@Override
	public void dessine() {
		StdDraw.setPenColor(0,150,0);
		//StdDraw.filledEllipse(this.position.getX()+0.04, this.position.getY()+Grid.CASE_SIZE_Y/2-0.05, TRUC_SIZE/Main.mult, TRUC_SIZE);
		StdDraw.picture(this.position.getX()+0.04, this.position.getY()+0.05, GameWorld.repoImages + "/coldPea.png"
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
