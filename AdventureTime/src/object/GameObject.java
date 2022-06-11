package object;
/**
 * classe che rappresenta un oggetto di gioco generico
 * 
 *
 */
public class GameObject {
	private ObjType type;//tipo dell'oggetto

	public GameObject(ObjType type) {
		this.type = type;
	}

	public ObjType getType() {
		return type;
	}
	
	
	
	
}
