package javaforall.ru.Controller;

import javaforall.ru.Main.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditWindowController {
 private Parent fxmlMain;
 private FXMLLoader fxmlLoader=new FXMLLoader();
    private  FXMLController fxmlController;


    @FXML
private TextField fldNameEdit;
@FXML
private TextField fldNumber;
@FXML
private TextField fldNote;

@FXML
private Button btn_ok;
@FXML
private Button btn_cancel;
    private Person person;



    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person =person;
        fldNameEdit.setText(person.getName());
        fldNumber.setText(person.getNumber());
        fldNote.setText(person.getNote());
               // new Person(fldNameEdit.getText(),fldNumber.getText(),fldNote.getText());
  //  new Person;
    }


    @FXML
    private void initialize() throws IOException {
    init();
    }

    public void init() throws IOException {
       //
            fxmlLoader.setLocation(getClass().getResource("/fxml/MainWindow.fxml"));
        fxmlMain=fxmlLoader.load();
            fxmlController = fxmlLoader.getController();

    }

    public void methodOk(ActionEvent actionEvent) {
     //   System.out.println(fxmlController.personList.getlist().toString());
        String button;
    person= readFromFields();
      // setPerson(readFromFields());
        Stage stage=(Stage)btn_ok.getScene().getWindow();
        button=stage.getTitle();
       // System.out.println(button);
        switch ( button=stage.getTitle()){
            case("Добавить контакт"):
              //  setPerson(readFromFields());
            fxmlController.personList.add(person);

                System.out.println(fxmlController.personList.getlist().toString());
            break;
            case("Удалить контакт"):
                fxmlController.personList.del(person);

            break;
            case"Изменить контакт":
                fxmlController.personList.change(person);
            break;

        }

        // methodCancel(actionEvent);
    }

    public void methodCancel(ActionEvent actionEvent) {
Stage stage=(Stage)btn_cancel.getScene().getWindow();
stage.close();
    }
public Person readFromFields(){
    Person person=new Person(fldNameEdit.getText(),fldNumber.getText(),fldNote.getText());
     return person;
}
}
