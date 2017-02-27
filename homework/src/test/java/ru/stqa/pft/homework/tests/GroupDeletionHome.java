package ru.stqa.pft.homework.tests;

import org.testng.annotations.Test;

public class GroupDeletionHome extends TestBase {

    @Test
    public void homeGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupToPage();
    }


}
