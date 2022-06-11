package map;


import java.util.Random;

import entity.Monster;

public class MonsterGenerator {
	
	private String stringToPermute;
	
	
	public MonsterGenerator(String stringToPermute) {
		this.stringToPermute = stringToPermute;
	}

	public Monster monsterGenerator(int[] coord) {
		return new Monster(coord,'M',permutation(),randInt(15, 25),null);
		
		
	}
	
	private String permutation() {
		String s=stringToPermute;
		String finalPermutation="";
		int rand;
		while(s.length()>0) {
			finalPermutation+=s.charAt(rand=randInt(0, s.length()-1));
			s.replace(s.charAt(rand), '\0');
		}
		return finalPermutation;
	}
	
	
	
	public static int randInt(int min, int max) {

	    Random rand= new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	
}
