package BattleManager;

import java.util.Random;

import entity.Entity;
import entity.Monster;
import entity.Player;
import object.ObjType;
import object.Weapon;

public class Battle {
	public static void battle(Player p, Monster m) {
		while(!p.isDead() && !m.isDead()) {
			m.Damage(getDamage(p));
			p.Damage(getDamage(m));
		}
	}
	
	private static int getDamage(Entity e) {
		int damage=0;
		if(e instanceof Monster) {
			Monster m=(Monster) e;
			if(m.getMweapon() == null) {
				damage=(int)(((2*m.getAttck()/25*m.getDef())+2)*isThereModifier());
				System.out.println(String.format("[!]il mostro %s colpisce con %d di danno usando il pugno", m.getName(),damage));
				return damage;
			}
			else {
				damage=(int)(((2*m.getAttck()*m.getMweapon().getPower()/25*m.getDef())+2)*isThereModifier());
				System.out.println(String.format("[!]il mostro %s colpisce con %d di danno usando %s", m.getName(),damage,m.getMweapon().getName().name()));
				return damage;
			}
		}
		else {
			Player p=(Player) e;
			if(p.getObject().getType() == null | p.getObject().getType() != ObjType.WEAPON ) {
				damage=(int)(((2*p.getAttck()/25*p.getDef())+2)*isThereModifier());
				System.out.println(String.format("[!] %s colpisce con %d di danno usando il pugno", p.getName(),damage));
				return damage;
			}
			else {
				Weapon w=(Weapon) p.getObject();
				damage=(int)(((2*p.getAttck()*w.getPower()/25*p.getDef())+2)*isThereModifier());
				System.out.println(String.format("[!] %s colpisce con %d di danno usando %s", p.getName(),damage,w.getName().name()));
				return damage;
			}
		}
	}
	
	private static  double isThereModifier() {
		if(randInt(0, 1000)<=75) return 1.5;
		return 1;
	}
	
	public static int randInt(int min, int max) {

	    Random rand= new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
