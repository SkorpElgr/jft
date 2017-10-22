package ru.stqa.pft.addressbook;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickname;
    private final String parnter;
    private final String address2;
    private final String companyName;
    private final String address;
    private final String homePhone;
    private final String mobilePone;
    private final String workPhone;
    private final String faxNumber;
    private final String email;
    private final String secondPhone;
    private final String notes;

    public ContactData(String firstName, String middleName, String lastName, String nickname, String parnter, String address2, String companyName, String address, String homePhone, String mobilePone, String workPhone, String faxNumber, String email, String secondPhone, String notes) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.parnter = parnter;
        this.address2 = address2;
        this.companyName = companyName;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePone = mobilePone;
        this.workPhone = workPhone;
        this.faxNumber = faxNumber;
        this.email = email;
        this.secondPhone = secondPhone;
        this.notes = notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getParnter() {
        return parnter;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePone() {
        return mobilePone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public String getNotes() {
        return notes;
    }
}
