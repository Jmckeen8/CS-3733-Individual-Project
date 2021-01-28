package mathpuzzle.controller;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Board;
import mathpuzzle.model.Model;

public class LoseController {

	Model model;
	MathPuzzleApp app;
	
	public LoseController(Model m, MathPuzzleApp a) {
		model = m;
		app = a;
	}
	
	public void process() {
		boolean anyValidMoves = false;   //assume there aren't any valid moves
		
		Board board = model.getBoard();
		
		for(int row = 0; row <= 2; row++) {         //loop through every tile
			for(int col = 0; col <= 2; col++) {
				if(board.getTile(row, col).isHasValue()) {   //if the tile has a value
					if(board.validRight(row, col) || board.validLeft(row, col) || board.validUp(row, col) || board.validDown(row, col)) {
						anyValidMoves = true;   //if a tile has any valid move in any direction, the user hasn't lost yet
					}
				}
			}
		}
		//we have now checked all tiles and OuterTilesEmpty and innerTileValue are set
		if(anyValidMoves == false && model.isGameWon()==false) {   //if there aren't any valid moves and the game hasn't been won
			app.endOfGameAnnouncer.setText("There aren't any more valid moves. You have lost :( Click Reset to start again or Quit to quit the app");
		}
		app.repaint();
	}
}
