package lk.ijse.thogakade.controller;

/*
    @author DanujaV
    @created 10/23/23 - 10:01 AM   
*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.thogakade.db.DbConnection;
import lk.ijse.thogakade.dto.CustomerDto;
import lk.ijse.thogakade.dto.tm.CustomerTm;
import lk.ijse.thogakade.model.CustomerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
    private TableView<CustomerTm> tblCustomer;

    public void initialize() {
        setCellValueFactory();
        loadAllCustomer();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

    private void loadAllCustomer() {
        var model = new CustomerModel();

        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> dtoList  = model.getAllCustomer();

            for(CustomerDto dto : dtoList) {
                tmList.add(
                        new CustomerTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getAddress(),
                                dto.getTel()
                        )
                );
            }

            tblCustomer.setItems(tmList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        var dto = new CustomerDto(id, name, address, tel);

        try {
            var model = new CustomerModel();
            boolean isSaved = model.saveCustomer(dto);

            if(isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        String id = txtId.getText();

        var model = new CustomerModel();
        try {
            CustomerDto customerDto = model.searchCustomer(id);
//            System.out.println(customerDto);
            if(customerDto != null) {
                txtId.setText(customerDto.getId());
                txtName.setText(customerDto.getName());
                txtAddress.setText(customerDto.getAddress());
                txtTel.setText(customerDto.getTel());
            } else {
                new Alert(Alert.AlertType.INFORMATION, "customer not found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
