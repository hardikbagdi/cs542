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
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof First)) {
			return false;
		}
		First first = (First) obj;

		Float f1 = new Float(FloatValue);
		Float f2 = new Float(first.getFloatValue());
		return f1.equals(f2) && first.getIntValue() == IntValue && first.getShortValue() == ShortValue
				&& first.getStringValue() == StringValue;
	}

	@Override
	public int hashCode() {
		// https://www.mkyong.com/java/java-how-to-overrides-equals-and-hashcode/
		int result = 17;
		result = 31 * result + IntValue;
		result = 31 * result + new Float(FloatValue).hashCode();
		result = 31 * result + (int) ShortValue;
		if (StringValue != null)
			result = 31 * result + StringValue.hashCode();
		return result;
	}
}
