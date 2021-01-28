package mathpuzzle.controller;

import javax.swing.JOptionPane;

import mathpuzzle.boundary.MathPuzzleApp;
import mathpuzzle.model.Model;

public class ExitController {
	Model model;
	MathPuzzleApp app;
	
	public ExitController (Model m, MathPuzzleApp a) {
		model = m;
		app = a;
	}
	
	public void process() {
		int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit Confirmation", JOptionPane.YES_NO_OPTION);
		
		if(confirmExit==JOptionPane.YES_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
}
