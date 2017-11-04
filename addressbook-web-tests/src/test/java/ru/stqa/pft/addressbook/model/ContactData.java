package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private String parnter;
    private String address2;
    private String companyName;
    private String address;
    private String homePhone;
    private String mobilePone;
    private String workPhone;
    private String faxNumber;
    private String email;
    private String secondPhone;
    private String notes;
    private String group;

    public ContactData(String firstName, String middleName, String lastName,
                       String nickname, String parnter, String address2,
                       String companyName, String address, String homePhone,
                       String mobilePone, String workPhone, String faxNumber,
                       String email, String secondPhone, String notes, String group) {
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
        this.group = group;
    }

    public ContactData(String firstName) {
        this.firstName = firstName;
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

    public String getMobilePhone() {
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

    public String getGroup() {
        return group;
    }
}
