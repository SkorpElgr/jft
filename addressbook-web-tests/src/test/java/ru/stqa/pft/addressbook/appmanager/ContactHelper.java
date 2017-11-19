package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void create() {
        initContactCreation();
        fillContactForm(new ContactData()
                .withFirstName("firstname").withMiddleName("middleName").withLastName("lastName")
                .withNickname("Nickname").withParnter("Parnter").withSecondPhone("123")
                .withCompanyName("Luxoft").withAddress("Some Address line 1,\naddressline2").withHomePhone("38067842")
                .withMobilePhone("35148").withFaxNumber("478461").withEmail("email@gmail.com").withAddress2("30215")
                .withNotes("Notes text...").withGroup("groupChangedName"), true);
        submitContactCreation();
        contactCache = null;
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        contactCache = null;
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModificationById(contact);
        fillContactForm(contact, false);
        contactCache = null;
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        clickJS(By.xpath("//input[@value='Delete']"));
        closeContactDeletionAlert();
        contactCache = null;
        goToMainPage();
    }

    public void initContactCreation() {
        clickJS(By.linkText("add new"));
    }

    public void submitContactModification() {
        clickJS(By.name("update"));
    }

    public void submitContactCreation() {
        clickJS(By.name("submit"));
    }


    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void closeContactDeletionAlert() {
        wd.switchTo().alert().accept();
    }


    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getParnter());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("fax"), contactData.getFaxNumber());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getSecondPhone());
        type(By.name("notes"), contactData.getNotes());
        attach(By.name("photo"), contactData.getPhoto());

        if (creation) {
            if ((calcSelectOption() > 1) && (contactData.getGroup() != null)) {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
                submitContactCreation();
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
            submitContactModification();
        }
        goToMainPage();
    }


    private int calcSelectOption() {
        return wd.findElements(By.xpath("//select[@name='new_group']//option")).size();
    }

    public void initContactModificationById(ContactData contact) {
        // wd.findElement(By.xpath("//input[@value='" + contact.getId() + "']/../../td[8]/a")).clickJS();
        int id = contact.getId();
        wd.findElement(By.xpath(String.format("//a[@href='edit.php?id=%s']", id))).click();
    }

    public int count() {
        return (wd.findElements(By.name("selected[]")).size());
    }

    public boolean isThereAnyGroup() {
        return (count() > 0);
    }

    //    public List<ContactData> list() {
//        isElementPresent(By.id("maintable"));
//        List<ContactData> contacts = new ArrayList<>();
//        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
//        for (WebElement element : elements) {
//            List<WebElement> contactInfo = element.findElements(By.xpath(".//td"));
//            String lastName = contactInfo.get(1).getText();
//            String firstName = contactInfo.get(2).getText();
//            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//            ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName);
//            contacts.add(contact);
//        }
//        return contacts;
//    }
    private Contacts contactCache = null;

    public Contacts all() {
        isElementPresent(By.id("maintable"));
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            List<WebElement> contactInfo = element.findElements(By.xpath(".//td"));
            String lastName = contactInfo.get(1).getText();
            String firstName = contactInfo.get(2).getText();
//            String[] phones = contactInfo.get(5).getText().split("\n");
            String allPhones = contactInfo.get(5).getText();
            String allEmails = contactInfo.get(4).getText();
            String address = contactInfo.get(3).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact);
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");

        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");

        wd.navigate().back();
        return (new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withSecondPhone(phone2)
                .withAddress(address)
                .withEmail(email).withEmail2(email2).withEmail3(email3));
    }
}
