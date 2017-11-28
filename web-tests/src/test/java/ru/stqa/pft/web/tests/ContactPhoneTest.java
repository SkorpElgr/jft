//package ru.stqa.pft.web.tests;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import ru.stqa.pft.web.model.ContactData;
//
//import java.util.Arrays;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//
///**
// * Created by Admin on 19.11.2017.
// */
//public class ContactPhoneTest extends TestBase {
//    @BeforeMethod
//    public void ensurePreconditions() {
//        app.goTo().goToMainPage();
//        if (app.contact().all().size() == 0) {
//            app.contact().create();
//        }
//    }
//
//    @Test
//    public void testContactPhone() {
//        app.goTo().goToMainPage();
//        ContactData contact = app.contact().all().iterator().next();
//        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
//
//        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
//        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
//        assertThat(contact.getAllEmails(), equalTo(mergeEmailsArray(contactInfoFromEditForm)));
//    }
//
//
//    public static String cleaned(String string) {
//        return (string.replaceAll("\\s", "").replaceAll("[-()]", ""));
//    }
//
//    private String mergePhones(ContactData contact) {
//        return Stream.of(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getSecondPhone()).filter((s) -> !s.equals(""))
//                .map(ContactPhoneTest::cleaned)
//                .collect(Collectors.joining("\n"));
//    }
//
//    private String mergeEmailStream(ContactData contact) {
//        return Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).filter((s) -> !s.equals(""))
//                .map(ContactPhoneTest::cleaned)
//                .collect(Collectors.joining("\n"));
//    }
//
//    private String mergeEmailsArray(ContactData contact) {
//        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
//                .stream().filter((s) -> !s.equals(""))
//                .collect(Collectors.joining("\n"));
//    }
//}
