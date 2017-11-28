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
//public class ContactDeletionTests extends TestBase {
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
//    public void testContactDeletion() {
//        Contacts before = app.db().contacts();
//        ContactData deletedContact = before.iterator().next();
//        app.goTo().goToMainPage();
//        app.contact().delete(deletedContact);
//        assertThat(app.contact().count(), equalTo(before.size() - 1));
//        Contacts after = app.db().contacts();
//        assertThat(after, equalTo(before.without(deletedContact)));
//    }
//}
