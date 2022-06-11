package BattleManager;

import java.util.Random;

import entity.Entity;
import entity.Monster;
import entity.Player;
import object.ObjType;
import object.Weapon;

/**
 * classe che gestisce la battaglia
 * 
 *
 */
public class Battle {
	public static void battle(Player p, Monster m) {
		while(!p.isDead() && !m.isDead()) {//si infliggono danni finche uno muore
			m.Damage(getDamage(p));
			if(m.isDead()) break;
			p.Damage(getDamage(m));
		}
	}
	
	/**
	 * classe che restituisce il danno causato da un'entita
	 * @param e
	 * 
	 */
	private static int getDamage(Entity e) {
		int damage=0;
		if(e instanceof Monster) {
			Monster m=(Monster) e;
			if(m.getMweapon() == null) {//si controlla se il mostro ha un' arma
				damage=(int)(((2*m.getAttck()/25*m.getDef())+2)*isThereModifier());
				System.out.println(String.format("[!]il mostro %s colpisce con %d di danno usando il pugno", m.getName(),damage));
				return damage;
			}
			else {//danno in caso abbia un'arma
				damage=(int)(((2*m.getAttck()*m.getMweapon().getPower()/25*m.getDef())+2)*isThereModifier());
				System.out.println(String.format("[!]il mostro %s colpisce con %d di danno usando %s", m.getName(),damage,m.getMweapon().getName().name()));
				return damage;
			}
		}
		else {//stessa cosa se l'entita e il giocatore
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
	/**
	 * ritorna il modificatore con una probabilita di 75/1000 ovvero 7.5%
	 * 
	 */
	private static  double isThereModifier() {
		if(randInt(0, 1000)<=75) return 1.5;
		return 1;
	}
	
	public static int randInt(int min, int max) {//genera numeri casuali

	    Random rand= new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
