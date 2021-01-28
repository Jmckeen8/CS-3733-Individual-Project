package mathpuzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBoard {

	@Test
	void testGetTile() {
		Board board = new Board();
		Tile tile = new Tile(7);
		
		board.setTile(2, 2, tile);
		assertEquals(tile, board.getTile(2, 2));
	}
	
	@Test
	void testSetTile() {
		Board board = new Board();
		Tile tile = new Tile(7);
		
		board.setTile(1, 2, tile);
		assertEquals(board.getTile(1, 2), tile);
	}
	
	@Test
	void testValidDownGood() {
		Board board = new Board();
		assertTrue(board.validDown(1, 1));
	}
	
	@Test
	void testValidDownRem() {
		Board board = new Board();
		assertFalse(board.validDown(1, 2));
	}
	
	@Test
	void testValidDownOff() {
		Board board = new Board();
		assertFalse(board.validDown(2, 1));
	}
	
	@Test
	void testValidUpGood() {
		Board board = new Board();
		assertTrue(board.validUp(1, 2));
	}
	
	@Test
	void testValidUpOff() {
		Board board = new Board();
		assertFalse(board.validUp(0, 2));
	}
	
	@Test
	void testValidRightGood() {
		Board board = new Board();
		assertTrue(board.validRight(0, 1));
	}
	
	@Test
	void testValidRightOff() {
		Board board = new Board();
		assertFalse(board.validRight(2, 2));
	}
	
	@Test
	void testValidLeftGood() {
		Board board = new Board();
		assertTrue(board.validLeft(2, 2));
	}
	
	@Test
	void testValidLeftNeg() {
		Board board = new Board();
		assertFalse(board.validLeft(1, 2));
	}
	
	@Test
	void testValidLeftOff() {
		Board board = new Board();
		assertFalse(board.validLeft(0, 0));
	}
	
	@Test
	void testResetBoard() {
		Board board = new Board();
		Tile tile = new Tile(100);
		Tile tile2 = new Tile(-1);
		tile2.setHasValue(false);
		
		board.setTile(0, 0, tile);
		board.setTile(2, 2, tile2);
		
		board.resetBoard();
		
		assertEquals(board.getTile(0, 0).getValue(), 1);
		assertEquals(board.getTile(2, 2).getValue(), 6);
		assertTrue(board.getTile(2, 2).isHasValue());
	}

}
