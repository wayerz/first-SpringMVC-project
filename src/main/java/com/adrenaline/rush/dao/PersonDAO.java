package com.adrenaline.rush.dao;

import com.adrenaline.rush.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Storm Spirit"));
        people.add(new Person(++PEOPLE_COUNT, "Phantom Assassin"));
        people.add(new Person(++PEOPLE_COUNT, "Viper"));
        people.add(new Person(++PEOPLE_COUNT, "Invoker"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
