package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Admin on 22.10.2017.
 */
public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToMainPage();
        int before = app.getContactHelper().getContactCount();
        try {
            app.getContactHelper().selectContact();
        } catch (NoSuchElementException ex) {
            app.getContactHelper().createDefaultContact();
        }
        app.getContactHelper().deleteContact();
        app.getContactHelper().closeContactDeletionAlert();
        app.getNavigationHelper().goToMainPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}
