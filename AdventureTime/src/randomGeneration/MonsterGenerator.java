package randomGeneration;


import java.util.Random;

import entity.Monster;
/**
 * classe che generaa un mostro in modo casuale
 * 
 *
 */
public class MonsterGenerator {
	
	private String stringToPermute;
	
	
	public MonsterGenerator(String stringToPermute) {
		this.stringToPermute = stringToPermute;
	}

	public Monster monsterGenerator(int[] coord) {
		return new Monster(coord,'M',permutation(),randInt(15, 25),WeaponGenerator.getWeapon());
		
		
	}
	
	private String permutation() {//genera una permutazione randomica di stringToPermute
		String s=stringToPermute;
		String finalPermutation="";
		int rand;
		while(s.length()>0) {
			finalPermutation+=s.charAt(rand=randInt(0, s.length()-1));
			s=s.substring(0,rand)+s.substring(rand+1,s.length());
		}
		return finalPermutation;
	}
	
	
	
	public static int randInt(int min, int max) {//genera numeri casuali

	    Random rand= new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	
}
