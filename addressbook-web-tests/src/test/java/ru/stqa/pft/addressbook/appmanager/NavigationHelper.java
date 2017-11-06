package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {
        String groupPageUrl = "http://localhost/addressbook/group.php";
        if (!wd.getCurrentUrl().equals(groupPageUrl)) {
            click(By.linkText("groups"));
        }
    }

}
