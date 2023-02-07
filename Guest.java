package Junior_Part.Proiect_P1;

import java.util.Objects;

public class Guest {
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Guest(String lastName, String firstName, String email, String phoneNumber){
        this.email = email;
        if (!(phoneNumber.charAt(0)+"").equals("0")){
            this.phoneNumber = "0" + phoneNumber;
        }
        else{
            this.phoneNumber=phoneNumber;
        }
        this.lastName=lastName.toLowerCase();
        this.firstName=firstName.toLowerCase();
    }
}
