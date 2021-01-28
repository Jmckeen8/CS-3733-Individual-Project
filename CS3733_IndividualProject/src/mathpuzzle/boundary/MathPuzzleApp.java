package mathpuzzle.boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import mathpuzzle.controller.SelectTileController;
import mathpuzzle.controller.WinController;
import mathpuzzle.controller.ExitController;
import mathpuzzle.controller.LoseController;
import mathpuzzle.controller.MoveController;
import mathpuzzle.controller.ResetController;
import mathpuzzle.model.Model;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

public class MathPuzzleApp extends JFrame {

	private JPanel contentPane;
	
	PuzzlePanel panel;
	
	Model model;
	
	Action rightAction;
	Action leftAction;
	Action upAction;
	Action downAction;

	public JTextArea endOfGameAnnouncer;

	/**
	 * Create the frame.
	 */
	public MathPuzzleApp(Model m) {
		super();
		model = m;
		
		setTitle("Math Puzzle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(model);
		panel.addMouseListener(new MouseAdapter() {   //NOTE: this mouse listener is only listening for mouse clicks within PuzzlePanel
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectTileController(model, MathPuzzleApp.this).process(me.getPoint());
			}
		});
		
		rightAction = new RightAction();
		leftAction = new LeftAction();
		upAction = new UpAction();
		downAction = new DownAction();
		
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
		panel.getActionMap().put("rightAction", rightAction);
		
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
		panel.getActionMap().put("leftAction", leftAction);
		
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "upAction");
		panel.getActionMap().put("upAction", upAction);
		
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "downAction");
		panel.getActionMap().put("downAction", downAction);
		
		endOfGameAnnouncer = new JTextArea("Click any tile to select it, then use one of the arrow keys to make a move.");
		endOfGameAnnouncer.setBackground(SystemColor.menu);
		endOfGameAnnouncer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		endOfGameAnnouncer.setBorder(null);
		endOfGameAnnouncer.setForeground(Color.BLACK);
		endOfGameAnnouncer.setLineWrap(true);
		endOfGameAnnouncer.setWrapStyleWord(true);
		endOfGameAnnouncer.setEditable(false);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, MathPuzzleApp.this).process();
			}
		});
		
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ExitController(model, MathPuzzleApp.this).process();
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(quitButton, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addComponent(endOfGameAnnouncer)
						.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
					.addComponent(endOfGameAnnouncer)
					.addGap(119))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new ExitController(model, MathPuzzleApp.this).process();
			}
		});
		
	}
	public class RightAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent ae) {
			new MoveController(model, MathPuzzleApp.this).process(1);
			new WinController(model, MathPuzzleApp.this).process();
			new LoseController(model, MathPuzzleApp.this).process();
		}
	}
	public class LeftAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent ae) {
			new MoveController(model, MathPuzzleApp.this).process(2);
			new WinController(model, MathPuzzleApp.this).process();
			new LoseController(model, MathPuzzleApp.this).process();
		}
	}
	public class UpAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent ae) {
			new MoveController(model, MathPuzzleApp.this).process(3);
			new WinController(model, MathPuzzleApp.this).process();
			new LoseController(model, MathPuzzleApp.this).process();
		}
	}
	public class DownAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent ae) {
			new MoveController(model, MathPuzzleApp.this).process(4);
			new WinController(model, MathPuzzleApp.this).process();
			new LoseController(model, MathPuzzleApp.this).process();
		}
	}

}
