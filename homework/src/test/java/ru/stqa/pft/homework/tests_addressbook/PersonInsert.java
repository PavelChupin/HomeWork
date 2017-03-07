package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class PersonInsert extends TestBase {

    public PersonInsert(){
        super(BrowserType.FIREFOX);
    }

    @Test
    public void insertPerson() {
        app.getNavigationHelper().gotoHomePage();
        List<PersonData> beforePersonDataList = app.getPersonHelper().getPersoneDataList();
        PersonData personData = new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "","1234");
        app.getPersonHelper().insertPerson(personData,true);
        List<PersonData> afterPersonDataList = app.getPersonHelper().getPersoneDataList();
        //Проверка совпадения длин списков
        Assert.assertEquals(afterPersonDataList.size(), beforePersonDataList.size() + 1);

        //Найдем и установим новый индекс для нового элемента
       /* int max = 0;
        for (PersonData p : afterPersonDataList){
            if(p.getId() > max){
                max = p.getId();
            }
        }*/
        //Добавим хзначение максимального индекса в новый контакт
       // Comparator<? super PersonData> byId = (Comparator<PersonData>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
       // int max1 = afterPersonDataList.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
        //personData.setId(afterPersonDataList.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        //Добавим в первоночальный список нвый добавленный контакт
        beforePersonDataList.add(personData);

        //Упорядочим списки
        Comparator<? super PersonData> byId = (p1, p2) -> Integer.compare(p1.getId(), p2.getId());
        beforePersonDataList.sort(byId);
        afterPersonDataList.sort(byId);

        //Сравнение списков делаем не по упорядоченному списку, для этого преобразуем упорядочный список в множество
        //Assert.assertEquals(new HashSet<Object>(afterPersonDataList), new HashSet<Object>(beforePersonDataList));

        //Сравним упорядочные списки
        Assert.assertEquals(beforePersonDataList,afterPersonDataList);
    }

}
