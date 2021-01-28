package mathpuzzle.controller;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;
import mathpuzzle.model.Tile;

public class WinController {
	
	Model model;
	MathPuzzleApp app;
	
	public WinController(Model m, MathPuzzleApp a) {
		model = m;
		app = a;
	}
	
	public void process() {
		boolean outerTilesEmpty = true;  //assume all outer tiles are empty
		boolean innerTileValue = false;
		
		for(int row = 0; row <= 2; row++) {         //loop through every tile
			for(int col = 0; col <= 2; col++) {
				Tile currTile = model.getBoard().getTile(row, col);   //get the current tile
				if(row == 1 && col == 1) {       //for the center tile
					if(currTile.isHasValue()) {
						innerTileValue = true;
					}
				} else {   //for every tile that ISN'T the center tile
					if(currTile.isHasValue()) {
						outerTilesEmpty = false;   //if any of the outer tiles have a value, set outerTileEmpty to be false
					}
				}
			}
		}
		//we have now checked all tiles and OuterTilesEmpty and innerTileValue are set
		if(outerTilesEmpty && innerTileValue) {
			model.getBoard().getTile(1, 1).setFinalWinner(true);   //set tile to be final winner
			app.endOfGameAnnouncer.setText("You have won! :) Click Reset to start again or Quit to quit the app");
			model.setGameWon(true);
		}
		app.repaint();
	}
}
