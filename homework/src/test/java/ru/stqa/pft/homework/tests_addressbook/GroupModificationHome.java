package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;

import java.util.HashSet;
import java.util.List;

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
                app.getGroupHelper().creationGroup(new GroupData("HomeGroup1", "HomeGroup4", "HomeGroup5"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        //Для того чтобы помнить какой элемент изменили в модель данных сохраним ID изменяемого элемента
        GroupData groupData = new GroupData(before.get(before.size() - 1).getId(),"HomeGroup1", "HomeGroup4", "HomeGroup5");
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnGroupToPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();
        //Проверка совпадения длин списков
        Assert.assertEquals(before.size(),after.size());

        //Проверка совпадения наполнения списков
        //Удаляем из списка элемент который изменяем
        before.remove(before.size() - 1);
        //Добавляем в список элемент на который изменили
        before.add(groupData);
        //Сравнения производим не по упорядоченному списку, а преобразуем его в множество
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
