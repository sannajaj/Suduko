import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Suduko extends JFrame{

	private static final long serialVersionUID = 4245963788880015503L;
	
	private static final String NAME = "Small Suduko";
	
	JPanel pane;
	JPanel grid;
	JButton createButton;
	JLabel labelMatrix[][] = new JLabel[4][4];
	
	Board board;
	
	public Suduko() {
		super(NAME);
		setBounds(100, 100, 300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pane = new JPanel();
		BoxLayout box = new BoxLayout(pane, BoxLayout.Y_AXIS);
		pane.setLayout(box);
		Container container = this.getContentPane();
		container.add(pane);
		createGrid();
		createLabels();
		createButtons();
		createBoard();
		setVisible(true);
	}
	
	private void createGrid() {
		GridLayout gridLayout = new GridLayout(4, 4, 0, 0);
		grid = new JPanel(gridLayout);
		grid.setBounds(0, 0, 300, 300);
		pane.add(grid);
	}
	
	private void createButtons() {
		createButton = new JButton("Create new puzzle");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createBoard();				
			}
		});
		pane.add(createButton);
	}
	
	private void createLabels() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				JLabel label = new JLabel("");
				label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 40));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setVerticalAlignment(SwingConstants.CENTER);
				int rightBorder = j == 1 ? 3 : 1;
				int bottomBorder = i == 1 ? 3 : 1;
				label.setBorder(BorderFactory.createMatteBorder(1, 1, bottomBorder, rightBorder, Color.BLACK));
				labelMatrix[i][j] = label;
				grid.add(label);
			}
		}
	}
	
	private void createBoard() {
		if (board == null || board.solveable()) {
			board = new Board();
		}
		board.randomize();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				String stringValue = board.squares[i][j].getStringValue();
				labelMatrix[i][j].setText(stringValue);			
			}
		}
	}

	public static void main(String[] args) {
		new Suduko();
	}

}
