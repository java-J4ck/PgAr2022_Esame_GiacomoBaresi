package map;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


import entity.*;
import main.InputDati;
import randomGeneration.MonsterGenerator;
/**
 * classe che preleva tutte le entita dal file xml
 * 
 *
 */
public class EntitiesExtractor {
	
	private ArrayList<Monster> allMonster= new ArrayList<Monster>();//mostri
	private ArrayList<Chest> allchest = new ArrayList<Chest>();//ceste
	private ArrayList<Entity> allWall = new ArrayList<Entity>();//muri
	private Player player;//giocatore
	private File fromFile;
	private XMLInputFactory xmlif = null;
	private XMLStreamReader xmlr = null;
	private int mapHeight;
	private int mapWidth;
	private String fileName;
	
	public EntitiesExtractor(String fileName,File fromFile) {//si sceglie il file
		
		this.fromFile = fromFile;
		extractEntities();
		
	}
	
	private void  extractEntities() {
		initialization();
		int x=-1,y=-1;
		String name="";
		String text="";
		MonsterGenerator m= new MonsterGenerator("dijkstra");
		try {
			while (xmlr.hasNext()) { 
				 switch (xmlr.getEventType()) { 
					 case XMLStreamConstants.START_ELEMENT: //dall'elemento iniziale si prendono le dimensioni della mappa
						 name=xmlr.getLocalName();
						 if(name.equals("mappa")) {
							 mapHeight = Integer.parseInt(xmlr.getAttributeValue(0));
							 mapWidth = Integer.parseInt(xmlr.getAttributeValue(1));
						 }
						 else if(name.equals("row"))  {
							 y++;
							 x=0;
						 }
						 break;
					 case XMLStreamConstants.END_ELEMENT:   
						    if (name.equals("cell")) x++;
							break;
					 case XMLStreamConstants.CHARACTERS: //dalle celle si prende l'entita
						 if (name.equals("cell") && xmlr.getText().trim().length() > 0) {
							 text=xmlr.getText();
							 if(text.charAt(0)=='M') {//se l'entita è un mostro si crea un mostro 
								 int[] coord= {x,y};
								 allMonster.add(m.monsterGenerator(coord));
								 
							 }
							 else if(text.charAt(0)=='C') {// se è una chest si crea una chest
								 int[] coord= {x,y};
								 allchest.add(new Chest(coord,'C'));
							
							 }
							 else if(text.charAt(0)=='#') {// se è un muro si crea un muro
								 int[] coord= {x,y};
								 allWall.add(new Entity(coord,'#'));
								
							 }
							 //else if(text.charAt(0)=='P') ;
							 else if(text.charAt(0)=='O') {// se è il giocatore si crea il giocatore
								 int[] coord= {x,y};
								 player=new Player(coord,'O',InputDati.leggiStringaNonVuota("inserisci un nome per il tuo personaggio: "));;
							 }
						 }
						 
						 break;
					 }

					 xmlr.next();
				}
		} 
		catch (XMLStreamException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				xmlr.close();// si chiude il file
			} catch (XMLStreamException e) {
				System.out.println("unable to close XML file");
			}
		}
	}
	
	
	private void initialization() {//inizializzazione per la lettura
		
		try {
		 xmlif = XMLInputFactory.newInstance();
		 xmlr = xmlif.createXMLStreamReader(fileName, new FileInputStream(fromFile));
		} catch (Exception e) {
		 System.out.println("Errore nell'inizializzazione del reader:");
		 System.out.println(e.getMessage());
		}
	}

	
	
	
	public ArrayList<Monster> getAllMonster() {
		return allMonster;
	}

	public ArrayList<Chest> getAllchest() {
		return allchest;
	}

	public ArrayList<Entity> getAllWall() {
		return allWall;
	}

	public Player getPlayer() {
		return player;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public int getMapWidth() {
		return mapWidth;
	}
	
	
	
}
