package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void login(String password, String username) {
        type(By.name("pass"), password);
        type(By.name("user"), username);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
