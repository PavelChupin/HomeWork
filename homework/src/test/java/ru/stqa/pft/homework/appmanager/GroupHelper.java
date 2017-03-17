package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Summoner on 27.02.2017.
 */
public class GroupHelper extends HelperBase {

    private NavigationHelper navigationHelper;

    public GroupHelper(WebDriver wd, NavigationHelper navigationHelper) {
        super(wd);
        this.navigationHelper = navigationHelper;
    }

    public void returnGroupToPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        /*if (!findElement(By.xpath("//div[@id='content']/form/select//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select//option[1]"));
        }*/
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    /*
        public void selectGroup(int index) {
            wd.findElements(By.name("selected[]")).get(index).click();
            //click(By.name("selected[]"));
        }
    */
    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void selectGroupById(int id) {
        //wd.findElements(By.name("selected[]")).get(index).click();
        //click(By.name("selected[]"));
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }


    /*
        public void delete(int index) {
            selectGroup(index);
            deleteSelectedGroups();
            returnGroupToPage();
        }
        */
/*    public void creationGroupForPerson(GroupData groupData) {
        navigationHelper.groupPage();
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        returnGroupToPage();
    }
*/
    public boolean isThereGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    /*
        public List<GroupData> list() {
            List<GroupData> groups = new ArrayList<GroupData>();
            List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
            for(WebElement element : elements){
                String name = element.getText();
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                //GroupData group = new GroupData().withId(id).withName(name);
                groups.add(new GroupData().withId(id).withName(name));
            }
            return groups;
        }
    */
    //Заводим переменную для хранения кеша списка начитанного списка груп
    private Groups groupCache = null;

    public Groups all() {
        //Делаем предпроверку заполнености кеша. Если кеш списка групп не пустой то возвращаем на него ссылку при этом делаем копию, и выходим из метода.
        if (groupCache != null){
            return new Groups(groupCache);
        }
        //Инициализируем переменную кеша
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //GroupData group = new GroupData().withId(id).withName(name);
            //Добавим в кеш элемент группы
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        //Вернем копию списка групп
        return new Groups(groupCache);
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        //Так как состав групп изменился, то кеш уже не актуален сбросим его
        groupCache = null;
        returnGroupToPage();
    }

    public void create(GroupData groupData) {
        navigationHelper.groupPage();
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        //Так как состав групп изменился, то кеш уже не актуален сбросим его
        groupCache = null;
        returnGroupToPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        //Так как состав групп изменился, то кеш уже не актуален сбросим его
        groupCache = null;
        returnGroupToPage();
    }

}
