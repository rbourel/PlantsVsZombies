import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import Picture.ModifyWayPicture;

/**
 * 
 * @author Rodrigue
 * @author Vincent
 * --------------------------------------------
 */
/**
 *	La Class GameWorld s'occupe du Monde que l'on va creer, c'est donc ici que va etre creez toute les variables importantes du jeu
 */
public class GameWorld {
	
	static String repoImages = "Picture";
	
	/** Money du Jeu pour acheter des Plante permettant de se defendre contre les Zombie */
	public static Integer money;
	// l'ensemble des entites, pour gerer (notamment) l'affichage
	static List<Entite> entites;
	/** Buffer de creation d'entite */
	static List<Entite> buffCreate;
	/** Buffer de suppression d'entite */
	static List<Entite> buffDelete;

	Random rand;
	/** Timer d'apparition de Zombie */
	Timer timerZombie;
	/** Timer d'apparition de Soleil */
	Timer timerSun;
	/**Timer pour eviter l'apparition de Zombie au debut */
	Timer debut;
	/** Nombre de possibilit�s de random possible pour determiner le prochain Zombie, plus le nombre est petit, plus des Zombie puissant apparaitront */
	int nbPossibZomb;

	/** Tableau d'entite pour gerez la presence de Plante sur les case du Jardin */
	public static Entite[][] plantGrid = new Plant[9][5];

	private static boolean mouseClick;
	private static int mouseX;
	private static int mouseY;
	public static int nbZombieKilled;
	public static int nbZombieSpawn;
	public static final int MAX_ZOMBIE = 50;
	public static int Timerdifficulty;


	//Pour savoir si la partie est gagnee ou pas
	public static boolean gameWon;
	// Idem pour savoir si le jeu est perdu (si le jeu n'est ni gagne ni perdu, il est en cours)
	public static boolean gameLost;

	// constructeur, il faut initialiser notre monde virtuel
	public GameWorld() {
		System.out.println(money);
		gameWon=false;
		gameLost=false;
		mouseClick = false;
		nbZombieKilled = 0;
		nbZombieSpawn = 0;
		

		// on cree les collections
		entites = new LinkedList<Entite>();
		buffCreate = new ArrayList<Entite>();
		buffDelete = new ArrayList<Entite>();
		// on rajoute une entite de demonstration
		//entites.add(new TrucQuiBouge(0, 0.5));
		//		entites.add(new ZombieDisco(8,3)); //Je fait spawner un zombie au dessus de la 4eme ligne
		//		entites.add(new BasicZombie(8,3));

		money = 950;

		timerSun = new Timer(6500);
		timerZombie = new Timer(Timerdifficulty);
		debut = new Timer(5000); //20sec sans Zombie au debut
		rand = new Random();

	}


	/**
	 * Gestion des interactions clavier avec l'utilisateur
	 * 
	 * @param key
	 *            Touche pressee par l'utilisateur
	 */
	public void processUserInput(char key) {
		key = Character.toLowerCase(key);
		switch (key) {
		case 't':
			System.out.println("Le joueur veut planter un Tournesol...");
			// TODO

			if(Tournesol.getDispo()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();

				Position p = Grid.worldToGrid(x, y);
				if(!Grid.emptyCase(p)) System.out.println("Il y a deja une plante ici");
				else {
					Position pose = Grid.emplacement(x, y);
					Entite t = new Tournesol(pose.getX(),pose.getY());
					entites.add(t);
					money -= Tournesol.getPrize();
					plantGrid[(int)p.getX()][(int)p.getY()] = t;
					System.out.println(plantGrid.toString());
				}
			}
			break;

		case 'p':
			System.out.println("Le joueur veut planter un Tire-Pois...");
			// TODO
			if(Tire_Pois.getDispo()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();

				Position p = Grid.worldToGrid(x, y);
				if(!Grid.emptyCase(p)) System.out.println("Il y a deja une plante ici");
				else {
					Position pose = Grid.emplacement(x, y);
					Entite t = new Tire_Pois(pose.getX(),pose.getY());
					entites.add(t);
					money -= Tire_Pois.getPrize();
					plantGrid[(int)p.getX()][(int)p.getY()] = t;
					System.out.println(plantGrid.toString());
				}
			}
			break;


		case 'n':
			System.out.println("Le joueur veut planter une Noix...");
			// TODO
			if(Noix.getDispo()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();

				Position p = Grid.worldToGrid(x, y);
				System.out.println(p.getX()+ "    "+ p.getY());
				if(!Grid.emptyCase(p)) System.out.println("Il y a deja une plante ici");
				else {
					Position pose = Grid.emplacement(x, y);
					Entite t = new Noix(pose.getX(),pose.getY());
					buffCreate.add(t);
					money -= Noix.getPrize();
					plantGrid[(int)p.getX()][(int)p.getY()] = t;
					System.out.println(plantGrid.toString());

				}
			}
			break;

		case 'j':
			System.out.println("Le joueur veut planter un Jalapeno...");
			// TODO
			if(Jalapeno.getDispo()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();

				Position p = Grid.worldToGrid(x, y);
				System.out.println(p.getX()+ "    "+ p.getY());
				if(!Grid.emptyCase(p)) System.out.println("Il y a deja une plante ici");
				else {
					Position pose = Grid.emplacement(x, y);
					Entite t = new Jalapeno(pose.getX(),pose.getY());
					buffCreate.add(t);
					money -= Jalapeno.getPrize();
					plantGrid[(int)p.getX()][(int)p.getY()] = t;

				}
			}
			break;
			
		case 'c':
			System.out.println("Le joueur veut planter un Cold_Tire-Pois...");
			// TODO
			if(Cold_TirePois.getDispo()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();

				Position p = Grid.worldToGrid(x, y);
				if(!Grid.emptyCase(p)) System.out.println("Il y a deja une plante ici");
				else {
					Position pose = Grid.emplacement(x, y);
					Entite t = new Cold_TirePois(pose.getX(),pose.getY());
					entites.add(t);
					money-= Cold_TirePois.getPrize();
					plantGrid[(int)p.getX()][(int)p.getY()] = t;
					System.out.println(plantGrid.toString());
				}
			}
			break;

		case 's':
			System.out.println("Le joueur veut supprimer un element...");
			// TODO
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();

			Position p = Grid.worldToGrid(x, y);
			if(Grid.emptyCase(p)) System.out.println("Il n'y a pas de plante ici");
			else {
				Entite t = plantGrid[(int)p.getX()][(int)p.getY()];
				buffDelete.add(t);
				System.out.println(buffDelete.toString());
				plantGrid[(int)p.getX()][(int)p.getY()] = null; 
			}

			break;



		default:
			System.out.println("Touche non prise en charge");
			break;
		}	
	}
	/**
	 * 
	 * @return true ssi l'utilisateur � fait un clique droit dans l'interface
	 */
	public static boolean isMouseClick() {
		return mouseClick;
	}
	public static void setMouseClick(boolean mouseClic) {
		mouseClick = mouseClick;
	}
	public static int getMouseX() {
		return mouseX;
	}

