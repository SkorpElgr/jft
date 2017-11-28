//package ru.stqa.pft.web.tests;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import ru.stqa.pft.web.model.ContactData;
//import ru.stqa.pft.web.model.Contacts;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class ContactCreationTests extends TestBase {
//
//    @DataProvider
//    public Iterator<Object[]> validContactsFromJson() throws IOException {
//        try (BufferedReader reader = new BufferedReader(new FileReader(
//                new File("src/test/resources/contacts.json")))) {
//            String json = "";
//            String line = reader.readLine();
//            while (line != null) {
//                json += line;
//                line = reader.readLine();
//            }
//            Gson gson = new Gson();
//            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
//            }.getType()); //List<GroupDate>.class
//            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
//        }
//    }
//
//    @Test(dataProvider = "validContactsFromJson")
//    public void testContactCreation(ContactData contact) {
//        Contacts before = app.db().contacts();
//        app.goTo().goToMainPage();
//        app.contact().create(contact);
//        assertThat(app.contact().count(), equalTo(before.size() + 1));
//        Contacts after = app.db().contacts();
//        assertThat(after, equalTo(
//                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
//    }
//
//    @Test(enabled = false)
//    public void testCurrentDir() {
//        File currentDir = new File(".");
//        System.out.println(currentDir.getAbsolutePath());
//        File photo = new File("src/test/resources/steelRat.jpg");
//        System.out.println(photo.getAbsolutePath());
//        System.out.println(photo.exists());
//    }
//}
