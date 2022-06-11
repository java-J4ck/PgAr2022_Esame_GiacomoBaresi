package map;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


import entity.Chest;
import entity.Entity;
import entity.Monster;
import entity.Player;

public class EntitiesExtractor {
	
	private ArrayList<Monster> allMonster;
	private ArrayList<Chest> allchest;
	private ArrayList<Entity> allWall;
	private Player player;
	private File fromFile;
	private XMLInputFactory xmlif = null;
	private XMLStreamReader xmlr = null;
	private int mapHeight;
	private int mapWidth;
	private String fileName;
	
	public EntitiesExtractor(String fileName,File fromFile) {
		
		this.fromFile = fromFile;
		extractEntities();
		
	}
	
	private void  extractEntities() {
		initialization();
		int x=-1,y=-1;
		String name="";
		String text="";
		try {
			while (xmlr.hasNext()) { 
				 switch (xmlr.getEventType()) { 
					 case XMLStreamConstants.START_ELEMENT: 
						 name=xmlr.getLocalName();
						 if(name.equals("mappa")) {
							 mapHeight = Integer.parseInt(xmlr.getAttributeValue(0));
							 mapWidth = Integer.parseInt(xmlr.getAttributeValue(1));
						 }
						 else if(name.equals("row"))  y++;
						 break;
					 case XMLStreamConstants.CHARACTERS: 
						 if (name.equals("cell")) {
							 x++;
							 text=xmlr.getText();
							 if(text.charAt(0)=='M') ;
							 else if(text.charAt(0)=='#') ;
							 //else if(text.charAt(0)=='P') ;
							 else if(text.charAt(0)=='O') ;
						 }
						 
						 break;
					 }

					 xmlr.next();
				}
		} 
		catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
				xmlr.close();
			} catch (XMLStreamException e) {
				System.out.println("unable to close XML file");
			}
		}
	}
	
	private void initialization() {
		
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
