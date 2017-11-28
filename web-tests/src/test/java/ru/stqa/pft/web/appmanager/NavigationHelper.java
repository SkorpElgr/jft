package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {
        String groupPageUrl = "http://localhost/web/group.php";
        if (!wd.getCurrentUrl().equals(groupPageUrl)) {
            click(By.linkText("groups"));
        }
    }

}
