/**
 * 
 * @author Rodrigue
 * 
 */
/**
 * 
 * La classe qui va permettre le bon positionnement de toute les Entite dans le monde
 *
 */
public class Grid {
	/** Il ne vaut mieux pas changer le nombre de case en largeur et hauteur car nous utilisons une image possedant 9x5 case */
	/** Nombre de case en largeur */
	public static final double NB_CASE_X = 9;
	/** Nombre de case en hauteur */
	public static final double NB_CASE_Y = 5;

	/** la Position max en x,y de notre grille */
	public static final Position MaxHaut = new Position(1,0.8);
	/** la largeur de chaque case calculer grace au nombre de case en largeur ainsi que le max pris par x */
	public static final double CASE_SIZE_X = MaxHaut.getX()/NB_CASE_X;
	/** la hauteur de chaque case calculer grace au nombre de case en hauteur ainsi que le max pris par y */
	public static final double CASE_SIZE_Y = MaxHaut.getY()/NB_CASE_Y;

	/**
	 * 
	 * @param x un point sur l'axe X
	 * @param y un point sur l'axe Y
	 * @return la Position du centre de la case ou nous avons cliquer. 
	 */
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
	 * @return true ssi la case est vide (equivaut a : il n'y as pas de Plante ici )
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
	/**
	 * permet de dessiner une grille, dans le jeu que nous avons, nous ne l'utilisons pas car nous avons deja un jardin au format png
	 * Etant donnée que nous l'avons creer au debut du projet, elle ne marche pas actuellement du au amelioratons effectué
	 */
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
