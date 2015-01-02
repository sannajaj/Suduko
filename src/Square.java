
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
	
	public boolean hasOnlyOnePossiblity() {
		return one && !two && !three && !four ||
				!one && two && !three && !four ||
				!one && !two && three && !four ||
				!one && !two && !three && four;
	}
	
	public boolean hasAllPossiblities() {
		return one && two && three && four;
	}
	
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
	
	public String getStringValue()  {
		int value = getValue();
		if (value > 0 && generated) {
			return String.valueOf(value);
		}
		return "";
	}
	
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
