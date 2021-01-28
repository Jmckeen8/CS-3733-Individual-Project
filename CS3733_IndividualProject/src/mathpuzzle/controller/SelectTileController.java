package mathpuzzle.controller;

import java.awt.Point;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;

public class SelectTileController {
	Model model;
	MathPuzzleApp app;
	
	public SelectTileController (Model m, MathPuzzleApp a) {
		model = m;
		app = a;
	}

	public void process(Point point) {
		int row;
		int col;
		
		row = (int) Math.floor(point.y/200);
		col = (int) Math.floor(point.x/200);
		
		if(model.getBoard().getTile(row, col).isHasValue()) {
			model.setSelectedTile(model.getBoard().getTile(row, col));
			model.setSelectedLoc(row, col);
		}
		
		app.repaint();
	}
	
	

}
