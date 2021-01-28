package mathpuzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;

class TestResetController {

	@Test
	void test() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		ResetController rc = new ResetController(model, app);
		
		model.setSelectedTile(model.getBoard().getTile(2, 2));
		model.setSelectedLoc(2, 2);
		app.endOfGameAnnouncer.setText("asdfasdf");
		
		rc.process();
		
		assertEquals(model.getSelectedTile(), model.getBoard().getTile(0, 0));
		assertEquals(model.getSelectedRow(), 0);
		assertEquals(model.getSelectedCol(), 0);
		assertEquals(app.endOfGameAnnouncer.getText(), "Click any tile to select it, then use one of the arrow keys to make a move.");
		assertFalse(model.isGameWon());
	}

}
