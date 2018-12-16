/**
 * 
 * @author Rodrigue
 *@author Vincent
 *
 */
public class InformationsEntite {

	/** 
	 * Affiche les Insformations sur les Zombies si demande par l'utilisateur
	 */
	public static void afficheInfoZ() {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0.5D, 0.5D, 0.5D, 0.5D);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.picture(0.8 , 0.74, GameWorld.repoImages + "/Zombie_(PVZ-_DA).png", 0.08, 0.08 * Main.mult );
		StdDraw.text(0.5, 0.95, "Informations sur les ZOMBIE");
		StdDraw.text(0.5, 0.9, "Tout les Zombie ont une vitesse de de 0.0075");
		StdDraw.text(0.5, 0.8, "Zombie Normal : ");
		StdDraw.text(0.5, 0.76, "Il possede 200 points de vie");
		StdDraw.text(0.5, 0.72, "Attaque la plante a proximité toutes les 1,25secondes");
		StdDraw.text(0.5, 0.68, "Il fait 30 degats par attaque");

		StdDraw.picture(0.8 , 0.54, GameWorld.repoImages + "/armor zombie.png", 0.08, 0.08 * Main.mult );
		StdDraw.text(0.5, 0.6, "Zombie Blinde : ");
		StdDraw.text(0.5, 0.56, "Il possede 560 points de vie");
		StdDraw.text(0.5, 0.52, "Attaque la plante a proximité toutes les 1,2secondes");
		StdDraw.text(0.5, 0.48, "Il fait 30 degats par attaque");

		StdDraw.picture(0.82 , 0.34, GameWorld.repoImages + "/DiscoZombie.png", 0.08, 0.08 * Main.mult );
		StdDraw.text(0.5, 0.4, "Zombie Disco : ");
		StdDraw.text(0.5, 0.36, "Il possede 500 points de vie");
		StdDraw.text(0.5, 0.32, "Il fait spawnez 4 Zombie Normal autour de lui quelque secondes apres son appartion");
		StdDraw.text(0.5, 0.28, "Attaque la plante a proximité toutes les 1secondes");
		StdDraw.text(0.5, 0.24, "Il fait 40 degats par attaque");


		StdDraw.text(0.5, 0.15, "POUR RETOURNEZ AU MENU PRINCIPAL CLIQUEZ SUR M");
		StdDraw.text(0.5, 0.1, "APPUYEZ SUR ENTREE POUR LANCEZ LE JEU");
		StdDraw.show();
	}
	
	/** 
	 * Affiche les Insformations sur les Plante si demande par l'utilisateur
	 */
	public static void afficheInfoP() {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0.5D, 0.5D, 0.5D, 0.5D);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(0.5, 0.95, "Informations supplementaire sur les PLANTES");
		StdDraw.picture(0.8 , 0.83, GameWorld.repoImages + "/tire pois.png", 0.07, 0.07 * Main.mult );
		StdDraw.text(0.5, 0.88, "TirePoisVert : ");
		StdDraw.text(0.5, 0.85, "Il possede 300 points de vie et est disponible toute les 5sec");
		StdDraw.text(0.5, 0.82, "Attaque le Zombie le plus proche sur sa ligne toute les 2sec");
		StdDraw.text(0.5, 0.79, "grace a un Pois qui fait 50 degats par attaque");

		StdDraw.picture(0.8 , 0.69, GameWorld.repoImages + "/coldTirePois.png", 0.07, 0.07 * Main.mult );
		StdDraw.text(0.5, 0.73, "TirePoisBleu : ");
		StdDraw.text(0.5, 0.7, "Il possede 300 points de vie et est disponible toute les 5sec");
		StdDraw.text(0.5, 0.67, "Attaque le Zombie le plus proche sur sa ligne toute les 1.75sec");
		StdDraw.text(0.5, 0.64, "grace a un Pois qui fait 50 degats par attaque et gele le Zombie pendant 1.1sec");

		StdDraw.picture(0.8 , 0.53, GameWorld.repoImages + "/HD_Sunflower.png", 0.07, 0.07 * Main.mult );
		StdDraw.text(0.5, 0.57, "Tournesol : ");
		StdDraw.text(0.5, 0.54, "Il possede 300 points de vie");
		StdDraw.text(0.5, 0.51, "Fait apparaitre un Soleil a cote de lui toutes les 6.5");
		StdDraw.text(0.5, 0.48, "Chaque soleil vous rajoute 25 soleil dans votre compteur a gauche de votre barre ");

		StdDraw.picture(0.8 , 0.37, GameWorld.repoImages + "/Jalapeno3.png", 0.07, 0.07 * Main.mult );
		StdDraw.text(0.5, 0.41, "Jalapeno : ");
		StdDraw.text(0.5, 0.38, "Il possede 200 points de vie et est disponible toute les 9sec");
		StdDraw.text(0.5, 0.35, "Il tue tout les Zombie present a sa droite quelque seconde apres etre apparu");
		StdDraw.text(0.5, 0.32, "ATTENTION A NE PAS TROP EN UTILISEZ CAR VOUS EN AVEZ 10 MAXIMUM ");


		StdDraw.text(0.5, 0.15, "POUR RETOURNEZ AU MENU PRINCIPAL CLIQUEZ SUR M");
		StdDraw.text(0.5, 0.1, "APPUYEZ SUR ENTREE POUR LANCEZ LE JEU");
		StdDraw.show();
	}
	/**
	 * Menu principal du Jeu expliquant les regles et fonctionalites 
	 */
	public static  void menu() {
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
		StdDraw.text(0.5, 0.35, "La pelle permet de supprimez une plante genante : touche 'S' ");
		StdDraw.text(0.5, 0.3, "Vous pouvez placez une Plante sur une case ou il y a un Zombie et possiblement le bloquer si il n'est pas trop loin ");

		StdDraw.text(0.5, 0.2, "POUR PLUS D'INFORMATION SUR LES PLANTES CLIQUEZ SUR P");
		StdDraw.text(0.5, 0.15, "POUR PLUS D'INFORMATION SUR LES ZOMBIES CLIQUEZ SUR Z");

		StdDraw.text(0.5, 0.1, "APPUYEZ SUR ENTREE POUR LANCEZ LE JEU");
		StdDraw.show();
	}
}
