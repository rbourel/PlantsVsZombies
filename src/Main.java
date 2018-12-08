

/**
 * 
 * @author Rodrigue
 *Le but du Jeu est de tuez les Zombie grace au nombreuses Plantes presentes dans le jeu
 *La Partie est gagnez quand vous avez Tuez le nombre de Zombie equivalent à la variable finale MaxZombie de GameWorld
 */
public class Main {

	public static final int width =1024;
	public static final int height = 600;
	public static final double mult = (double)width/(double)height; 
	public static boolean menuZ = false;
	public static boolean menuP = false;
	public static boolean launch = false;

	public static void main(String[] args) {

		System.out.println(Grid.gridToWorld(0,0).getX());
		System.out.println(Grid.gridToWorld(0,0).getY());


		// reglage de la taille de la fenetre de jeu, en pixels (nb: un Ã©cran fullHD = 1980x1050 pixels)
		StdDraw.setCanvasSize(width, height);



		// permet le double buffering, pour permettre l'animation
		StdDraw.enableDoubleBuffering();


		while (!StdDraw.isKeyPressed(10)) {
			if(!StdDraw.hasNextKeyTyped())
				InformationsEntite.menu();

			if(StdDraw.isKeyPressed(90)) {
				menuP = false;
				menuZ = true;

			}
			if(menuZ) {
				InformationsEntite.afficheInfoZ();
				StdDraw.show();
			}



			if(StdDraw.isKeyPressed(77)) {
				menuP = false;
				menuZ = false;
				InformationsEntite.menu();
			}

			if(StdDraw.isKeyPressed(80)) {
				menuZ = false;
				menuP = true;
			}
			if(menuP) {
				InformationsEntite.afficheInfoP();


			}
		}
		if(StdDraw.isKeyPressed(10))
			launch = true;
		if(launch) {
			GameWorld world = new GameWorld();
			// la boucle principale de notre jeu
			while (!GameWorld.gameLost() && !GameWorld.gameWon()) {
				// Efface la fenetre graphique
				StdDraw.clear();



				// Capture et traite les eventuelles interactions clavier du joueur
				if (StdDraw.hasNextKeyTyped()) {
					char key = StdDraw.nextKeyTyped();
					world.processUserInput(key);
				}

				if (StdDraw.isMousePressed()) {
					world.processMouseClick(StdDraw.mouseX(), StdDraw.mouseY());

				}



				world.step();


				// dessine la carte
				world.dessine();

				world.refreshSoleils();
				world.refreshZombie();


				// Montre la fenetre graphique mise a jour et attends 20 millisecondes
				StdDraw.show();
				StdDraw.pause(20);


			}

			if (GameWorld.gameWon()) System.out.println("Game won !");
			if (GameWorld.gameLost()) System.out.println("Game lost...");

		}
	}
}


