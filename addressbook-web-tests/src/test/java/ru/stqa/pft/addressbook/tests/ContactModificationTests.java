package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Admin on 22.10.2017.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().goToMainPage();
        if (app.contact().list().size() == 0) {
            app.contact().create();
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData().withId(before.get(index).getId())
                .withFirstName("Updatedfirstname").withMiddleName("UpdatedMiddleName")
                .withLastName("UpdatedlastName").withNickname("Nickname")
                .withParnter("Parnter").withSecondPhone("no second house")
                .withCompanyName("Luxoft").withAddress("Updated Address line 1,\naddressline2")
                .withHomePhone("38067842").withMobilePhone("35148").withFaxNumber("526541")
                .withEmail("UpdatedEmail@gmail.com").withNotes("Notes text...");

        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
