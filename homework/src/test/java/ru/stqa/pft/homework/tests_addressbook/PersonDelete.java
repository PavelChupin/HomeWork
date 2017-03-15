package ru.stqa.pft.homework.tests_addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;


import java.util.List;

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
        if (app.persone().list().size() == 0) {
            app.persone().create(new PersonData()
                    .withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test"), true);
        }
    }

    @Test//(enabled = false)//Отключить включить тест (enabled = false) или
    public void deletePerson() {
        List<PersonData> beforePersonDataList = app.persone().list();
        int index = beforePersonDataList.size() - 1;
        app.persone().delete(index);
        List<PersonData> afterPersonDataList = app.persone().list();
        //Проверка совпадения длин списков
        Assert.assertEquals(afterPersonDataList.size(), beforePersonDataList.size() - 1);

        //Проверка совпадения наполнения списков
        //Удалим из первоночального списка удаленный элемент
        beforePersonDataList.remove(index);
        Assert.assertEquals(afterPersonDataList, beforePersonDataList);
    }

}
