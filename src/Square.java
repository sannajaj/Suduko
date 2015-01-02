
/**
 * @author Susanna
 * Represents a square in a 4x4 suduko puzzle. Keeping track of the possible values.
 */
public class Square {	
	private boolean one;
	private boolean two;
	private boolean three;
	private boolean four;
	private boolean generated;
	
	public Square() {
		one = true;
		two = true;
		three = true;
		four = true;
		generated = false;
	}
	
	/**
	 * Indicates if this square has only one possible value
	 * 
	 * @return true if only one value is possible
	 */
	public boolean hasOnlyOnePossiblity() {
		return one && !two && !three && !four ||
				!one && two && !three && !four ||
				!one && !two && three && !four ||
				!one && !two && !three && four;
	}
	
	/**
	 * Indicates if this square can have any value.
	 * @return true if all values are possible.
	 */
	public boolean hasAllPossiblities() {
		return one && two && three && four;
	}
	
	/**
	 * Indicates if the given value is possible for this square.
	 * @param value an integer between 1 and 4
	 * @return if the value is possible
	 */
	public boolean isPossibleValue(int value) {
		switch(value) {
		case 1:
			return one;
		case 2:
			return two;
		case 3:
			return three;
		case 4:
			return four;
		}
		return false;
	}
	
	/**
	 * The value that has been set as a string.
	 * @return set value of empty string if not set.
	 */
	public String getStringValue()  {
		int value = getValue();
		if (value > 0 && generated) {
			return String.valueOf(value);
		}
		return "";
	}
	
	/**
	 * Sets the value of this square.
	 * @param value the value to set between 1 and 4 or it will not be set.
	 */
	public void setValue(int value) {
		switch(value) {
		case 1:
			one = true;
			two = false;
			three = false;
			four = false;
			generated = true;
			return;
		case 2:
			one = false;
			two = true;
			three = false;
			four = false;
			generated = true;
			return;
		case 3:
			one = false;
			two = false;
			three = true;
			four = false;
			generated = true;
			return;
		case 4:
			one = false;
			two = false;
			three = false;
			four = true;
			generated = true;
			return;
		}
	}
	
	/**
	 * Remove possible value for this square
	 * @param possibility the value to remove as possible
	 */
	public void removePossibility(int possibility) {
		if (!hasOnlyOnePossiblity()) {
			switch(possibility) {
			case 1:
				one = false;
				return;
			case 2:
				two = false;
				return;
			case 3:
				three = false;
				return;
			case 4:
				four = false;
				return;
			}
		}
	}
	
	private int getValue() {
		if (hasOnlyOnePossiblity()) {
			if (one) {
				return 1;
			} else if (two) {
				return 2;
			} else if (three) {
				return 3;
			} else if (four) {
				return 4;
			}
		}
		return 0;
	}
}
