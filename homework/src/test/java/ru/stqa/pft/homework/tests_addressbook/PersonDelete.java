package ru.stqa.pft.homework.tests_addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

import java.util.Set;

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
        Set<PersonData> beforePersonData = app.persone().all();
        //int index = beforePersonData.size() - 1;
        PersonData deletePerson = beforePersonData.iterator().next();
        //Удаляем объект по его ссылке
        app.persone().delete(deletePerson);

        Set<PersonData> afterPersonData = app.persone().all();
        //Проверка совпадения длин списков
        Assert.assertEquals(afterPersonData.size(), beforePersonData.size() - 1);

        //Проверка совпадения наполнения списков
        //Удалим из первоночального списка удаленный элемент
        beforePersonData.remove(deletePerson);

        Assert.assertEquals(afterPersonData, beforePersonData);
    }

}
