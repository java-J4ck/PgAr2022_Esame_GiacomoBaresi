package map;

import entity.Chest;
import entity.Entity;
import entity.Monster;
import entity.Player;

public class MapManager {
	private char[][] map;
	private int mapWidth;
	private int mapHeight;
	
	
	
	
	public MapManager(EntitiesExtractor e){
		this.mapHeight=e.getMapHeight();
		this.mapWidth=e.getMapWidth();
		map= new char[mapHeight][mapWidth];
		Player p=e.getPlayer();
		map[p.getCoord()[0]][p.getCoord()[1]]='O';
		for(Monster m : e.getAllMonster()) map[m.getCoord()[0]][m.getCoord()[1]]='M';
		for(Chest c : e.getAllchest()) map[c.getCoord()[0]][c.getCoord()[1]]='C';
		for(Entity m : e.getAllWall()) map[m.getCoord()[0]][m.getCoord()[1]]='#';
		for(int i=0;i<mapHeight;i++) {
			for(int j=0;j<mapWidth;j++) {
				if(map[i][j]=='\0') map[i][j]='.';
			}
		}
	}
	
	public String visulizeMap() {
		StringBuffer map_string= new StringBuffer("");
		for(int i=0;i<mapHeight;i++) {
			for(int j=0;j<mapWidth;j++) {
				map_string.append(map[i][j]);
			}
			map_string.append("\n");
		}
		return map_string.toString();
	}
	
	
	
}
