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
                .withNickname("Nickname").withParnter("Parnter").withSecondPhone("no second house")
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
        initContactModification(contact);
        fillContactForm(contact, false);
        contactCache = null;
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        click(By.xpath("//input[@value='Delete']"));
        closeContactDeletionAlert();
        contactCache = null;
        goToMainPage();
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
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
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getSecondPhone());
        type(By.name("notes"), contactData.getNotes());

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

    public void initContactModification(ContactData contact) {
        wd.findElement(By.xpath("//td/input[@value='" + contact.getId() + "']/../../td[8]/a")).click();

    }

    public int getContactCount() {
        return (wd.findElements(By.name("selected[]")).size());
    }

    public boolean isThereAnyGroup() {
        return (getContactCount() > 0);
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
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
        }
        return new Contacts(contactCache);
    }

}
