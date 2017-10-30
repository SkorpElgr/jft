package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        try {
            app.getGroupHelper().selectGroup();
        } catch (NoSuchElementException ex) {
            app.getGroupHelper().createDefaultGroup();
        }
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
