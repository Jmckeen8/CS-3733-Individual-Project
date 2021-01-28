package mathpuzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;
import mathpuzzle.model.Tile;

class TestLoseController {

	@Test
	void testTrueLoss() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		
		LoseController lc = new LoseController(model, app);
		
		Tile blankTile = new Tile(-1);
		blankTile.setHasValue(false);
		
		model.getBoard().setTile(0, 0, blankTile);
		model.getBoard().setTile(0, 1, blankTile);
		model.getBoard().setTile(1, 0, blankTile);
		model.getBoard().setTile(1, 2, blankTile);
		model.getBoard().setTile(2, 0, blankTile);
		model.getBoard().setTile(2, 1, blankTile);
		model.getBoard().setTile(2, 2, blankTile);
		
		model.getBoard().setTile(1, 1, new Tile(79));
		model.getBoard().setTile(0, 2, new Tile(240));
		
		lc.process();
		
		assertEquals(app.endOfGameAnnouncer.getText(), "There aren't any more valid moves. You have lost :( Click Reset to start again or Quit to quit the app");
	}
	
	@Test
	void testNoLoss() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		
		LoseController lc = new LoseController(model, app);
		
		lc.process();
		
		assertEquals(app.endOfGameAnnouncer.getText(), "Click any tile to select it, then use one of the arrow keys to make a move.");
	}

}
