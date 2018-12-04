
public class Position {
	private double x;
	private double y;

	public Position(double x, double y){
		this.x=x;
		this.y=y;
	}

	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}
	/**
	 * 
	 * @param p une position	
	 * @return true si les 2 elements sont proches
	 */
	public boolean equals(Position p){
		if(Math.abs(this.x - p.x) < 0.05  && Math.abs(this.y - p.y) < 0.05) return true;
		else return false;//&& (this.y - p.y) < 0.05);
	}

	public boolean ligneJalapeno(Position p) {
		if(this.x - p.x > 0  && Math.abs(this.y - p.y) < 0.05) return true;
		else return false;
	}

	public void setY(double y) {
		// TODO Auto-generated method stub
		this.y = y;
	}

	public void setX(double x) {
		// TODO Auto-generated method stub
		this.x= x;
	}

	public String toString(){
		return null;
	}
}
