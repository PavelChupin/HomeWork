package ru.stqa.pft.homework.tests_addressbook;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;
import ru.stqa.pft.homework.model.Persons;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

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
        if (app.persone().all().size() == 0) {
            app.persone().create(new PersonData()
                    .withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test"), true);
        }
    }

    @Test//(enabled = false)
    public void modificationPerson() {
        //Составим первоначальный список
        Persons beforePersonData = app.persone().all();
        PersonData modifyPerson = beforePersonData.iterator().next();
        //Сохраним индекс изменяемого элемента,
        //PersonData personData = new PersonData(beforePersonData.get(beforePersonData.size() - 1).getId(), "Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "", "1234");
        PersonData personData = new PersonData()
                .withId(modifyPerson.getId()).withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test");
        //int index = beforePersonData.size() - 1;
        app.persone().modify(personData);
        assertThat(app.persone().count(),equalTo(beforePersonData.size()));
        //Составим измененый список
        Persons afterPersonData = app.persone().all();
        //Проверка совпадения длин списков, длина до и после не зменяется так как мы делаем изменение записи в списке
        //assertEquals(afterPersonData.size(), beforePersonData.size());
        //assertThat(afterPersonData.size(),equalTo(beforePersonData.size()));
        //Проверка совпадения наполнения списков
        //Удалим из первоначального списка изменяемый элемент
        //beforePersonData.remove(modifyPerson);
        //Добавим в первоначальный список измененый элемент
        //beforePersonData.add(personData);

        //Упорядочим списки
        //Comparator<? super PersonData> byId = (p1, p2) -> Integer.compare(p1.getId(), p2.getId());
        //beforePersonData.sort(byId);
        //afterPersonData.sort(byId);

        //Сравнение списков делаем не по упорядоченному списку, для этого преобразуем упорядочный список в множество
        //Assert.assertEquals(new HashSet<Object>(afterPersonData), new HashSet<Object>(beforePersonData));

        //Сравним упорядочные списки
        //assertEquals(beforePersonData, afterPersonData);

        assertThat(afterPersonData, equalTo(beforePersonData.without(modifyPerson).withAdded(personData)));

    }



}
