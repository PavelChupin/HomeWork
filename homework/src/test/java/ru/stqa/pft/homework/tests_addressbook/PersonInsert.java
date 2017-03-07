package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

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
        int max = 0;
        for (PersonData p : afterPersonDataList){
            if(p.getId() > max){
                max = p.getId();
            }
        }
        //Добавим хзначение максимального индекса в новый контакт
        personData.setId(max);
        //Добавим в первоночальный список нвый добавленный контакт
        beforePersonDataList.add(personData);

        //Проверка совпадения наполнения списков предварительно преобразовав их в множества
        Assert.assertEquals(new HashSet<Object>(afterPersonDataList), new HashSet<Object>(beforePersonDataList));
    }

}
