package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Admin on 22.10.2017.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().goToMainPage();
        if (app.contact().all().size() == 0) {
            app.contact().create();
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId())
                .withFirstName("Updatedfirstname").withMiddleName("UpdatedMiddleName")
                .withLastName("UpdatedlastName").withNickname("Nickname")
                .withParnter("Parnter").withSecondPhone("no second house")
                .withCompanyName("Luxoft").withAddress("Updated Address line 1,\naddressline2")
                .withHomePhone("38067842").withMobilePhone("35148").withFaxNumber("526541")
                .withEmail("UpdatedEmail@gmail.com").withNotes("Notes text...");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
