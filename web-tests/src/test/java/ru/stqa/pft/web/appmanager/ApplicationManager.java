package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 22.10.2017.
 */
public class ApplicationManager {
    Properties properties;
    WebDriver wd;
    JavascriptExecutor jse;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;
    private LocalStorage consoleHelper;
    private String browser;
//    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
     //   dbHelper = new DbHelper();

        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            System.setProperty("webdriver.ie.driver", "src/drivers/IEDriverServer.exe");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.introduceFlakinessByIgnoringSecurityDomains();
            options.ignoreZoomSettings();
            wd = new InternetExplorerDriver(options);
        }
        // wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla Firefox ESR/firefox.exe"));
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminPassword"), properties.getProperty("web.adminLogin"));
        contactHelper = new ContactHelper(wd);
        consoleHelper = new LocalStorage(wd);
        consoleHelper.setItemLocalStorage("wx-session", session().getSessionId());
        consoleHelper.setItemLocalStorage("wx-deviceId", session().getDeviceId());

    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
    public SessionHelper session() {
        return sessionHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public LocalStorage console() {
        return consoleHelper;
    }

//    public DbHelper db() {
//        return dbHelper;
//    }
}
