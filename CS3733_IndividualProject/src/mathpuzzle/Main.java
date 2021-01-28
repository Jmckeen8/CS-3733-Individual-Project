package mathpuzzle;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		MathPuzzleApp app = new MathPuzzleApp(model);
		app.setVisible(true);
	}

}
