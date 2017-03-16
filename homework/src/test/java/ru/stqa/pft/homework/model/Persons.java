package ru.stqa.pft.homework.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Summoner on 15.03.2017.
 */
public class Persons extends ForwardingSet<PersonData> {

    private Set<PersonData> delegate;

    public Persons(Persons persons) {
        this.delegate = new HashSet<PersonData>(persons.delegate);
    }

    public Persons() {
        this.delegate = new HashSet<PersonData>();
    }

    @Override
    protected Set<PersonData> delegate() {
        return delegate;
    }

    public Persons withAdded(PersonData person){
        Persons persons = new Persons(this);
        persons.add(person);
        return persons;
    }

    public Persons without(PersonData person){
        Persons persons = new Persons(this);
        persons.remove(person);
        return persons;
    }

}