	public static int getMouseY() {
		return mouseY;
	}


	public void refreshSoleils()
	{
		if (timerSun.hasFinished()) {
			int x = rand.nextInt(8);
			int y = rand.nextInt(4);
			buffCreate.add(new Sun(x, y));
			timerSun.restart();
		}
	}
	
	public void setDifficulty() {
		if(nbZombieKilled < 10) {
			nbPossibZomb = 15;
			Timerdifficulty = 10000;
		}
		if(nbZombieKilled > 9 && nbZombieKilled < 20) {
			nbPossibZomb = 12;
			Timerdifficulty = 8000;
		}
		if(nbZombieKilled > 19 && nbZombieKilled < 30) {
			nbPossibZomb = 10;
			Timerdifficulty = 6000;
		}
		if(nbZombieKilled > 29 && nbZombieKilled < 40) {
			nbPossibZomb = 8;
			Timerdifficulty = 4000;
		}
		if(nbZombieKilled > 39) {
			nbPossibZomb = 1;
			Timerdifficulty = 2000;
		}
		
	}
	
	//A FAIRE
	//Reduire le temps de Timer tout les 10Zombie Tues
	//Reduire les randInt type avec le temps pour avoir des Zombie plus puissant
	public void refreshZombie() {
		if(debut.hasFinished() && nbZombieSpawn < MAX_ZOMBIE) {
			if(timerZombie.hasFinished()) {
				setDifficulty();
				timerZombie = new Timer(Timerdifficulty);
				int y = rand.nextInt(5);
				System.out.println("y = " + y);
				int type = rand.nextInt(nbPossibZomb)+1;
				System.out.println("type numero : " + type);
				if(type > 1 && type < 5 )
					buffCreate.add(new ArmorZombie(8,y));		
				else if(type == 1 ) {
					buffCreate.add(new ZombieDisco(8,y));
					
				}
				else 
					buffCreate.add(new BasicZombie(8,y));
						
				System.out.println("New Zombie en ligne : " + y);
				timerZombie = new Timer(Timerdifficulty);
				nbZombieSpawn ++;
				System.out.println(nbZombieSpawn);
			}
		}
	}


	/**
	 * Gestion des interactions souris avec l'utilisateur (la souris a été cliquée)
	 * 
	 * @param x position en x de la souris au moment du clic
	 * @param y position en y de la souris au moment du clic
	 */
	public void processMouseClick(double x, double y) {
		mouseX = (int)(x * Grid.NB_CASE_X * 1/Grid.MaxHaut.getX());
		mouseY = (int)(y * Grid.NB_CASE_Y * 1/Grid.MaxHaut.getY());
		mouseClick = true;
		System.out.println("La souris a ete cliquee en : " + x + " - " + y + "    " +  mouseX + " - " + mouseY);

		System.out.println(mouseClick);

	}


