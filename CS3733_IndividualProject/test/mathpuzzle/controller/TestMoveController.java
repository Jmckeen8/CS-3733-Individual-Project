package mathpuzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;

class TestMoveController {

	@Test
	void testAdd() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		MoveController mc = new MoveController(model, app);
		
		mc.process(1);
		
		assertEquals(model.getBoard().getTile(0, 1).getValue(), 5);
	}
	
	@Test
	void testSubtract() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		MoveController mc = new MoveController(model, app);
		
		model.setSelectedTile(model.getBoard().getTile(2, 1));
		model.setSelectedLoc(2, 1);
		mc.process(2);
		
		assertEquals(model.getBoard().getTile(2, 0).getValue(), 1);
	}
	
	@Test
	void testMultiply() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		MoveController mc = new MoveController(model, app);
		
		model.setSelectedTile(model.getBoard().getTile(1, 0));
		model.setSelectedLoc(1, 0);
		mc.process(3);
		
		assertEquals(model.getBoard().getTile(0, 0).getValue(), 7);
	}
	
	@Test
	void testDivide() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		MoveController mc = new MoveController(model, app);
		
		model.setSelectedTile(model.getBoard().getTile(1, 1));
		model.setSelectedLoc(1, 1);
		mc.process(4);
		
		assertEquals(model.getBoard().getTile(2, 1).getValue(), 4);
	}

}
