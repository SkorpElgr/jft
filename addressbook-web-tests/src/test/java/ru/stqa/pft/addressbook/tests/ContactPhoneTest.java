package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Admin on 19.11.2017.
 */
public class ContactPhoneTest extends TestBase {

    @Test
    public void testContactPhone() {
        app.goTo().goToMainPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getHomePhone(), equalTo(contactInfoFromEditForm.getHomePhone()));
        assertThat(contact.getMobilePhone(), equalTo(contactInfoFromEditForm.getMobilePhone()));
        assertThat(contact.getWorkPhone(), equalTo(contactInfoFromEditForm.getWorkPhone()));
    }
}
