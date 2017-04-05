package ru.stqa.pft.homework.tests_addressbook;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.Groups;
import ru.stqa.pft.homework.model.Persons;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

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
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData()
                    .withName("HomeGroup2").withFooter("HomeGroup2").withHeader("HomeGroup2"));
        }
/*
        //Установим браузер в котором запускать тест
        app.persone().setWd(new ChromeDriver());
*/
/*
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData()
                    .withName("HomeGroup2"));
        }
        */
    }

    @Test
    public void homeGroupModification() {
        //Меняем получение списка груп с начитки с интерфейса на начитку из базы
        //Groups before = app.group().all();
        Groups before = app.db().groups();
        //---------------------------

        GroupData modifiedGroup = before.iterator().next();
        //int index = before.size() - 1;
        //Для того чтобы помнить какой элемент изменили в модель данных сохраним ID изменяемого элемента
        GroupData groupData = new GroupData()
                .withId(modifiedGroup.getId()).withName("HomeGroup4").withFooter("HomeGroup2").withHeader("HomeGroup2");
        //Метод изменения перенесли в GroupHelper
        app.goTo().groupPage();
        app.group().modify(groupData);
        assertThat(app.group().count(),equalTo(before.size()));

        //Меняем получение списка груп с начитки с интерфейса на начитку из базы
        //Groups after = app.group().all();
        Groups after = app.db().groups();
        //---------------------------

        //Проверка совпадения длин списков
        //assertEquals(before.size(), after.size());
        //assertThat(before.size(),equalTo(after.size()));
        //Проверка совпадения наполнения списков
        //Удаляем из списка элемент который изменяем
        //before.remove(modifiedGroup);
        //Добавляем в список элемент на который изменили
        //before.add(groupData);

        //Сортируем списки
        //Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        //before.sort(byId);
        //after.sort(byId);
        //Сравнения производим не по упорядоченному списку, а преобразуем его в множество
        //Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
        //Производим проверку по упорядоченному списку
        //assertEquals(before, after);
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(groupData)));
    }


}
