package main;

import java.io.File;

import entity.Player;
import map.EntitiesExtractor;
import map.MapManager;

public class Main {
	private static final String TITLE="\r\n"
			+ "                                                                                                                        \r\n"
			+ "  ,---.  ,------.,--.   ,--.,------.,--.  ,--.,--------.,--. ,--.,------. ,------.    ,--------.,--.,--.   ,--.,------. \r\n"
			+ " /  O  \\ |  .-.  \\\\  `.'  / |  .---'|  ,'.|  |'--.  .--'|  | |  ||  .--. '|  .---'    '--.  .--'|  ||   `.'   ||  .---' \r\n"
			+ "|  .-.  ||  |  \\  :\\     /  |  `--, |  |' '  |   |  |   |  | |  ||  '--'.'|  `--,        |  |   |  ||  |'.'|  ||  `--,  \r\n"
			+ "|  | |  ||  '--'  / \\   /   |  `---.|  | `   |   |  |   '  '-'  '|  |\\  \\ |  `---.       |  |   |  ||  |   |  ||  `---. \r\n"
			+ "`--' `--'`-------'   `-'    `------'`--'  `--'   `--'    `-----' `--' '--'`------'       `--'   `--'`--'   `--'`------' \r\n"
			+ "                                                                                                                        \r\n"
			+ "";
	
	private static final String[] WORDS= {"muoviti","statistiche"};
	
	public static void main(String[] args) {
		System.out.println(TITLE);
		System.out.println("benvenuto in adventure time! iniziamo a giocare".toUpperCase());
		EntitiesExtractor entities= new EntitiesExtractor("livello1",new File("livelli\\livello1.xml"));
		MapManager lvl1= new MapManager(entities);
		Player player = entities.getPlayer();
		//System.out.println(lvl1.visulizeMap());
		MyMenu mainMenu = new MyMenu("qual'e la tua prossima mossa?",WORDS);
		int scelta;
		while(!player.isDead()) {
			System.out.println(lvl1.visulizeMap());
			scelta=mainMenu.scegli();
			
			switch(scelta) {
			 	case 0:
			 		System.out.println("GRAZIE PER AVER GIOCATO");
			 		System.exit(0);
				case 1:
					lvl1.playerMovement(InputDati.leggiChar("inserisci comando(WASD): "));
					break;
				
				default:
					
				
			}
			
		}
		
		System.out.println("GRAZIE PER AVER GIOCATO");
		
	}




	public static void movement(MapManager m) {
		
		
		
	}
}
