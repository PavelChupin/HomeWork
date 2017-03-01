package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;

public class GroupCreationHome extends TestBase {

    public GroupCreationHome(){
        super(BrowserType.FIREFOX);
    }

    @Test
    public void homeGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().creationGroup(new GroupData("HomeGroup", "HomeGroup1", "HomeGroup2"));
        /*app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("HomeGroup", "HomeGroup1", "HomeGroup2"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnGroupToPage();
        */
    }

}
