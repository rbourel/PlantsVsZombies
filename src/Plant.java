
public abstract class Plant extends Entite {
	private int cost;
	private int cooldown;
	
	
	public Plant(int cost , int cooldown, double x, double y) {
		super(x,y);
		this.cost = cost;
		this.cooldown = cooldown;
	}
	
	@Override
	public void step() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dessine() {
		// TODO Auto-generated method stub

	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public void moinsHp(int hp) {
		// TODO Auto-generated method stub
		
	}
	
	public void supprPlantGrid() {
		GameWorld.buffDelete.add(this) ;
		Position p = Grid.worldToGrid(getX(), getY());
		Entite t = GameWorld.plantGrid[(int)p.getX()][(int)p.getY()];
		GameWorld.buffDelete.add(t);
		System.out.println(GameWorld.buffDelete.toString());
		GameWorld.plantGrid[(int)p.getX()][(int)p.getY()] = null; 
}


}
