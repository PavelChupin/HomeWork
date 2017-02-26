package ru.stqa.pft.homework;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionHome extends TestBase {

    @Test
    public void homeGroupDeletion() {
        wd.findElement(By.linkText("groups")).click();
        wd.findElement(By.name("selected[]")).click();
        wd.findElement(By.name("delete")).click();
        wd.findElement(By.linkText("group page")).click();
    }
    

}
