package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.tests_addressbook.GroupCreationHome;

import java.util.ArrayList;
import java.util.List;

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
        if (!findElement(By.xpath("//div[@id='content']/form/select//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select//option[1]"));
        }
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        //click(By.name("selected[]"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void creationGroup(GroupData groupData) {
        navigationHelper.gotoGroupPage();
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        returnGroupToPage();
    }

/*    public void creationGroupForPerson(GroupData groupData) {
        navigationHelper.gotoGroupPage();
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        returnGroupToPage();
    }
*/
    public boolean isThereGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element : elements){
            String name = element.getText();
            GroupData group = new GroupData(name, null, null);
            groups.add(group);
        }
        return groups;
    }
}
