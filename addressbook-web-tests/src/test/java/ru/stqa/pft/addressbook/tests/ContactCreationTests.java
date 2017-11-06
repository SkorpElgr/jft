package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToMainPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("name1", "lastname2");
        app.getContactHelper().fillContactForm(contact, true);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(contact);
        Comparator<? super ContactData> byLastName = Comparator.comparing(ContactData::getLastName);
        before.sort(byLastName);
        after.sort(byLastName);
        Assert.assertEquals(before, after);
    }

}
