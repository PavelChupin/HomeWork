package ru.stqa.pft.homework.tests_addressbook;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Summoner on 17.03.2017.
 */
public class PersonAllData extends TestBase{

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
    public void dataPersonAll(){
        app.goTo().homePage();
        PersonData person = app.persone().all().iterator().next();
        PersonData personInfoFromEditForm = app.persone().infoFromDetailForm(person);

        //String a = cleanedAll(personInfoFromEditForm.getAllPersonData());
        //String b = person.getFirstname().concat(person.getLastname()).concat(person.getAddress()).concat(cleanedPhone2(person.getAllPhones(),person.getPhone2())).concat(cleanedEmails(person.getAllEmail())).concat(person.getPhone2());
        /*
        assertThat(person.getFirstname(), equalTo(cleaned(personInfoFromEditForm.getAllPersonData()));
        assertThat(person.getFirstname(), equalTo(personInfoFromEditForm.getFirstname()));
        assertThat(person.getLastname(), equalTo(personInfoFromEditForm.getLastname()));
        assertThat(person.getAllPhones(), equalTo(personInfoFromEditForm.getAllPhones()));
        assertThat(person.getAddress(), equalTo(personInfoFromEditForm.getAddress()));
        assertThat(person.getAllEmail(), equalTo(personInfoFromEditForm.getAllEmail()));
*/
        assertThat(cleanedAll(personInfoFromEditForm.getAllPersonData())
                ,equalTo(person.getFirstname().concat(person.getLastname()).concat(person.getAddress().replaceAll("\\s+",""))
                        .concat(cleanedPhone2(person.getAllPhones(),person.getPhone2())).concat(cleanedEmails(person.getAllEmail())).concat(person.getPhone2())));
    }

    public static String cleanedAll(String allPersonData){
        return allPersonData.replaceAll("H:","").replaceAll("M:","").replaceAll("W:","").replaceAll("P:","").replaceAll("\\s","").replaceAll("[()]","");
    }

    public static String cleanedPhone2(String allPhone, String phone){
        return allPhone.replaceAll(phone,"").replaceAll("\\s","").replaceAll("[-()]","");
    }

    public static String cleanedEmails(String emails){
        return emails.replaceAll("\\s","");
    }
}
