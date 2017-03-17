package ru.stqa.pft.homework.tests_addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;
import ru.stqa.pft.homework.model.Persons;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonInsert extends TestBase {
    /*
        public PersonInsert(){
            super(BrowserType.FIREFOX);
        }
    */
    @Test//(enabled = false)
    public void insertPerson() {
        /*
        //Установим браузер в котором запускать тест
        app.setBrowser(BrowserType.FIREFOX);
        */
        app.goTo().homePage();
        Persons beforePersonData = app.persone().all();
        PersonData personData = new PersonData()
                .withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test");
        app.persone().create(personData, true);
        assertThat(app.persone().count(), equalTo(beforePersonData.size() + 1));
        Persons afterPersonData = app.persone().all();
        //Проверка совпадения длин списков
        //assertEquals(afterPersonDataList.size(), beforePersonData.size() + 1);
        //assertThat(afterPersonData.size(), equalTo(beforePersonData.size() + 1));
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

        //Присвоим вновь созданной группе новый идентификатор. Найдем максимальный идентификатор
        //personData.withId(afterPersonData.stream().mapToInt((p) -> p.getId()).max().getAsInt());

        //Добавим в первоночальный список нвый добавленный контакт
        //beforePersonData.add(personData);

        //Упорядочим списки
        //Comparator<? super PersonData> byId = (p1, p2) -> Integer.compare(p1.getId(), p2.getId());
        //beforePersonData.sort(byId);
        //afterPersonDataList.sort(byId);

        //Сравнение списков делаем не по упорядоченному списку, для этого преобразуем упорядочный список в множество
        //Assert.assertEquals(new HashSet<Object>(afterPersonDataList), new HashSet<Object>(beforePersonData));

        //Сравним упорядочные списки
        //assertEquals(beforePersonData, afterPersonDataList);
        assertThat(afterPersonData, equalTo(
                beforePersonData.withAdded(personData.withId(afterPersonData.stream().mapToInt((p) -> p.getId()).max().getAsInt()))));
    }

    @Test//(enabled = false)
    public void insertBadPerson() {
        /*
        //Установим браузер в котором запускать тест
        app.setBrowser(BrowserType.FIREFOX);
        */
        app.goTo().homePage();
        Persons beforePersonData = app.persone().all();
        PersonData personData = new PersonData()
                .withFirstname("Pavel'").withLastname("Chupin'").withNickname("PavelChupin'").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test");
        app.persone().create(personData, true);
        assertThat(app.persone().count(), equalTo(beforePersonData.size()));
        Persons afterPersonData = app.persone().all();
        assertThat(afterPersonData, equalTo(beforePersonData));
    }

}
