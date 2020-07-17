package javaforall.ru.Main;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty Name;
    private SimpleStringProperty Number;
    private SimpleStringProperty Note;

//    public Person(SimpleStringProperty name, SimpleStringProperty number, SimpleStringProperty note) {
//        Name = name;
//        Number = number;
//        Note = note;
//    }

    public Person(String Name, String Number, String Note) {
        this.Name=new SimpleStringProperty(Name);
        this.Number=new SimpleStringProperty(Number);
        this.Note=new SimpleStringProperty(Note);
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getNumber() {
        return Number.get();
    }

    public SimpleStringProperty numberProperty() {
        return Number;
    }

    public void setNumber(String number) {
        this.Number.set(number);
    }

    public String getNote() {
        return Note.get();
    }

    public SimpleStringProperty noteProperty() {
        return Note;
    }

    public void setNote(String note) {
        this.Note.set(note);
    }
}