	// on fait bouger/agir toutes les entites
	public void step() {
		for (Entite entite : GameWorld.entites)
			entite.step();
		refresh();
		buffCreate.clear();
	}

	public void refresh() {
		//System.out.println(buffCreate.toString());


		if(!buffCreate.isEmpty()) {
			for(Entite e : buffCreate) 
				entites.add(e);
		}
		if(!buffDelete.isEmpty()) {
			for(Entite e : buffDelete) {
				entites.remove(e);
			}
		}

		buffCreate.clear();
		//System.out.println(buffCreate.toString());
		buffDelete.clear();
	}

	// dessine les entites du jeu
	public void dessine() {

		// Ici vous pouvez afficher du décors 		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0.5, 0.5, 1, 1);
		StdDraw.picture(Grid.MaxHaut.getX()/2, Grid.MaxHaut.getY()/2,repoImages + "/jardin.png",Grid.MaxHaut.getX(), Grid.MaxHaut.getY());
		
		//Marqueur de position actuel
		double moX = StdDraw.mouseX();
		double moY = StdDraw.mouseY();
		Position p = Grid.emplacement(moX, moY);
		if(p.getY() < Grid.MaxHaut.getY()) {
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.rectangle(p.getX(),p.getY(),
					Grid.CASE_SIZE_X/2, Grid.CASE_SIZE_Y/2);
		}

		// affiche les entites
		for (Entite entite : entites)
			entite.dessine();

		double x = 0.05;
		double y = 0.92;

		StdDraw.picture(x * 1 , y, GameWorld.repoImages + "/sun.png" , (1-y)/2, (1-y)/2 * Main.mult);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x*1, y - 0.07, Integer.toString(money));  


		if (Tournesol.getDispo()) {
			StdDraw.picture(x * 3 , y, GameWorld.repoImages + "/HD_Sunflower.png" , (1-y)/2, (1-y)/2 * Main.mult);
		} else 
			StdDraw.picture(x * 3, y, GameWorld.repoImages + "/NoTournesol.png", (1-y)/2, (1-y)/2 * Main.mult );
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x*3, y - 0.07, Integer.toString(Tournesol.getPrize())); 
		StdDraw.text(x*3, y - 0.1, "touche : T");

		if (Tire_Pois.getDispo()) {
			StdDraw.picture(x * 5 , y, GameWorld.repoImages + "/tire pois.png" , (1-y)/2, (1-y)/2 * Main.mult);
		} else 
			StdDraw.picture(x * 5, y, GameWorld.repoImages + "/Notirepois.png", (1-y)/2, (1-y)/2 * Main.mult );
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x*5, y - 0.07, Integer.toString(Tire_Pois.getPrize())); 
		StdDraw.text(x*5, y - 0.1, "touche : P");

		if (Noix.getDispo()) {
			StdDraw.picture(x * 7 , y, GameWorld.repoImages + "/noix.png" , (1-y)/1.5, (1-y)/1.5 * Main.mult);
		} else 
			StdDraw.picture(x * 7, y, GameWorld.repoImages + "/noixGrise.png", (1-y)/1.5, (1-y)/1.5 * Main.mult );
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x*7, y - 0.07, Integer.toString(Noix.getPrize())); 
		StdDraw.text(x*7, y - 0.1, "touche : N");

		if (Jalapeno.getDispo()) {
			StdDraw.picture(x * 9 , y,GameWorld.repoImages + "/Jalapeno3.png" , (1-y)/1.5, (1-y)/1.5 * Main.mult);
		} else 
			StdDraw.picture(x * 9, y, GameWorld.repoImages + "/NoJalapeno.png", (1-y)/1.5, (1-y)/1.5 * Main.mult );
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x*9, y - 0.07, Integer.toString(Jalapeno.getPrize())); 
		StdDraw.text(x*9, y - 0.1, "touche : J");
		
		if (Cold_TirePois.getDispo()) {
			StdDraw.picture(x * 11 , y, GameWorld.repoImages + "/ColdTirePois.png" , (1-y)/1.5, (1-y)/1.5 * Main.mult);
		} else 
			StdDraw.picture(x * 11, y, GameWorld.repoImages + "/NoColdTirePois.png", (1-y)/1.5, (1-y)/1.5 * Main.mult );
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x*11, y - 0.07, Integer.toString(Cold_TirePois.getPrize())); 
		StdDraw.text(x*11, y - 0.1, "touche : C");

		StdDraw.picture(x * 13 , y, GameWorld.repoImages + "/pelle.png" , (1-y)/2, (1-y)/2 * Main.mult);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x*13, y - 0.05, "'s' to delete");
		StdDraw.text(x*13, y - 0.07, "one of your plant");

		StdDraw.text(0.93, 0.95, "Zombies tues : " + Integer.toString(nbZombieKilled));
	}



	public static boolean gameWon() {
		if(nbZombieKilled == MAX_ZOMBIE) gameWon = true;
		return gameWon;
	}

	public static boolean gameLost() {
		return gameLost;
	}


}
