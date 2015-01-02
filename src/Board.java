import java.util.Random;


/**
 * @author Susanna
 * This class represents a 4x4 suduko board
 */
public class Board {
	Square squares[][] = new Square[4][4];
	private Random random = new Random();
	
	public Board() {
		for(int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				squares[i][j] = new Square();
			}
		}
	}
	
	
	/**
	 * Creates a random board that is solvable
	 */
	public void randomize() {
		while (!solveable()) {
			int row = getRandomIndex();
			int column = getRandomIndex();
			while (!squares[row][column].hasAllPossiblities()) {
				row = getRandomIndex();
				column = getRandomIndex();
			}
			int value = getRandomValue();
			putNumber(row, column, value);
		}
	}
	
	private boolean solveable() {
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
				if (squares[row][column].hasAllPossiblities()) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void putNumber(int row, int column, int number) {
		squares[row][column].setValue(number);
		removePossibilitiesInRow(row, column, number);
		removePossibilitiesInColumn(row, column, number);
		if (removePossiblitiesInBoxOne(row, column, number)) {
			return;
		}
		if (removePossiblitiesInBoxTwo(row, column, number)) {
			return;
		}
		if (removePossiblitiesInBoxThree(row, column, number)) {
			return;
		}
		if (removePossiblitiesInBoxFour(row, column, number)) {
			return;
		}
	}
	
	private void removePossibilitiesInRow(int row, int column, int number) {
		for(int c = 0; c < 4; c++) {
			if (c != column) {
				squares[row][c].removePossibility(number);
			}
		}
	}
	
	private void removePossibilitiesInColumn(int row, int column, int number) {
		for(int r = 0; r < 4; r++) {
			if (r != row) {
				squares[r][column].removePossibility(number);
			}
		}
	}
	
	private boolean removePossiblitiesInBoxOne(int row, int column, int number) {
		if ((row == 0 || row == 1) && (column == 0 || column == 1)) {
			squares[0][0].removePossibility(number);
			squares[0][1].removePossibility(number);
			squares[1][0].removePossibility(number);
			squares[1][1].removePossibility(number);
			return true;
		}
		return false;
	}
	
	private boolean removePossiblitiesInBoxTwo(int row, int column, int number) {
		if ((row == 0 || row == 1) && (column == 2 || column == 3)) {
			squares[0][2].removePossibility(number);
			squares[0][3].removePossibility(number);
			squares[1][2].removePossibility(number);
			squares[1][3].removePossibility(number);
			return true;
		}
		return false;
	}
	
	private boolean removePossiblitiesInBoxThree(int row, int column, int number) {
		if ((row == 2 || row == 3) && (column == 0 || column == 1)) {
			squares[2][0].removePossibility(number);
			squares[2][1].removePossibility(number);
			squares[3][0].removePossibility(number);
			squares[3][1].removePossibility(number);
			return true;
		}
		return false;
	}
	
	private boolean removePossiblitiesInBoxFour(int row, int column, int number) {
		if ((row == 2 || row == 3) && (column == 2 || column == 3)) {
			squares[2][2].removePossibility(number);
			squares[2][3].removePossibility(number);
			squares[3][2].removePossibility(number);
			squares[3][3].removePossibility(number);
			return true;
		}
		return false;
	}
	
	private int getRandomIndex() {
	    return randomInteger(0, 3);
	}
	
	private int getRandomValue() {
		return randomInteger(1, 4);
	}
	
	private int randomInteger(int min, int max) {
	    int randomNum = random.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
