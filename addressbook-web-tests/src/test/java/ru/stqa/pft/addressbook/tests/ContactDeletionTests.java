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
public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().goToMainPage();
        if (app.contact().list().size() == 0) {
            app.contact().create();
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();
        app.contact().select(before.size() - 1);
        app.contact().delete();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Comparator<? super ContactData> byId = Comparator.comparing(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }
}
