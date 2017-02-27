package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.homework.model.LoginData;

/**
 * Created by Summoner on 27.02.2017.
 */
public class SessionHelper extends HelperBase {
    //private FirefoxDriver wd;

    public SessionHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void login(LoginData loginData) {
        type(By.name("user"),loginData.getUsername());
        type(By.name("pass"),loginData.getPassword());
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
