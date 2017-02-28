package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Summoner on 27.02.2017.
 */
public class NavigationHelper extends HelperBase {
    //private FirefoxDriver wd;

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void gotoAddNewPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void gotoHomePage() {
        wd.findElement(By.linkText("home")).click();
    }
}
