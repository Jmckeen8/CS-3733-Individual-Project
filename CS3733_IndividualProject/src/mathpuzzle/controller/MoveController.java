package mathpuzzle.controller;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;
import mathpuzzle.model.Tile;

public class MoveController {
	
	Model model;
	MathPuzzleApp app;
	
	public MoveController (Model m, MathPuzzleApp a) {
		model = m;
		app = a;
	}
	
	public void process(int keyCode) {
		Tile tile = model.getSelectedTile();
		int row = model.getSelectedRow();
		int col = model.getSelectedCol();
		
		switch(keyCode) {
		case 1:   //RIGHT, ADD
			if(model.getBoard().validRight(row,col)) {
				Tile newTile = model.getBoard().getTile(row, col+1);   //get the new (target) tile, one to the left
				int oldVal = newTile.getValue();     //save previous value of target tile
				newTile.setValue(oldVal+tile.getValue());   //modify value of target tile
				tile.setValue(-1);
				tile.setHasValue(false);   //current tile no longer has a value
				model.setSelectedTile(newTile);
				model.setSelectedLoc(row, col+1);
			}
			break;
		case 2:   //LEFT, SUBTRACT
			if(model.getBoard().validLeft(row, col)){
				Tile newTile = model.getBoard().getTile(row, col-1);   //get the new (target) tile, one to the left
				int oldVal = newTile.getValue();     //save previous value of target tile
				newTile.setValue(oldVal-tile.getValue());   //modify value of target tile
				tile.setValue(-1);
				tile.setHasValue(false);   //current tile no longer has a value
				model.setSelectedTile(newTile);
				model.setSelectedLoc(row, col-1);
			}
			break;
		case 3:   //UP, MULTIPLY
			if(model.getBoard().validUp(row, col)) {
				Tile newTile = model.getBoard().getTile(row-1, col);   //get the new (target) tile, one to the left
				int oldVal = newTile.getValue();     //save previous value of target tile
				newTile.setValue(oldVal*tile.getValue());   //modify value of target tile
				tile.setValue(-1);
				tile.setHasValue(false);   //current tile no longer has a value
				model.setSelectedTile(newTile);
				model.setSelectedLoc(row-1, col);
			}
			break;
		case 4:   //DOWN, DIVIDE
			if(model.getBoard().validDown(row, col)) {
				Tile newTile = model.getBoard().getTile(row+1, col);   //get the new (target) tile, one to the left
				int oldVal = newTile.getValue();     //save previous value of target tile
				newTile.setValue(oldVal/tile.getValue());   //modify value of target tile
				tile.setValue(-1);
				tile.setHasValue(false);   //current tile no longer has a value
				model.setSelectedTile(newTile);
				model.setSelectedLoc(row+1, col);
			}
			break;
		}
		
		app.repaint();
	}

}
