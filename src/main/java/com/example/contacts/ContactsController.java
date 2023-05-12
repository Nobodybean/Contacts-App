package com.example.contacts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactsController {
    private final ObservableList<Contact> contacts = FXCollections.observableArrayList();

    private Contact contactSelected;

    @FXML
    private ListView<Contact> contactsListView;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    void addContactButtonPressed(ActionEvent event) {
        Contact newContact = new Contact();
        newContact.setFirstName(firstNameTextField.getText().trim());
        newContact.setLastName(lastNameTextField.getText().trim());
        newContact.setEmail(emailTextField.getText().trim());
        newContact.setPhoneNumber(phoneNumberTextField.getText().trim());
        contacts.add(newContact);
    }

    @FXML
    void deleteContactButtonPressed(ActionEvent event) {
        contacts.remove(contactSelected);
    }

    @FXML
    void updateContactButtonPressed(ActionEvent event) {
        contactSelected.setFirstName(firstNameTextField.getText().trim());
        contactSelected.setLastName(lastNameTextField.getText().trim());
        contactSelected.setEmail(emailTextField.getText().trim());
        contactSelected.setPhoneNumber(phoneNumberTextField.getText().trim());
    }

    public void initialize() {
        contacts.add(new Contact("Jungkook", "Jeon", "jungkook1997@gmail.com", "(07) 283765"));
        contacts.add(new Contact("Taehuyng", "Kim", "taehyung1996@gmail.com", "(07) 567893"));
        contacts.add(new Contact("Jimin", "Park", "jimini1996@gmail.com", "(07) 09876"));
        contacts.add(new Contact("Heosok", "Jon", "hosya.hobyworld@gmail.com", "(07) 123456"));
        contactsListView.setItems(contacts);

        contactsListView.getSelectionModel().selectedItemProperty().addListener((arg0, oldValue, newValue) -> {
            contactSelected = newValue;
            firstNameTextField.setText(newValue.getFirstName());
            lastNameTextField.setText(newValue.getLastName());
            emailTextField.setText(newValue.getEmail());
            phoneNumberTextField.setText(newValue.getPhoneNumber());
        });
    }

}
