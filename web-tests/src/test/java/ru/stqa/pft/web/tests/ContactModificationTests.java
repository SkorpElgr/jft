//package ru.stqa.pft.web.tests;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import ru.stqa.pft.web.model.ContactData;
//import ru.stqa.pft.web.model.Contacts;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//
///**
// * Created by Admin on 22.10.2017.
// */
//public class ContactModificationTests extends TestBase {
//
//    @BeforeMethod
//    public void ensurePreconditions() {
//        if (app.db().contacts().size() == 0) {
//            app.goTo().goToMainPage();
//            app.contact().create();
//        }
//    }
//
//    @Test
//    public void testContactModification() {
//        Contacts before = app.db().contacts();
//        ContactData modifiedContact = before.iterator().next();
//        ContactData contact = new ContactData().withId(modifiedContact.getId())
//                .withFirstName("Updatedfirstname").withMiddleName("UpdatedMiddleName")
//                .withLastName("UpdatedlastName").withNickname("Nickname")
//                .withParnter("Parnter").withSecondPhone("+7123 34-34")
//                .withCompanyName("Luxoft").withAddress("Updated Address line 1,\naddressline2")
//                .withHomePhone("38067842").withMobilePhone("35148").withWorkPhone("123").withFaxNumber("526541")
//                .withEmail("UpdatedEmail@gmail.com").withEmail2("testemail2@gmail.com").withEmail3("test3@yahoo.com").withNotes("Notes text...");
//        app.goTo().goToMainPage();
//        app.contact().modify(contact);
//        assertThat(app.contact().count(), equalTo(before.size()));
//        Contacts after = app.db().contacts();
//        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
//
//        verifyContactListInUI();
//    }
//
//
//}
