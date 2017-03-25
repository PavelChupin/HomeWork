package ru.stqa.pft.homework.generators;

import ru.stqa.pft.homework.model.GroupData;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Summoner on 25.03.2017.
 */
public class GroupDataGenerator {
    //Класс запускаемый поэтому делаем метод запуска
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<GroupData> groups = generateGroups(count);
        save(groups, file);
    }

    private static void save(List<GroupData> groups, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        //Запись данных в файл
        Writer writer = new FileWriter(file);
        for (GroupData group : groups){
            //Запись производим по формату  %s;%s;%s
            writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        //Закрыть файл
        writer.close();
    }

    private static List generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();
        for (int i = 0;i < count;i++){
            groups.add(new GroupData().withName(String.format("test %s", i)).withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
