package entity;
/**
 * classe che rappresenta un'entita
 * 
 *
 */
public class Entity {
	private int[] coord;//coordinate entita
	private char symbol;//simbolo entita
	
	public Entity(int[] coord, char symbol) {
		this.coord = coord;
		this.symbol = symbol;
	}

	public int[] getCoord() {
		return coord;
	}
	
	
	public void setCoord(int[] coord) {
		this.coord = coord;
	}

	public char getSymbol() {
		return symbol;
	}
	
	

}
