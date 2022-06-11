package object;
/**
 * classe che rappresenta un arma
 * @author Giaco
 *
 */
public class Weapon extends GameObject{
	WeaponName name;// tipo di arma
	int power;// potenza dell'arma
	
	public Weapon(ObjType type, WeaponName name, int power) {
		super(type);
		this.name = name;
		this.power = power;
	}

	public WeaponName getName() {
		return name;
	}

	public int getPower() {
		return power;
	}
	
	
}
