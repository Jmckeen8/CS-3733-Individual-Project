package mathpuzzle.controller;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;

public class ResetController {
	
	Model model;
	MathPuzzleApp app;
	
	public ResetController (Model m, MathPuzzleApp a){
		model = m;
		app = a;
	}
	
	public void process() {
		model.getBoard().resetBoard();
		model.setSelectedTile(model.getBoard().getTile(0, 0));
		model.setSelectedLoc(0, 0);
		app.endOfGameAnnouncer.setText("Click any tile to select it, then use one of the arrow keys to make a move.");
		model.setGameWon(false);
		app.repaint();
	}

}
