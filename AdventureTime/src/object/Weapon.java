package object;

public class Weapon extends GameObject{
	WeaponName name;
	int power;
	
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
