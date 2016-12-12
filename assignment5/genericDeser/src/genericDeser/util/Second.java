package genericDeser.util;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Second {
	int IntValue;
	boolean BooleanValue;
	double DoubleValue;

	public int getIntValue() {
		return IntValue;
	}

	public void setIntValue(int intValue) {
		IntValue = intValue;
	}

	public boolean getBooleanValue() {
		return BooleanValue;
	}

	public void setBooleanValue(boolean booleanValue) {
		BooleanValue = booleanValue;
	}

	public double getDoubleValue() {
		return DoubleValue;
	}

	public void setDoubleValue(double doubleValue) {
		DoubleValue = doubleValue;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " " + BooleanValue + " " + getIntValue() + " " + getDoubleValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Second)) {
			return false;
		}
		Second second = (Second) obj;

		return second.getBooleanValue() == BooleanValue && second.getIntValue() == IntValue
				&& second.getDoubleValue() == DoubleValue;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
