package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddContact {
    FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        // wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla Firefox ESR/firefox.exe"));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        logInAddressBook("secret", "admin");
    }

    public void logInAddressBook(String password, String username) {
        wd.get("http://localhost/addressbook/");
        clickAndClear("pass");
        getElementByName("pass").sendKeys(password);
        clickAndClear("user");
        getElementByName("user").sendKeys(username);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(new ContactData("firstname", "middleName",
                "lastName", "Nickname", "Parnter",
                "no second house", "Luxoft",
                "Some Address line 1,\naddressline2", "38067842",
                "35148", "526541", "478461",
                "email@gmail.com", "30215", "Notes text..."));
        submitContactCreation();
    }

    private void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    private void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillContactForm(ContactData contactData) {
        clickAndClear("firstname");
        getElementByName("firstname").sendKeys(contactData.getFirstName());
        clickAndClear("middlename");
        getElementByName("middlename").sendKeys(contactData.getMiddleName());
        clickAndClear("lastname");
        getElementByName("lastname").sendKeys(contactData.getLastName());
        clickAndClear("nickname");
        getElementByName("nickname").sendKeys(contactData.getNickname());
        clickAndClear("title");
        getElementByName("title").sendKeys(contactData.getParnter());
        clickAndClear("company");
        getElementByName("company").sendKeys(contactData.getCompanyName());
        clickAndClear("address");
        getElementByName("address").sendKeys(contactData.getAddress());
        clickAndClear("home");
        getElementByName("home").sendKeys(contactData.getHomePhone());
        clickAndClear("mobile");
        getElementByName("mobile").sendKeys(contactData.getMobilePone());
        clickAndClear("work");
        getElementByName("work").sendKeys(contactData.getWorkPhone());
        clickAndClear("fax");
        getElementByName("fax").sendKeys(contactData.getFaxNumber());
        clickAndClear("email");
        getElementByName("email").sendKeys(contactData.getEmail());
        clickAndClear("address2");
        getElementByName("address2").sendKeys(contactData.getAddress2());
        clickAndClear("phone2");
        getElementByName("phone2").sendKeys(contactData.getSecondPhone());
        clickAndClear("notes");
        getElementByName("notes").sendKeys(contactData.getNotes());

    }

    private void clickAndClear(String name) {
        getElementByName(name).click();
        getElementByName(name).clear();
    }

    private WebElement getElementByName(String name) {
        return wd.findElement(By.name(name));
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
