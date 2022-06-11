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
		System.out.println(TITLE);// stampa il titolo
		System.out.println("benvenuto in adventure time! iniziamo a giocare".toUpperCase());
		EntitiesExtractor entities= new EntitiesExtractor("livello1",new File("livelli\\livello1.xml"));//si sceglie il file xml e si estraggono le informazioni
		MapManager lvl1= new MapManager(entities);//si crea il manager di mappa
		Player player = entities.getPlayer();// si prende il giocatore
		//System.out.println(lvl1.visulizeMap());
		MyMenu mainMenu = new MyMenu("qual'e la tua prossima mossa?",WORDS);
		int scelta;
		while(!player.isDead()) {// finche non siamo morti
			System.out.println(lvl1.visulizeMap());// stampa la mappa
			scelta=mainMenu.scegli();//scelta dal menu
			
			switch(scelta) {
			 	case 0://uscita 
			 		System.out.println("GRAZIE PER AVER GIOCATO");
			 		System.exit(0);
				case 1://stampa il movimento
					if(!lvl1.playerMovement(InputDati.leggiChar("inserisci comando(WASD): ")))
						System.out.println("NON SI PUO ANDARE IN QUELLA CASELLA! :-( ");
					else lvl1.checkBattle();
					break;
				
				default:
					
				
			}
			
		}
		if(player.isDead())System.out.println("SEI MORTO\n");
		System.out.println("GRAZIE PER AVER GIOCATO");
		
	}




	
}
