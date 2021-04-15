/*
    Author: Daniel Ramirez
    Purpose: create a PhoneNumber class
 */
package contact_information;

public class PhoneNumber {
	String type;
	int areacode;
	int prefix;
	int suffix;

	public PhoneNumber() {
		type = "type";
		areacode = 323;
		prefix = 343;
		suffix = 1234;
	}

	public PhoneNumber(String type, int areacode, int prefix, int suffix) {
		this.type = type;
		this.areacode = areacode;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAreacode() {
		return areacode;
	}

	public void setAreacode(int areacode) {
		this.areacode = areacode;
	}

	public int getPrefix() {
		return prefix;
	}

	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}

	public int getSuffix() {
		return suffix;
	}

	public void setSuffix(int suffix) {
		this.suffix = suffix;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PhoneNumber)) {
			return false;
		} else {
			PhoneNumber temp = (PhoneNumber) obj;
			if (this.type.equalsIgnoreCase(temp.type) && this.areacode == (temp.areacode)
					&& this.prefix == (temp.prefix) && this.suffix == (temp.suffix)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return type + ": (" + areacode + ") " + prefix + "-" + suffix;
	}
}
