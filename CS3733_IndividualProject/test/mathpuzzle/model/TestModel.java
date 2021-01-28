package mathpuzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestModel {

	@Test
	void testConstructor() {
		Model model = new Model();
		
		assertEquals(model.getSelectedTile(), model.getBoard().getTile(0, 0));
		assertFalse(model.isGameWon());
	}
	
	@Test
	void testSetSelectedLoc() {
		Model model = new Model();
		
		model.setSelectedLoc(1, 2);
		assertEquals(model.getSelectedRow(), 1);
		assertEquals(model.getSelectedCol(), 2);
	}

}
