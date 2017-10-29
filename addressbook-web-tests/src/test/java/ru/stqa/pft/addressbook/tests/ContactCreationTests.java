package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("firstname", "middleName",
                "lastName", "Nickname", "Parnter",
                "no second house", "Luxoft",
                "Some Address line 1,\naddressline2", "38067842",
                "35148", "526541", "478461",
                "email@gmail.com", "30215", "Notes text...", "test1"), true);
        app.getContactHelper().submitContactCreation();
    }

}
