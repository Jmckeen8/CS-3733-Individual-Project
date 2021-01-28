package mathpuzzle.boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;

import mathpuzzle.model.Model;

class TestMathPuzzleApp {

	@Test
	void test() {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		
		app.setVisible(true);
		
		Robot bot = null;
		try {
			bot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bot.keyPress(KeyEvent.VK_DOWN);
		bot.delay(250);
		bot.keyRelease(KeyEvent.VK_DOWN);
		
		bot.keyPress(KeyEvent.VK_RIGHT);
		bot.delay(250);
		bot.keyRelease(KeyEvent.VK_RIGHT);
		
		assertEquals(model.getSelectedCol(), 1);
		assertEquals(model.getSelectedRow(), 1);
		
		app.setVisible(false);
		app.dispose();
	}

}
