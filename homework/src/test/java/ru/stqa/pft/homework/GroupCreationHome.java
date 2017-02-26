package ru.stqa.pft.homework;

import org.testng.annotations.Test;

public class GroupCreationHome extends TestBase {

    @Test
    public void homeGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("HomeGroup", "HomeGroup1", "HomeGroup2"));
        submitGroupCreation();
        returnGroupToPage();
    }

}
