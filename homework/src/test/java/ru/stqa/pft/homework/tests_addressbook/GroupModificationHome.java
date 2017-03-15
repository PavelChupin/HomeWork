package ru.stqa.pft.homework.tests_addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Summoner on 27.02.2017.
 */
public class GroupModificationHome extends TestBase {

    /*public GroupModificationHome(){
        super(BrowserType.CHROME);
    }
*/
    @BeforeMethod
    public void ensurePreconditions() {
/*
        //Установим браузер в котором запускать тест
        app.persone().setWd(new ChromeDriver());
*/
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupData()
                    .withName("HomeGroup2"));
        }
    }

    @Test
    public void homeGroupModification (){
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        //Для того чтобы помнить какой элемент изменили в модель данных сохраним ID изменяемого элемента
        GroupData groupData = new GroupData()
                .withId(before.get(index).getId()).withName("HomeGroup2").withFooter("HomeGroup2").withHeader("HomeGroup2");
        //Метод изменения перенесли в GroupHelper
        app.group().modify(index, groupData);

        List<GroupData> after = app.group().list();
        //Проверка совпадения длин списков
        Assert.assertEquals(before.size(),after.size());

        //Проверка совпадения наполнения списков
        //Удаляем из списка элемент который изменяем
        before.remove(index);
        //Добавляем в список элемент на который изменили
        before.add(groupData);

        //Сортируем списки
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        //Сравнения производим не по упорядоченному списку, а преобразуем его в множество
        //Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
        //Производим проверку по упорядоченному списку
        Assert.assertEquals(before,after);
    }




}
