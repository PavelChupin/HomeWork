package ru.stqa.pft.homework.tests_addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;
import java.util.List;

public class GroupDeletionHome extends TestBase {

    /*public GroupDeletionHome(){
        super(BrowserType.IE);
    }
*/
    @BeforeMethod
    public void ensurePreconditions() {
/*
        //Установим браузер в котором запускать тест
        app.persone().setWd(new InternetExplorerDriver());
*/
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupData()
                    .withName("HomeGroup2").withFooter("HomeGroup2").withHeader("HomeGroup2"));
        }
    }

    @Test
    public void homeGroupDeletion() {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        //Проверка совпадения длин списков
        Assert.assertEquals(before.size() - 1,after.size());

        //Проверка совпадения наполнения списков
        //Удалим из первоночального списка удаленный элемент
        before.remove(index);
        Assert.assertEquals(before,after);
    }

}
