package object;
/**
 * classe che rappresenta uno scudo
 * @author Giaco
 *
 */
public class Shield extends GameObject {
	private int hp=5;
	
	
	
	public Shield(ObjType type) {
		super(type);
	}

	public int getHp() {
		return hp;
	}
	
	public void Damage(int damage) {
		this.hp -= damage;
	}
	
	public boolean isBroken() {// dice se lo scudo si è rotto
		if(hp<=0) return true;
		return false;
	}
	

}
