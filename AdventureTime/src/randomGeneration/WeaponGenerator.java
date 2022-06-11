package randomGeneration;

import java.util.Random;

import object.ObjType;
import object.Weapon;
import object.WeaponName;

public class WeaponGenerator {
	public static Weapon getWeapon() {
		ObjType t=ObjType.WEAPON;
		int power=randInt(35,55);
		if(power<=37) return new Weapon(t,WeaponName.SPADA_MARCIA,power);
		else if(power<=40) return new Weapon(t,WeaponName.SPADA_ADAMANTIO,power);
		else if(power<=43) return new Weapon(t,WeaponName.CLAVA_MOSTRO,power);
		else if(power<=45) return new Weapon(t,WeaponName.ARCO_MOSTRUOSO,power);
		else if(power<=47) return new Weapon(t,WeaponName.CARABINA_LUCENTE,power);
		else if(power<=49) return new Weapon(t,WeaponName.REVOLVER_ARNALDO,power);
		else if(power<=53) return new Weapon(t,WeaponName.LANCIA_GRANATE,power);
		else  return new Weapon(t,WeaponName.CANNONE_P,power);
		
	}
	
	
	public static int randInt(int min, int max) {

	    Random rand= new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
