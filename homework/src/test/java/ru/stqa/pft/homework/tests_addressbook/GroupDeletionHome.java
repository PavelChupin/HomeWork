package ru.stqa.pft.homework.tests_addressbook;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupDeletionHome extends TestBase {

    /*public GroupDeletionHome(){
        super(BrowserType.IE);
    }
*/
    @BeforeMethod
    public void ensurePreconditions() {
/*
        //Установим браузер в котором запускать тест
        app.persone().setWd(new InternetExplorerDriver());
*/
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData()
                    .withName("HomeGroup2").withFooter("HomeGroup2").withHeader("HomeGroup2"));
        }
    }

    @Test
    public void homeGroupDeletion() {
        Groups before = app.group().all();
        //Сохраним объект, который планируется удалить
        GroupData deleteGroup = before.iterator().next();
        //int index = before.size() - 1;
        //Удаляем объект по его ссылке
        app.group().delete(deleteGroup);
        assertThat(app.group().count(),equalTo(before.size() - 1));
        Groups after = app.group().all();
        //Проверка совпадения длин списков
        //assertEquals(before.size() - 1, after.size());
        //assertThat(after.size(),equalTo(before.size() - 1));
        //Проверка совпадения наполнения списков
        //Удалим из первоночального списка удаленный элемент
        //before.remove(index);

        //Удалим из множества удаленный объект
        //before.remove(deleteGroup);
        assertThat(after, equalTo(before.without(deleteGroup)));
        //assertEquals(before, after);
    }

}
