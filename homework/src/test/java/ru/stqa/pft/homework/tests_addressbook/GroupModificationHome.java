package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;

/**
 * Created by Summoner on 27.02.2017.
 */
public class GroupModificationHome extends TestBase {

    public GroupModificationHome(){
        super(BrowserType.CHROME);
    }

    @Test
    public void homeGroupModification (){
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereGroup()){
                app.getGroupHelper().creationGroup(new GroupData("HomeGroup3", "HomeGroup4", "HomeGroup5"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("HomeGroup3", "HomeGroup4", "HomeGroup5"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnGroupToPage();
    }
}
