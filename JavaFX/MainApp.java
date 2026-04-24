import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;

public class MainApp extends Application {

    static Connection con;

    @Override
    public void start(Stage primaryStage) {

        try {
            con = RestaurantJDBC.getConnection();
            RestaurantJDBC.createTables(con);
        } catch (Exception e) {

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText("Could not connect to database.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return; 
        }

        showMainMenu(primaryStage);
    }

    public static void showMainMenu(Stage stage) {

        Label titleLabel = new Label("Restaurant Management System");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label subLabel = new Label("Select a table to manage:");
        subLabel.setStyle("-fx-font-size: 14px;");

        Button restaurantBtn = new Button("Manage Restaurants");
        Button menuItemBtn   = new Button("Manage Menu Items");
        Button exitBtn       = new Button("Exit");

        restaurantBtn.setPrefWidth(220);
        menuItemBtn.setPrefWidth(220);
        exitBtn.setPrefWidth(220);

        restaurantBtn.setOnAction(e -> {
            RestaurantUI restaurantScreen = new RestaurantUI(stage);
            restaurantScreen.show();
        });

        menuItemBtn.setOnAction(e -> {
            MenuItemUI menuScreen = new MenuItemUI(stage);
            menuScreen.show();
        });

        exitBtn.setOnAction(e -> {
            try {
                if (con != null && !con.isClosed()) con.close();
            } catch (Exception ex) { }
            stage.close();
        });

        VBox vbox = new VBox(15); 
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(40));
        vbox.getChildren().addAll(titleLabel, subLabel, restaurantBtn, menuItemBtn, exitBtn);

        BorderPane root = new BorderPane();
        root.setCenter(vbox);

        Scene scene = new Scene(root, 450, 350);

        stage.setTitle("Restaurant Management System");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
