

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

	public static void main(String[] args) {

		System.out.println(Grid.gridToWorld(0,0).getX());
		System.out.println(Grid.gridToWorld(0,0).getY());

		GameWorld world = new GameWorld();

		// reglage de la taille de la fenetre de jeu, en pixels (nb: un Ã©cran fullHD = 1980x1050 pixels)
		StdDraw.setCanvasSize(width, height);



		// permet le double buffering, pour permettre l'animation
		StdDraw.enableDoubleBuffering();

		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0.5D, 0.5D, 0.5D, 0.5D);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(0.5, 0.9, "Bienvenue dans Plants Vs Zombie");
		StdDraw.text(0.5, 0.85, "Le but du jeu est d'eliminer les Zombie");
		StdDraw.text(0.5, 0.8, "Pour ceci il existe plusieurs plantes achetable grace au nombre de Soleil que vous avez");
		StdDraw.text(0.5, 0.75, "Vous pouvez voir votre nombre de Soleil en temps reel en haut a gauche");
		StdDraw.text(0.5, 0.7, "Pour poser une plante, positionnez votre curseur a l'endroit ou vous voulez la placez et appuyez sur la touche correspondante");
		StdDraw.text(0.5, 0.65, " T : Tournesol    P : Tire Pois    N : Noix    J : Jalapeno    C : Tire_Pois Gel");
		StdDraw.text(0.5, 0.6, "Le Tournesol permet de recuperer des Soleil");
		StdDraw.text(0.5, 0.55, "Le Tire Pois Vert permet de tuez les Zombies en envoyant des Pois dessus");
		StdDraw.text(0.5, 0.5, "Le Tire Pois Bleu permet de ralentir et tuez les Zombies en envoyant des Pois dessus ");
		StdDraw.text(0.5, 0.45, "La Noix possedent beaucoup de vie (1500) et permet de bloquez les Zombies");
		StdDraw.text(0.5, 0.4, "Le Jalapeno tue tout  les Zombies a sa droite, il explose rapidement apres avoir ete placez");

		StdDraw.text(0.5, 0.2, "POUR PLUS D'INFORMATION SUR LES PLANTES CLIQUEZ SUR P");
		StdDraw.text(0.5, 0.15, "POUR PLUS D'INFORMATION SUR LES ZOMBIES CLIQUEZ SUR Z");

		StdDraw.text(0.5, 0.1, "APPUYEZ SUR UNE TOUCHE QUAND VOUS ETES PRET");
		StdDraw.show();
		StdDraw.text(0.05, 0.075, "Ici");
		StdDraw.show();
		while (!StdDraw.hasNextKeyTyped()) {} 
		if(StdDraw.isKeyPressed(90) || StdDraw.isKeyPressed(80)) {
			System.out.println("EFRGTHN?JKLIKUJYHTGRFE");
				if(StdDraw.isKeyPressed(90))
					InformationsEntite.afficheInfoZ();
				if(StdDraw.isKeyPressed(80)) {
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(0.5D, 0.5D, 0.5D, 0.5D);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(0.5, 0.4, "Le Jalapeno tue tout  les Zombies a sa droite, il explose rapidement apres avoir ete placez");	
					StdDraw.show();
				}
		}

		else {

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
