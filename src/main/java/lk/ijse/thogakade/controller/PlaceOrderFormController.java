package lk.ijse.thogakade.controller;

/*
    @author DanujaV
    @created 10/23/23 - 12:26 PM   
*/

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.thogakade.dto.CustomerDto;
import lk.ijse.thogakade.model.CustomerModel;
import lk.ijse.thogakade.model.PlaceOrderModel;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderFormController {
    @FXML
    private JFXComboBox<String> cmbCustomerId;

    @FXML
    private JFXComboBox<String> cmbItemCode;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<?> tblOrderCart;

    @FXML
    private TextField txtQty;

    @FXML
    private Label lblNetTotal;

    private PlaceOrderModel pomodel = new PlaceOrderModel();
    private CustomerModel customerModel = new CustomerModel();

    public void initialize() {
        setDate();
        loadCustomerIds();
    }

    private void loadCustomerIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<String> idList = pomodel.loadCustomerIds();

            for(String id : idList) {
                obList.add(id);
            }

            cmbCustomerId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setDate() {
//        LocalDate now = LocalDate.now();
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Stage stage = (Stage) pane.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }

    @FXML
    void btnNewCustomerOnAction(ActionEvent event) throws IOException {
        Parent anchorPane = FXMLLoader.load(getClass().getResource("/view/customer_form.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = new Stage();
        stage.setTitle("Customer Manage");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void cmbItemOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCustomerOnAction(ActionEvent event) {
        String id = cmbCustomerId.getValue();
//        CustomerModel customerModel = new CustomerModel();
        try {
            CustomerDto customerDto = customerModel.searchCustomer(id);
            lblCustomerName.setText(customerDto.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {
    }
}
