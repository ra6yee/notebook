package javaforall.ru.Main;

import javaforall.ru.interfaces.Notebook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class PersonList implements Notebook {

//  ArrayList<Person>listOfPersons= new ArrayList<>();
private ObservableList<Person>observListOfPersons= FXCollections.observableArrayList();
    @Override
    public void add(Person person) {
        observListOfPersons.add(person);

    }

    @Override
    public void del(Person person) {
        observListOfPersons.remove(person);
    }

    @Override
    public void change(Person person) {

    }
public void fillList(){
    observListOfPersons.add(new Person("Иванов Иван","75654","Привет"));
    observListOfPersons.add(new Person("Васильев Василий","43543543","Здравствуйте"));
    observListOfPersons.add(new Person("Петров Петр","123434","Здоровеньки булы"));
    observListOfPersons.add(new Person("Сидоров Сидор","435223","Наше вам с кисточкой"));
    observListOfPersons.add(new Person("Александров Александр","654654","Мое почтение"));

    }
public ObservableList<Person> getlist(){
return observListOfPersons;
}

}
