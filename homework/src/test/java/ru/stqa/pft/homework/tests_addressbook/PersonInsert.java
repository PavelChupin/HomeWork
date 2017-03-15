package ru.stqa.pft.homework.tests_addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

import java.util.Set;

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
        Set<PersonData> beforePersonDataList = app.persone().all();
        PersonData personData = new PersonData()
                .withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test");
        app.persone().create(personData, true);
        Set<PersonData> afterPersonDataList = app.persone().all();
        //Проверка совпадения длин списков
        Assert.assertEquals(afterPersonDataList.size(), beforePersonDataList.size() + 1);

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
        personData.withId(afterPersonDataList.stream().mapToInt((p) -> p.getId()).max().getAsInt());

        //Добавим в первоночальный список нвый добавленный контакт
        beforePersonDataList.add(personData);

        //Упорядочим списки
        //Comparator<? super PersonData> byId = (p1, p2) -> Integer.compare(p1.getId(), p2.getId());
        //beforePersonDataList.sort(byId);
        //afterPersonDataList.sort(byId);

        //Сравнение списков делаем не по упорядоченному списку, для этого преобразуем упорядочный список в множество
        //Assert.assertEquals(new HashSet<Object>(afterPersonDataList), new HashSet<Object>(beforePersonDataList));

        //Сравним упорядочные списки
        Assert.assertEquals(beforePersonDataList, afterPersonDataList);
    }

}
