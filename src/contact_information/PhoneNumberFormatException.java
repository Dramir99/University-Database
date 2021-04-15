package contact_information;

public class PhoneNumberFormatException extends Exception {
    String checkingPhoneNumber;

    public PhoneNumberFormatException(){
        checkingPhoneNumber = "555-555-5555";
    }

    public PhoneNumberFormatException(String checkingPhoneNumber) {
        super(checkingPhoneNumber);
    }

    public String getCheckingPhoneNumber() {
        return checkingPhoneNumber;
    }

}
