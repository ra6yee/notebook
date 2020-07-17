package javaforall.ru.Controller;

import java.io.IOException;

import javaforall.ru.Main.Person;
import javaforall.ru.Main.PersonList;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLController {
 PersonList personList=new PersonList();





    @FXML
  private TableColumn<Person,String> column_contact;
   @FXML
   private TableColumn<Person,String> column_number;
   @FXML
  private TableColumn<Person,String> column_note;
@FXML
private Label lbl_cont;
   @FXML
   private TableView tbl_content;


//  private   EditWindowController editWindowController;
//public void createControllerRef() {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/fxml/EditWindow.fxml"));
//    EditWindowController editWindowController = loader.getController();
//}
    
    @FXML
    public void initialize() {

        column_contact.setCellValueFactory(new PropertyValueFactory<Person,String>("Name"));
        column_number.setCellValueFactory(new PropertyValueFactory<Person,String>("Number"));
           column_note.setCellValueFactory(new PropertyValueFactory<Person,String>("Note"));
        personList.getlist().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                countofContacts();
            }
        });
           personList.fillList();

tbl_content.setItems(personList.getlist());

tbl_content.setEditable(true);
        countofContacts();

        // TODO
    }

public void createWindowEdit(String typeOfWindiw,ActionEvent ae){
    Parent root = null;
    try {
        root = FXMLLoader.load(getClass().getResource("/fxml/EditWindow.fxml"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    Scene scene = new Scene(root);
    scene.getStylesheets().add("/styles/Styles.css");
    Stage stage=new Stage();
    stage.setTitle(typeOfWindiw);
    stage.setScene(scene);
    stage.initModality(Modality.WINDOW_MODAL);
    stage.initOwner(((Node)ae.getSource()).getScene().getWindow());
    stage.show();
    stage.setResizable(false);
}
public void addContact(ActionEvent actionEvent) {
     createWindowEdit("Добавить контакт",actionEvent);
   // personList.add(editWindowController.readFromFields());

}
    public void deleteContact(ActionEvent actionEvent) {
        createWindowEdit("Удалить контакт",actionEvent);
    }

    public void changeContact(ActionEvent actionEvent) {
        createWindowEdit("Изменить контакт",actionEvent);
    }

    public void findContact(ActionEvent actionEvent) {
    }

    public  void countofContacts(){
        lbl_cont.setText("Количество контактов: "+personList.getlist().size());
    }
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
}
