package ru.stqa.pft.homework.tests_addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Summoner on 17.03.2017.
 */
public class PersonPhone extends TestBase {

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

    @Test
    public void phonePerson() {
        app.goTo().homePage();
        PersonData person = app.persone().all().iterator().next();
        PersonData personInfoFromEditForm = app.persone().infoFromEditForm(person);
        assertThat(person.getAllPhones(), equalTo(mergePhones(personInfoFromEditForm)));
        //assertThat(person.getAllPhones(), equalTo(cleaned(personInfoFromEditForm.getMobilephone())));
        //assertThat(person.getAllPhones(), equalTo(cleaned(personInfoFromEditForm.getWorkphone())));
        //assertThat(person.getAllPhones(), equalTo(cleaned(personInfoFromEditForm.getPhone2())));
    }

    private String mergePhones(PersonData person) {
        return Arrays.asList(person.getHomephone(),person.getMobilephone(), person.getWorkphone(), person.getPhone2())
                .stream().filter((s) -> ! s.equals(""))
                .map(PersonPhone::cleaned)
                .collect(Collectors.joining("\n"));

    }

    //Функция очистки не нужных символов
    public static String cleaned (String phone){
        //s - заменить все пробелы и переводы строки
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

}
