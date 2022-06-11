package entity;

import object.Weapon;

public class Monster  extends Entity{
	private String name;
	private int hp;//punti vita di default
	private int attck = 5;//attacco di default
	private int def = 5;//difesa di default
	private  Weapon Mweapon=null;//arma del mostro
	
	public Monster(int[] coord, char symbol, String name, int hp, Weapon mweapon) {
		super(coord, symbol);
		this.name = name;
		this.hp = hp;
		Mweapon = mweapon;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public int getAttck() {
		return attck;
	}

	public int getDef() {
		return def;
	}

	public Weapon getMweapon() {
		return Mweapon;
	}
	
	
	
	

}
