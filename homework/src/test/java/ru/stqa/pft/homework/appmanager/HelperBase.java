package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Summoner on 27.02.2017.
 */
public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        //wd.findElement(locator).click();
        findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);

        if (text != null) { //Если поле к заполнению передано, то необходимо его изменить
            String existingText = findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                //wd.findElement(locator).clear();
                //wd.findElement(locator).sendKeys(text);
                findElement(locator).clear();
                findElement(locator).sendKeys(text);
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
        try{
            wd.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
        //return false;
    }

    protected WebElement findElement(By element) {
        return wd.findElement(element);
    }
}
