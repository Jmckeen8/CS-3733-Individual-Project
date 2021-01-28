package mathpuzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTile {

	@Test
	void testConstruction() {
		Tile tile = new Tile(6);
		assertEquals (6, tile.getValue());
		assertEquals (true, tile.isHasValue());
	}

}
