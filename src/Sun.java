import Picture.ModifyWayPicture;

public class Sun extends Entite {
	private static final double SUN_SIZE = 0.08;
	private Timer time;
	private boolean statut;
	protected int posX;
	protected int posY;
	public Sun(int x, int y) {
		super(0.05 + x / (double)(Grid.NB_CASE_X+1), 0.05 + y / (double)(Grid.NB_CASE_Y+1));
		posX = x;
		posY = y;
		statut = false;
		time = new Timer(20000);
	}
	@Override
	public void step() {
		if ((time.hasFinished()) && (!statut)) {
			statut = true;

		}
		else if ((GameWorld.isMouseClick()) && (GameWorld.getMouseX() == posX) && (GameWorld.getMouseY() ==posY)) {
			statut = true;
			GameWorld.setMouseClick(false);
		}

		if (statut) {
			GameWorld.money += 25;
			GameWorld.buffDelete.add(this);
		}

	}



	@Override
	public void dessine() {
		// TODO Auto-generated method stub
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.picture(this.position.getX()+Grid.CASE_SIZE_X/2, this.position.getY(), GameWorld.repoImages + "/sun.png"
				,SUN_SIZE,SUN_SIZE*Main.mult);
	}
	@Override
	public Position hitbox() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void moinsHp(int hp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub
		
	}


}
