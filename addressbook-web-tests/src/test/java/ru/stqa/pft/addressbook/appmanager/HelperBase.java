package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) wd;
        if (!isElementPresent(locator)) {
            jse.executeScript("arguments[0].scrollIntoView()", wd.findElement(locator));
        } else {
            jse.executeScript("arguments[0].click()", wd.findElement(locator));
        }
    }

    protected void type(By locator, String text) {
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!existingText.equals(text)) {
                click(locator);
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            wd.findElement(locator);
            wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return true;
        } catch (NoSuchElementException ex) {
            wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return false;
        }
    }
}
