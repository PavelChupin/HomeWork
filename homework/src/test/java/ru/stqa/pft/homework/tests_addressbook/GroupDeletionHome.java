package ru.stqa.pft.homework.tests_addressbook;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;
import java.util.List;

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
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupToPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        //Проверка совпадения длин списков
        Assert.assertEquals(before.size() - 1,after.size());

        //Проверка совпадения наполнения списков
        //Удалим из первоночального списка удаленный элемент
        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);
    }


}
