package mathpuzzle.model;

public class Tile {
	int value;
	boolean hasValue;
	boolean finalWinner;
	
	
	public Tile(int value) {
		this.value = value;
		this.hasValue = true;
		this.finalWinner = false;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue (int value) {
		this.value = value;
	}
	
	public boolean isHasValue() {
		return hasValue;
	}
	
	public void setHasValue(boolean flag) {
		hasValue = flag;
	}
	
	public boolean isFinalWinner() {
		return finalWinner;
	}
	
	public void setFinalWinner(boolean flag) {
		finalWinner = flag;
	}
	
}
