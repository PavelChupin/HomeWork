package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.*;

import java.io.File;

/**
 * Created by Summoner on 27.02.2017.
 */
public class HelperBase {
    protected WebDriver wd;
    protected ApplicationManager app;

    public HelperBase(ApplicationManager app) {
        this.wd = app.getDriver();
        this.app = app;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
            click(locator);
        if (text != null) { //Если поле к заполнению передано, то необходимо его изменить
            String existingText = wd.findElement(locator).getAttribute("value");
            //Если существующее значение не равно переданному, то изменяем его
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);

            }
        }
    }

    protected void attach(By locator, File file) {
        if (file != null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
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
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
        //return false;
    }
/*
    protected WebElement findElement(By element) {
        return wd.findElement(element);
    }*/
}
