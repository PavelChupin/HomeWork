package ru.stqa.pft.homework.tests_addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationHome extends TestBase {

    /*public GroupCreationHome(){
        super(BrowserType.FIREFOX);
    }
*/
    @Test
    public void homeGroupCreation() {
/*
        //Установим браузер в котором запускать тест
        app.persone().setWd(new FirefoxDriver());
*/
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        GroupData groupData = new GroupData()
                .withName("HomeGroup2").withFooter("HomeGroup2").withHeader("HomeGroup2");
        app.group().create(groupData);
        List<GroupData> after = app.group().list();
        //Проверка совпадения длин списков, после добавления первоначальный список становиться длинее
        Assert.assertEquals(after.size(),before.size() + 1);

        //Найдем максимальный индетификатор равный новой группе
        /*int max = 0;
        for(GroupData g : after){
            if(g.getId() > max){
                max = g.getId();
            }
        }
*/
        //Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        //int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        //Добавляем в старый список группу которую в результате теста мы добавляли
        //groupData.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
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
