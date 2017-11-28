package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LocalStorage extends HelperBase {

    private JavascriptExecutor jse;
    public LocalStorage(WebDriver wd) {
        super(wd);
        this.jse = (JavascriptExecutor) wd;
    }

    public void setItemLocalStorage(String item, String value){
        jse.executeScript(String.format(
                "window.localStorage.setItem('%s','%s');", item, value));
    }

    public String getItemFromLocalStorage(String key){
        return (String) jse.executeScript(String.format("return window.localStorage.getItem('%s');"), key);
    }

    public void removeItemFromLocalStorage(String item) {
        jse.executeScript(String.format(
                "window.localStorage.removeItem('%s');", item));
    }

    public boolean isItemPresentInLocalStorage(String item) {
        return !(jse.executeScript(String.format(
                "return window.localStorage.getItem('%s');", item)) == null);
    }

    public String getKeyFromLocalStorage(int key) {
        return (String) jse.executeScript(String.format(
                "return window.localStorage.key('%s');", key));
    }

    public Long getLocalStorageLength() {
        return (Long) jse.executeScript("return window.localStorage.length;");
    }

    public void clearLocalStorage() {
        jse.executeScript(String.format("window.localStorage.clear();"));
    }

}
