package object;
//tutte le armi disponibili
public enum WeaponName {
	SPADA_MARCIA("spada marcia"),
	SPADA_ADAMANTIO("spada di adamantio"),
	CARABINA_LUCENTE("carabina lucente"),
	CLAVA_MOSTRO("clava mostro"),
	LANCIA_GRANATE("lancia granate"),
	REVOLVER_ARNALDO("revolver arnaldo"),
	ARCO_MOSTRUOSO("arco mostruoso"),
	CANNONE_P("cannone planetarium"),
	CECCHINO_D("fucile di precisione di dijkstra");//arma del boss
	
	
	private String name;

	private WeaponName(String name) {
		this.name = name;
	}
	
	
	
	
}
