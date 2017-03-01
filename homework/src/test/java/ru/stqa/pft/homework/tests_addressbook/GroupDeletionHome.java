package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;

public class GroupDeletionHome extends TestBase {

    public GroupDeletionHome(){
        super(BrowserType.IE);
    }

    @Test
    public void homeGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereGroup()){
            app.getGroupHelper().creationGroup(new GroupData("HomeGroup3", "HomeGroup4", "HomeGroup5"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupToPage();
    }


}
