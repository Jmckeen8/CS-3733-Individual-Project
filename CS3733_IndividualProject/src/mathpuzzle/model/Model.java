package mathpuzzle.model;

public class Model {
	
	Tile selectedTile;
	int selectedRow;
	int selectedCol;
	
	boolean gameWon;
	
	Board board;
	
	public Model() {
		board = new Board();
		
		selectedTile = board.getTile(0, 0);
		
		gameWon = false;
	}

	
	public Tile getSelectedTile() {
		return selectedTile;
	}
	
	public void setSelectedTile(Tile newTile) {
		selectedTile = newTile;
	}

	public boolean isGameWon() {
		return gameWon;
	}

	public void setGameWon(boolean gameWon) {
		this.gameWon = gameWon;
	}

	public Board getBoard() {
		return board;
	}
	
	public void setSelectedLoc(int row, int col) {
		selectedRow = row;
		selectedCol = col;
	}
	
	public int getSelectedRow() {
		return selectedRow;
	}
	
	public int getSelectedCol() {
		return selectedCol;
	}

}
