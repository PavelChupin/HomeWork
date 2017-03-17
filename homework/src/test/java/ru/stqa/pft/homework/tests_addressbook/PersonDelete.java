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

public class PersonDelete extends TestBase {
    /*
        public PersonDelete(){
            super(BrowserType.IE);
        }
    */
    @BeforeMethod  //Отрабатывает перед выполнением теста
    public void ensurePreconditions() {
       /*
        //Установим браузер в котором запускать тест
        app.setBrowser(BrowserType.IE);
        */
        app.goTo().homePage();
        if (app.persone().all().size() == 0) {
            app.persone().create(new PersonData()
                    .withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test"), true);
        }
    }

    @Test//(enabled = false)//Отключить включить тест (enabled = false) или
    public void deletePerson() {
        Persons beforePersonData = app.persone().all();
        //int index = beforePersonData.size() - 1;
        PersonData deletePerson = beforePersonData.iterator().next();
        //Удаляем объект по его ссылке
        app.persone().delete(deletePerson);
        assertThat(app.persone().count(),equalTo(beforePersonData.size() - 1));
        Persons afterPersonData = app.persone().all();
        //Проверка совпадения длин списков
        //assertEquals(afterPersonData.size(), beforePersonData.size() - 1);

        //assertThat(afterPersonData.size(),equalTo(beforePersonData.size() - 1));
        //Проверка совпадения наполнения списков
        //Удалим из первоночального списка удаленный элемент
        //beforePersonData.remove(deletePerson);

        assertThat(afterPersonData, equalTo(beforePersonData.without(deletePerson)));
        //assertEquals(afterPersonData, beforePersonData);
    }

}
