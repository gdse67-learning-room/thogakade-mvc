package lk.ijse.thogakade.controller;

/*
    @author DanujaV
    @created 10/23/23 - 10:01 AM   
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CustomerFormController {
    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableView<?> tblCustomer;

    public void initialize() {
//        loadAllCustomer();
    }

    private void loadAllCustomer() {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
    }
}
