
public class Grid {
	public static final double NB_CASE_X = 9;
	public static final double NB_CASE_Y = 5;
	public static final Position MaxHaut = new Position(1,0.8);
	public static final double CASE_SIZE_X = MaxHaut.getX()/NB_CASE_X;
	public static final double CASE_SIZE_Y = MaxHaut.getY()/NB_CASE_Y;
	
	public static Position emplacement(double x, double y) {
		Position p = worldToGrid(x,y);
		Position world = gridToWorld(p.getX(),p.getY());
		return world;
		
	}
	/**
	 * @param x une valeur comprise entre 0 et 9 exprimant la position x dand la grille de Plant;
	 * @param y une valeur comprise entre 0 et 4 exprimant la position y dand la grille de Plant;
	 * @return une Position exprimant le centre de la case [x][y] dans l'interface graphique
	 */
	public static Position gridToWorld(double x , double y) {

		return new Position(x*CASE_SIZE_X+CASE_SIZE_X/2,y*CASE_SIZE_Y+CASE_SIZE_Y/2);
	}
	/**
	 * Fonction servant a simplifier la comprehension entre l'endroit ou l'on veut poser la plante  et sa valeur x dans la Class Gameworld
	 * @param p une Position exprimant le centre de la case [x][y] dans l'interface graphique
	 * @return la valeur x du centre de la case [x][y]
	 */
	public int gridToWorldGetX(Position p ) {
		return (int)gridToWorld(p.getX(),p.getY()).getX();
	}
	/**
	 * Fonction servant a simplifier la comprehension entre l'endroit ou l'on veut poser la plante  et sa valeur y dans la Class Gameworld
	 * @param p une Position exprimant le centre de la case [x][y] dans l'interface graphique
	 * @return la valeur y du centre de la case [x][y]
	 */
	public int gridToWorldGetY(Position p) {
		return (int)gridToWorld((int)p.getX(),(int)p.getY()).getY();
	}
	/**
	 * 
	 * @param x la position x dans le monde
	 * @param y la position y dans le monde
	 * @return la position dans la grille 
	 */
	public static Position worldToGrid(double x, double y) {
		return new Position((int)(x*NB_CASE_X*(1/MaxHaut.getX())%10),(int)(y*NB_CASE_Y*(1/MaxHaut.getY())%10));	
	}
	/**
	 * 
	 * @param p une position dans la grille
	 * @return
	 */
	public static boolean emptyCase(Position p) {
		int x = (int)p.getX();
		int y = (int)p.getY();
		if(x > 8 || y > 4) {
			System.out.println("Vous etes en dehors des delimitations du terrain");
			return false; //Je ne suis plus dans le "Jardin"
		}
		else {
		if(GameWorld.plantGrid[x][y] == null) {
			return true;
		}
		else return false;		
		}
		
	}

	public static void dessineGrille() {
		for(int i = 0; i < NB_CASE_X; i++) {
			for(int j = 0; j < NB_CASE_Y; j++) {
				double ix = i/NB_CASE_X+CASE_SIZE_X/2;
				double	jy = j/NB_CASE_Y+CASE_SIZE_Y/2;
				double largeur = CASE_SIZE_Y/2;
				double longueur = CASE_SIZE_X/2;
				if(i == 9) {
					StdDraw.setPenColor(157, 62, 12);
					StdDraw.filledRectangle(ix, jy, longueur, largeur);
				}
				else {
					if((i+j)%2 == 0) {
						StdDraw.setPenColor(0,200,0);
						StdDraw.filledRectangle(ix, jy, longueur, largeur);
					}
					else {
						StdDraw.setPenColor(0,100,0);
						StdDraw.filledRectangle(ix, jy, longueur, largeur);
					}
					
				}
			}
		}
	}


}
