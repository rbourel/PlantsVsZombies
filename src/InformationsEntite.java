
public class InformationsEntite {
	public InformationsEntite() {
		
	}
	public static void afficheInfoZ() {
		double x = 0.05;
		double y = 0.92;
		
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
		
		
		StdDraw.text(0.5, 0.1, "FAITES ALT F4 pour relancez le jeu");
		StdDraw.show();
	}
}
