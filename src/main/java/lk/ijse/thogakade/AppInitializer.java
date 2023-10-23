package lk.ijse.thogakade;

/*
    @author DanujaV
    @created 10/23/23 - 9:58 AM   
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/customer_form.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Customer Form");

        stage.show();
    }
}
