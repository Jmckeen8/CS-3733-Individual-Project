package mathpuzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;
import mathpuzzle.model.Tile;

class TestWinController {

	@Test
	void testTrueWin() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		
		WinController wc = new WinController(model, app);
		
		Tile blankTile = new Tile(-1);
		blankTile.setHasValue(false);
		
		model.getBoard().setTile(0, 0, blankTile);
		model.getBoard().setTile(0, 1, blankTile);
		model.getBoard().setTile(0, 2, blankTile);
		model.getBoard().setTile(1, 0, blankTile);
		model.getBoard().setTile(1, 2, blankTile);
		model.getBoard().setTile(2, 0, blankTile);
		model.getBoard().setTile(2, 1, blankTile);
		model.getBoard().setTile(2, 2, blankTile);
		
		model.getBoard().setTile(1, 1, new Tile(11));
		
		wc.process();
		
		assertTrue(model.getBoard().getTile(1, 1).isFinalWinner());
		assertEquals(app.endOfGameAnnouncer.getText(), "You have won! :) Click Reset to start again or Quit to quit the app");
		assertTrue(model.isGameWon());
	}
	
	@Test
	void testNoWin() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		
		WinController wc = new WinController(model, app);
		
		wc.process();
		assertFalse(model.isGameWon());
	}

}
