package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    ObservableList<Contacts> contacts = FXCollections.observableArrayList();

    @FXML
    TextField nameField;

    @FXML
    TextField phoneField;

    @FXML
    TextField emailField;

    @FXML
    ListView listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(contacts);
    }

    public void addItem() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        Contacts item = new Contacts(name, phone, email);
        if (nameField.getText().equals("") || phoneField.getText().equals("") || emailField.getText().equals("")) { //if any of the fields are blank, do nothing.
            //blank because it should do nothing if something isn't entered into each field.
        } else { //else add contact
            contacts.add(item);

            nameField.setText("");
            phoneField.setText("");
            emailField.setText("");
        }
    }

    public void removeItem() {
        Contacts item = (Contacts) listView.getSelectionModel().getSelectedItem();
        if (item != null) {
            contacts.remove(item);
        }
    }
}