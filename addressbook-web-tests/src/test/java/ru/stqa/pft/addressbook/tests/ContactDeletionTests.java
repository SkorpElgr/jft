package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Admin on 22.10.2017.
 */
public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().closeContactDeletionAlert();
        app.getNavigationHelper().goToMainPage();
    }
}
