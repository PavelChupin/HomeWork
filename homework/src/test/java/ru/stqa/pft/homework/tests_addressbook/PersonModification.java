package ru.stqa.pft.homework.tests_addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Summoner on 27.02.2017.
 */
public class PersonModification extends TestBase {
    /*
        public PersonModification(){
            super(BrowserType.CHROME);
        }
    */
    @BeforeMethod  //Отрабатывает перед выполнением теста
    public void ensurePreconditions() {
        /*
        //Установим браузер в котором запускать тест
        app.setBrowser(BrowserType.CHROME);
        */
        app.goTo().homePage();
        if (app.persone().list().size() == 0) {
            app.persone().create(new PersonData()
                    .withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test"), true);
        }
    }

    @Test//(enabled = false)
    public void modificationPerson() {
        //Составим первоначальный список
        List<PersonData> beforePersonDataList = app.persone().list();
        //Сохраним индекс изменяемого элемента,
        //PersonData personData = new PersonData(beforePersonDataList.get(beforePersonDataList.size() - 1).getId(), "Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "", "1234");
        PersonData personData =  new PersonData()
                .withId(beforePersonDataList.get(beforePersonDataList.size() - 1).getId()).withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test");
        int index = beforePersonDataList.size() - 1;
        app.persone().modify(personData, index);
        //Составим измененый список
        List<PersonData> afterPersonDataList = app.persone().list();
        //Проверка совпадения длин списков, длина до и после не зменяется так как мы делаем изменение записи в списке
        Assert.assertEquals(afterPersonDataList.size(), beforePersonDataList.size());
        //Проверка совпадения наполнения списков
        //Удалим из первоначального списка изменяемый элемент
        beforePersonDataList.remove(index);
        //Добавим в первоначальный список измененый элемент
        beforePersonDataList.add(personData);

        //Упорядочим списки
        Comparator<? super PersonData> byId = (p1, p2) -> Integer.compare(p1.getId(), p2.getId());
        beforePersonDataList.sort(byId);
        afterPersonDataList.sort(byId);

        //Сравнение списков делаем не по упорядоченному списку, для этого преобразуем упорядочный список в множество
        //Assert.assertEquals(new HashSet<Object>(afterPersonDataList), new HashSet<Object>(beforePersonDataList));

        //Сравним упорядочные списки
        Assert.assertEquals(beforePersonDataList, afterPersonDataList);

    }

}
