package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Summoner on 27.02.2017.
 */
public class PersonModification extends TestBase {

    public PersonModification(){
        super(BrowserType.CHROME);
    }

    @Test
    public void modificationPerson(){
        if (! app.getPersonHelper().isTherePersone()){
            app.getPersonHelper().insertPerson(new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "", "test"),true);
        }
        app.getNavigationHelper().gotoHomePage();

        //Составим первоначальный список
        List<PersonData> beforePersonDataList = app.getPersonHelper().getPersoneDataList();

        //Выбрать кнкретную запись
        app.getPersonHelper().selectPerson(beforePersonDataList.size() - 1);

        //Так как кнопок редактирования тоже несколько, то нужно нажать правильную
        app.getPersonHelper().initPersonModification(beforePersonDataList.size() - 1);
        //Сохраним индекс изменяемого элемента,
        PersonData personData = new PersonData(beforePersonDataList.get(beforePersonDataList.size() - 1).getId(), "Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "","1234");
        app.getPersonHelper().fillPersonForm(personData,false);
        app.getPersonHelper().submitPersonModification();
        app.getNavigationHelper().gotoHomePage();

        //Составим измененый список
        List<PersonData> afterPersonDataList = app.getPersonHelper().getPersoneDataList();
        //Проверка совпадения длин списков, длина до и после не зменяется так как мы делаем изменение записи в списке
        Assert.assertEquals(afterPersonDataList.size(), beforePersonDataList.size());


        //Проверка совпадения наполнения списков
        //Удалим из первоначального списка изменяемый элемент
        beforePersonDataList.remove(beforePersonDataList.size() - 1);
        //Добавим в первоначальный список измененый элемент
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
