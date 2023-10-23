package lk.ijse.thogakade.controller;

/*
    @author DanujaV
    @created 10/23/23 - 12:19 PM   
*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.thogakade.dto.ItemDto;
import lk.ijse.thogakade.dto.tm.ItemTm;
import lk.ijse.thogakade.model.ItemModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ItemFormController {
    @FXML
    private TableView<ItemTm> tblItem;
    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    public void initialize() {
        setCellValueFactory();
        loadAllItems();
    }

    private void setCellValueFactory() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());

        var dto = new ItemDto(code, description, unitPrice, qtyOnHand);

        var model = new ItemModel();
        try {
            boolean isSaved = model.saveItem(dto);
            if(isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "item saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void loadAllItems() {
        var model = new ItemModel();
        ObservableList<ItemTm> obList = FXCollections.observableArrayList();
        try {
            List<ItemDto> dtoList = model.loadAllItems();

            for (ItemDto dto : dtoList) {
                obList.add(new ItemTm(
                        dto.getCode(),
                        dto.getDescription(),
                        dto.getQtyOnHand(),
                        dto.getUnitPrice(),
                        new Button("Delete")
                ));
            }
            tblItem.setItems(obList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String code = txtCode.getText();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void codeSearchOnAction(ActionEvent event) {
        String code = txtCode.getText();
    }

    public void btnGetAllOnAction(ActionEvent actionEvent) {

    }
}
