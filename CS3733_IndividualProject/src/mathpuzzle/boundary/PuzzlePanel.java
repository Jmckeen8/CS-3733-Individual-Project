package mathpuzzle.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import mathpuzzle.model.Board;
import mathpuzzle.model.Model;
import mathpuzzle.model.Tile;

public class PuzzlePanel extends JPanel{

	Model model;
	
	public PuzzlePanel(Model model) {
		this.model = model;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (model == null) {
			return;
		}
		
		Board board = model.getBoard();
		
		g.setFont(new Font("",0,100));
		
		for (int row = 0; row <= 2; row++) {
			for (int col = 0; col <=2; col++) {
				int startHoriz = 200*col;   //set to where starting pixel should be for LEFT side of rectangle
				int startVert = 200*row;    //set to where starting pixel should be for TOP side of rectangle
				
				Tile currentTile = model.getBoard().getTile(row, col);
				
				Rectangle rec = new Rectangle(startHoriz+5, startVert+5, 190, 190);
				
				if(currentTile.isFinalWinner()) {   //if current tile being drawn is the winner, draw in gold
					g.setColor(Color.ORANGE);
				} else if(currentTile.isHasValue()==false) {  //if current tile has no value, draw dark gray
					g.setColor(Color.DARK_GRAY);
				} else if(model.getSelectedTile().equals(currentTile)) {   //if current tile is selected, highlight blue
					g.setColor(Color.CYAN);
				} else {                              //else normal tile, light gray
					g.setColor(Color.LIGHT_GRAY);
				}
				
				g.fillRect(rec.x, rec.y, rec.width, rec.height);
				
				g.setColor(Color.BLACK);
				if(currentTile.isHasValue()) {   //draw value string ONLY if tile has a value
					if(String.valueOf(currentTile.getValue()).length()==1) {
						g.drawString(String.valueOf(currentTile.getValue()), startHoriz+75, startVert+130);
					} else if(String.valueOf(currentTile.getValue()).length()==2) {
						g.drawString(String.valueOf(currentTile.getValue()), startHoriz+45, startVert+130);
					} else if(String.valueOf(currentTile.getValue()).length()==3) {
						g.drawString(String.valueOf(currentTile.getValue()), startHoriz+15, startVert+130);
					} else if(String.valueOf(currentTile.getValue()).length()>=4) {
						g.setFont(new Font("",0,50));
						g.drawString(String.valueOf(currentTile.getValue()), startHoriz+15, startVert+130);
						g.setFont(new Font("",0,100));
						
					}
				}
			}
		}
	}
}
