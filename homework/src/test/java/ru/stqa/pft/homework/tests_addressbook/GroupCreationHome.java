package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationHome extends TestBase {

    public GroupCreationHome(){
        super(BrowserType.FIREFOX);
    }

    @Test
    public void homeGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData groupData = new GroupData("HomeGroup1", "HomeGroup4", "HomeGroup5");
        app.getGroupHelper().creationGroup(groupData);

        List<GroupData> after = app.getGroupHelper().getGroupList();
        //Проверка совпадения длин списков, после добавления первоначальный список становиться длинее
        Assert.assertEquals(after.size(),before.size() + 1);

        //Найдем максимальный индетификатор равный новой группе
        int max = 0;
        for(GroupData g : after){
            if(g.getId() > max){
                max = g.getId();
            }
        }

        //Добавляем в старый список группу которую в результате теста мы добавляли
        groupData.setId(max);
        before.add(groupData);

        //Проверка совпадения наполнения списков, без учета порядка, ля этого оба списка в сравнении преобразуем ко множеству.
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }

}
