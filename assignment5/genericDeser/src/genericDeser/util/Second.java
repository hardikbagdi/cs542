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
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Second)) {
			return false;
		}
		Second second = (Second) obj;
		Double d1 = new Double(DoubleValue);
		Double d2 = new Double(second.getDoubleValue());

		return second.getBooleanValue() == BooleanValue && second.getIntValue() == IntValue
				&& d1.equals(d2);
	}

	@Override
	public int hashCode() {
		// https://www.mkyong.com/java/java-how-to-overrides-equals-and-hashcode/
		int result = 17;
		result = 31 * result + IntValue;
		result = 31 * result + new Double(DoubleValue).hashCode();
		if (BooleanValue)
			result = 31 * result + 23;
		else
			result = 31 * result + 42;
		return result;
	}
}
