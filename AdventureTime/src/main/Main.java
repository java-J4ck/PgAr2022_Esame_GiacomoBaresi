package main;

import java.io.File;


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
	public static void main(String[] args) {
		System.out.println(TITLE);
		System.out.println("benvenuto in adventure time! iniziamo a giocare");
		EntitiesExtractor lol= new EntitiesExtractor("livello1",new File("livelli\\livello1.xml"));
		MapManager lvl1= new MapManager(lol);
		System.out.println(lvl1.visulizeMap());
		
	}

}
