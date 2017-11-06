package ru.stqa.pft.addressbook.model;

public class ContactData {
    private String firstName;
    private String lastName;
    private String middleName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    private String group;

    public ContactData(String... strings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
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

    public ContactData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
