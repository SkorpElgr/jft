package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
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
    private String group;


//    public ContactData(int id, String name, String lastname) {
//        this.id = id;
//        this.firstName = name;
//        this.lastName = lastname;
//    }
//
//    public ContactData(String name, String lastname) {
//        this.id = Integer.MAX_VALUE;
//        this.firstName = name;
//        this.lastName = lastname;
//    }
//
//    public ContactData(String name, String lastname, String group) {
//        this.id = Integer.MAX_VALUE;
//        this.firstName = name;
//        this.lastName = lastname;
//        this.group = group;
//    }
//
//    public ContactData(int id, String firstName, String middleName, String lastName,
//                       String nickname, String parnter, String address2,
//                       String companyName, String address, String homePhone,
//                       String mobilePone, String workPhone, String faxNumber,
//                       String email, String secondPhone, String notes, String group) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.middleName = middleName;
//        this.nickname = nickname;
//        this.parnter = parnter;
//        this.address2 = address2;
//        this.companyName = companyName;
//        this.address = address;
//        this.homePhone = homePhone;
//        this.mobilePone = mobilePone;
//        this.workPhone = workPhone;
//        this.faxNumber = faxNumber;
//        this.email = email;
//        this.secondPhone = secondPhone;
//        this.notes = notes;
//        this.group = group;
//    }
//
//    public ContactData(String firstName, String middleName, String lastName,
//                       String nickname, String parnter, String address2,
//                       String companyName, String address, String homePhone,
//                       String mobilePone, String workPhone, String faxNumber,
//                       String email, String secondPhone, String notes, String group) {
//        this.id = Integer.MAX_VALUE;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.middleName = middleName;
//        this.nickname = nickname;
//        this.parnter = parnter;
//        this.address2 = address2;
//        this.companyName = companyName;
//        this.address = address;
//        this.homePhone = homePhone;
//        this.mobilePone = mobilePone;
//        this.workPhone = workPhone;
//        this.faxNumber = faxNumber;
//        this.email = email;
//        this.secondPhone = secondPhone;
//        this.notes = notes;
//        this.group = group;
//    }


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


    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withParnter(String parnter) {
        this.parnter = parnter;
        return this;
    }

    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactData withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePone) {
        this.mobilePone = mobilePone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
        return this;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
