package main;

import java.io.File;

import entity.Player;
import map.EntitiesExtractor;
import map.MapManager;

public class Main {

	public static void main(String[] args) {
		
		EntitiesExtractor lol= new EntitiesExtractor("livello1",new File("livelli\\livello1.xml"));
		MapManager lvl1= new MapManager(lol);
		System.out.println(lvl1.visulizeMap());
		
	}

}
