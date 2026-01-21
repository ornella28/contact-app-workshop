package se.lexicon.model;

public class Contact {

    private static final String Phone_REGEX = "^\\d{10}$";

    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null){
            throw new IllegalArgumentException("Phone number cannot be null");
        }
        this.phoneNumber = phoneNumber.trim();
    }

    //override method

}
