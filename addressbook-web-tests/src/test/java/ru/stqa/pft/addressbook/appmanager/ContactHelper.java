package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void create() {
        initContactCreation();
        fillContactForm(new ContactData("firstname", "middleName",
                "lastName", "Nickname", "Parnter",
                "no second house", "Luxoft",
                "Some Address line 1,\naddressline2", "38067842",
                "35148", "526541", "478461",
                "email@gmail.com", "30215", "Notes text...", "test1"), true);
        submitContactCreation();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void delete() {
        click(By.xpath("//input[@value='Delete']"));
        closeContactDeletionAlert();
        goToMainPage();
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

    public void initContactModification(int index) {
        wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
    }

    public int getContactCount() {
        return (wd.findElements(By.name("selected[]")).size());
    }

    public boolean isThereAnyGroup() {
        return (getContactCount() > 0);
    }

    public List<ContactData> list() {
        isElementPresent(By.id("maintable"));
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            List<WebElement> contactInfo = element.findElements(By.xpath(".//td"));
            String lastName = contactInfo.get(1).getText();
            String firstName = contactInfo.get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, firstName, lastName);
            contacts.add(contact);
        }
        return contacts;
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
    }

    public void modify(int index, ContactData contact) {
        select(index);
        initContactModification(index);
        fillContactForm(contact, false);
    }
}
