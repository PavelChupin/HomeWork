package ru.stqa.pft.sandbox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Summoner on 05.03.2017.
 */
public class Collections {
    public static void main (String[] args){

        String[] langs = {"Java","C#","Python","PHP"};
        //interface Collection<E>  описывает произвольные коллекции
        //interface List<E> описывает упорядоченные коллекции (массивы) возможен поиск по индексу. Может содержать одинаковые элементы
        //interface Set<E> описывает коллекции множества, но нельзя выполнить поиск по индексу. В множестве все элементы уникальны и не могут повторяться. Если добавить уже существующий элемент то состав останется не изменным.


        //Первый вариант объявления коллекции и добавления в нее значений
        //List<String> languages = new ArrayList<String>();
        //languages.add("Java");
        //languages.add("C#");
        //languages.add("Python");
        //Конец первого варианта


        //Второй вариант объявления коллекции и добавления в нее значений
        List<String> languages = Arrays.asList("Java","C#","Python","PHP");
        //Конец второго варианта

        //Обход коллекции
        for (String l : languages){
            System.out.println("Я хочу выучить " + l);
        }

        for (int i = 0;i < languages.size();i++){
            System.out.println("Я хочу выучить " + languages.get(i));
        }

        //Список объектов произвольного типа
        List languagesOther = Arrays.asList("Java",1,"Python",4);
        for (Object l : languagesOther){
            System.out.println("Я хочу выучить " + l);
        }
    }
}
