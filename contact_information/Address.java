/*
    Author: Daniel Ramirez
    Purpose: create a Address class
 */
package contact_information;

public class Address {
	int streetNumber;
	int apartmentNumber;
	String streetName;
	String city;
	int zipCode;
	String state;

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Address() {
		streetNumber = 123;
		apartmentNumber = -9999;
		streetName = "street name";
		city = "city";
		zipCode = 90249;
		state = "state";
	}

	public Address(int streetNumber, int apartmentNumber, String streetName, String city, String state,
			int zipCode) {
		this.streetNumber = streetNumber;
		this.apartmentNumber = apartmentNumber;
		this.streetName = streetName;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Address)) {
			return false;
		} else {
			Address temp = (Address) obj;
			if (this.streetNumber == (temp.streetNumber)
					&& this.apartmentNumber ==(temp.apartmentNumber)
					&& this.streetName.equalsIgnoreCase(temp.streetName) && this.city.equalsIgnoreCase(temp.city)
					&& this.zipCode == (temp.zipCode) && this.state.equalsIgnoreCase(temp.state)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		if (apartmentNumber == (-9999)) {
			return streetNumber + " " + -9999 + " " + streetName + "\r\n|                   " + city + ", " + state + ", "
					+ zipCode;
		} else {
			return streetNumber + " " + apartmentNumber + " " + streetName + "\r\n|                   " + city + ", "
					+ state + ", " + zipCode;
		}
	}
}
