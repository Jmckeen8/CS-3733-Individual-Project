package mathpuzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;
import mathpuzzle.model.Tile;

class TestSelectTileController {

	@Test
	void testSelectTile() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		SelectTileController stc = new SelectTileController(model, app);
		
		Point point = new Point(300, 500);
		
		stc.process(point);
		
		assertEquals(model.getSelectedRow(), 2);
		assertEquals(model.getSelectedCol(), 1);
	}
	
	@Test
	void testSelectEmptytile() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		SelectTileController stc = new SelectTileController(model, app);
		
		Tile blankTile = new Tile(-1);
		blankTile.setHasValue(false);
		
		Point point = new Point(300, 500);
		model.getBoard().setTile(2, 1, blankTile);
		
		assertEquals(model.getSelectedRow(), 0);
		assertEquals(model.getSelectedCol(), 0);
		
	}

}
