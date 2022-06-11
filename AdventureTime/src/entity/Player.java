package entity;

import java.util.ArrayList;

import object.GameObject;
import object.Weapon;

public class Player extends Entity {
	private String name;
	private int hp = 20;//punti vita di default
	private int attck = 5;//attacco di default
	private int def = 5;//difesa di default
	private  GameObject object=null;
	
	public static class Inventario{
		ArrayList<Weapon> allWeapon=new ArrayList<Weapon>();
		
	}
	
	
	public void setHp(int hp) {
		this.hp = hp;
	}



	public Player(int[] coord, char symbol, String name) {
		super(coord, symbol);
		this.name = name;
	}

	
	
	public GameObject getObject() {
		return object;
	}



	public void setObject(GameObject object) {
		this.object = object;
	}



	public String getName() {
		return name;
	}


	public int getHp() {
		return hp;
	}


	public int getAttck() {
		return attck;
	}


	public int getDef() {
		return def;
	}
	
	public boolean isDead() {
		if(hp<=0) return true;
		return false;
	}
	
	

}
