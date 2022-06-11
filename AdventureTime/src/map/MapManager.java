package map;

import java.util.ArrayList;

import entity.*;

/**
 * classe che gestisce la mappa e gli spostamenti
 * 
 *
 */
public class MapManager {
	private char[][] map;
	private int mapWidth;
	private int mapHeight;
	private ArrayList<Monster> allMonster= new ArrayList<Monster>();
	private ArrayList<Chest> allchest = new ArrayList<Chest>();
	private ArrayList<Entity> allWall = new ArrayList<Entity>();
	private Player player;
	
	/**
	 * con i dati estratti  crea la mappa
	 * 
	 */
	public MapManager(EntitiesExtractor e){
		this.mapHeight=e.getMapHeight();
		this.mapWidth=e.getMapWidth();
		this.allMonster=e.getAllMonster();
		this.allchest=e.getAllchest();
		this.allWall=e.getAllWall();
		this.player=e.getPlayer();
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
	
	/**
	 * visualizza la mappa
	 * 
	 */
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
	/**
	 * sposta il giocatore con WASD
	 * ritorna falso se la casella dove si vuole andare è inaccessibile
	 * 
	 */
	public boolean playerMovement(char command) {
		int[] coord = player.getCoord().clone();
		if(command=='A') {
			coord[1]--;
			if(checkArrive(coord)) {
				player.setCoord(coord);
				map[coord[0]][coord[1]]='O';
				map[coord[0]][coord[1]+1]='.';
			}
			else return false;
		}
		if(command=='D') {
			coord[1]++;
			if(checkArrive(coord)) {
				player.setCoord(coord);
				map[coord[0]][coord[1]]='O';
				map[coord[0]][coord[1]-1]='.';
			}
			else return false;
		}
		if(command=='S') {
			coord[0]++;
			if(checkArrive(coord)) {
				player.setCoord(coord);
				map[coord[0]][coord[1]]='O';
				map[coord[0]-1][coord[1]]='.';
			}
			else return false;
		}
		if(command=='W') {
			coord[0]--;
			if(checkArrive(coord)) {
				player.setCoord(coord);
				map[coord[0]][coord[1]]='O';
				map[coord[0]+1][coord[1]]='.';
			}
			else return false;
		}
		
		return true;
		
	}
	
	private boolean checkArrive(int[] coord) {//controlla se la casella è accessibile
		if(coord[0]>=mapHeight | coord[0]<0) return false;
		if(coord[1]>=mapWidth | coord[1]<0) return false;
		if(map[coord[0]][coord[1]]=='#') return false;
		return true;
	}
	
	public void checkBattle() {//una volta spostati si controlla se c'è una battaglia
		for(Monster m : allMonster) {
			if(m.getCoord()==player.getCoord()) {//se le coordinate di un mostro sono le stesse del giocatore allora c'è una battaglia
				BattleManager.Battle.battle(player, m);
				if(m.isDead()) allMonster.remove(m);//se è morto il mostro rimuove m
				break;
			}
		}
	}
	
}
