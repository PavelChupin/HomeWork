package ru.stqa.pft.homework.tests_addressbook;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.Groups;
import sun.security.jgss.GSSCaller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationHome extends TestBase {



    /*public GroupCreationHome(){
        super(BrowserType.FIREFOX);
    }
*/
    //Создадим метод провайдер тестовых данных Xml
    @DataProvider
    public Iterator<Object[]> validGroupsFromXml() throws IOException {

        /*
        List<Object[]> list = new ArrayList<Object[]>();
        //Простой метод генерации данных
        list.add(new Object[]{new GroupData().withName("test1").withFooter("footer 1").withHeader("header 1")});
        list.add(new Object[]{new GroupData().withName("test2").withFooter("footer 2").withHeader("header 2")});
        list.add(new Object[]{new GroupData().withName("test3").withFooter("footer 3").withHeader("header 3")});
        return list.iterator();
        */
        /*
        List<Object[]> list = new ArrayList<Object[]>();
        //Получение тестовых данных из файла CSV
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line != null) {
            //Методом split дробим строку по регулярному выражению
            String[] split = line.split(";");
            list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
        */

        //Получение тестовых данных из файла XML используем библиотеку com.thoughtworks.xstream:xstream:1.4.9
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))){
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xStream = new XStream();
            xStream.processAnnotations(GroupData.class);
            List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
            //-----Конец начитки через xml
        }

    }

    //Создадим метод провайдер тестовых данных  Json
    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        //Получение тестовых данных из файла XML используем библиотеку com.thoughtworks.xstream:xstream:1.4.9
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))){
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType());
            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
            //-----Конец начитки через Json
        }

    }


    @Test(dataProvider = "validGroupsFromXml") //Подключаем провайдер тестовых данных
    public void homeGroupCreation(GroupData groupData) {


/*
        //Установим браузер в котором запускать тест
        app.persone().setWd(new FirefoxDriver());
*/
        app.goTo().groupPage();
        Groups before = app.group().all();
        /*
        GroupData groupData = new GroupData()
                .withName("HomeGroup2").withFooter("HomeGroup2").withHeader("HomeGroup2");
        */
        app.group().create(groupData);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();
        //Проверка совпадения длин списков, после добавления первоначальный список становиться длинее
        //assertEquals(after.size(), before.size() + 1);

        //assertThat(after.size(), equalTo(before.size() + 1));
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

        //Присвоим вновoь созданной группе новый идентификатор. Найдем максимальный идентификатор
        //groupData.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());

        //before.add(groupData);

        //Сортируем списки
        //Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        //before.sort(byId);
        //after.sort(byId);
        //Сравнения производим не по упорядоченному списку, а преобразуем его в множество
        //Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
        //Производим проверку по упорядоченному списку
        //assertEquals(before, after);
        assertThat(after, equalTo(
                before.withAdded(groupData.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


    }

    @Test(enabled = false)
    public void homeBadGroupCreation() {
/*
        //Установим браузер в котором запускать тест
        app.persone().setWd(new FirefoxDriver());
*/
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData groupData = new GroupData()
                .withName("HomeGroup2'").withFooter("HomeGroup2'").withHeader("HomeGroup2'");
        app.group().create(groupData);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }

}
