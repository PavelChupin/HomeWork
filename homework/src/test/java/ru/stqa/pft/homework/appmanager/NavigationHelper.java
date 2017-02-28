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
        click(By.linkText("groups"));
    }

    public void gotoAddNewPage() {
        click(By.linkText("add new"));
    }

    public void gotoHomePage() {
        click(By.linkText("home"));
    }
}
