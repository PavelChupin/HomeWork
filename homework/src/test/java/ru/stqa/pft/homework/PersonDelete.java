package ru.stqa.pft.homework;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PersonDelete extends TestBase {

    
    @Test
    public void deletePerson() {
        wd.findElement(By.linkText("home")).click();
        wd.findElement(By.name("selected[]")).click();
        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
        wd.switchTo().alert().accept();
    }

}
