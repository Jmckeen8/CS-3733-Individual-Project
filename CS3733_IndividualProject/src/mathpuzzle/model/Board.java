package mathpuzzle.model;

public class Board {
	Tile[][] tiles;   //3x3 array 
	
	public Board() {
		tiles = new Tile[3][3];
		
		tiles[0][0] = new Tile(1);
		tiles[0][1] = new Tile(4);
		tiles[0][2] = new Tile(3);
		tiles[1][0] = new Tile(7);
		tiles[1][1] = new Tile(2);
		tiles[1][2] = new Tile(5);
		tiles[2][0] = new Tile(9);
		tiles[2][1] = new Tile(8);
		tiles[2][2] = new Tile(6);
		
	}
	
	public Tile getTile(int row, int col) {
		return tiles[row][col];
	}
	
	public void setTile(int row, int col, Tile newTile) {
		tiles[row][col] = newTile;
	}
	
	public boolean validLeft(int row, int col) {   //SUBTRACT
		boolean valueToLeft = false;
		if(col!=0) {    //check to make sure we're not on the far left side
			if(tiles[row][col-1].hasValue) {
				valueToLeft = true;   //tile to left has a value
			}
		}
		
		boolean validToLeft = false;
		if(valueToLeft) {
			if(tiles[row][col-1].value - tiles[row][col].value > 0) {  //if result of subtraction is greater than 0
				validToLeft = true;   //value on the left results in a valid subtraction move
			}
		}
		
		return validToLeft;
	}
	
	public boolean validRight(int row, int col) {   //ADD
		boolean valueToRight = false;
		if(col != 2) {    //check to make sure we're not on the far right side
			if(tiles[row][col+1].hasValue) {
				valueToRight = true;   //tile to the right has a valid value
			}
		}
		return valueToRight;   //any value on right side is fine for adding
	}
	
	public boolean validUp(int row, int col) {     //MULTIPLY
		boolean valueAbove = false;
		if(row != 0) {   //check to make sure we're not in the top row
			if(tiles[row-1][col].hasValue) {
				valueAbove = true;    //tile above has a valid vale
			}
		}
		return valueAbove;   //any value above is fine for multiplying
	}
	
	public boolean validDown(int row, int col) {    //DIVIDE
		boolean valueBelow = false;
		if(row != 2) {    //check to make sure we're not in the bottom row
			if(tiles[row+1][col].hasValue) {
				valueBelow = true;   //we have a value below to work with
			}
		}
		
		boolean validBelow = false;
		if(valueBelow) {
			if(tiles[row+1][col].value % tiles[row][col].value == 0) {   //if we can evenly divide (divide remainder 0)
				validBelow = true;    //we have a valid value for division
			}
		}
		return validBelow;
	}
	
	public void resetBoard() {
		tiles[0][0] = new Tile(1);
		tiles[0][1] = new Tile(4);
		tiles[0][2] = new Tile(3);
		tiles[1][0] = new Tile(7);
		tiles[1][1] = new Tile(2);
		tiles[1][2] = new Tile(5);
		tiles[2][0] = new Tile(9);
		tiles[2][1] = new Tile(8);
		tiles[2][2] = new Tile(6);
	}
}
