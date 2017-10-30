package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

/**
 * Created by Admin on 22.10.2017.
 */
public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        try {
            app.getContactHelper().selectContact();
        } catch (NoSuchElementException ex) {
            app.getContactHelper().createDefaultContact();
        }
        app.getContactHelper().deleteContact();
        app.getContactHelper().closeContactDeletionAlert();
        app.getNavigationHelper().goToMainPage();
    }
}
