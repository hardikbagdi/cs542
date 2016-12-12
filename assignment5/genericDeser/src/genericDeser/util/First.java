package genericDeser.util;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class First {
	private int IntValue;
	private String StringValue;
	private float FloatValue;
	private short ShortValue;

	public int getIntValue() {
		return IntValue;
	}

	public void setIntValue(int intValue) {
		IntValue = intValue;
	}

	public String getStringValue() {
		return StringValue;
	}

	public void setStringValue(String stringValue) {
		StringValue = stringValue;
	}

	public float getFloatValue() {
		return FloatValue;
	}

	public void setFloatValue(float floatValue) {
		FloatValue = floatValue;
	}

	public short getShortValue() {
		return ShortValue;
	}

	public void setShortValue(short shortValue) {
		ShortValue = shortValue;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " " + getShortValue() + " " + getIntValue() + " " + getFloatValue() + " "
				+ getStringValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Second)) {
			return false;
		}
		First first = (First) obj;

		return first.getFloatValue() == FloatValue && first.getIntValue() == IntValue
				&& first.getShortValue() == ShortValue && first.getStringValue() == StringValue;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
