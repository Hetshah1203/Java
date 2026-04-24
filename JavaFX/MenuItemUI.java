import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;


public class MenuItemUI {

    private Stage stage;
    private TableView<MenuItemRow> tableView;
    private ObservableList<MenuItemRow> data;

    // Input fields
    private TextField idField;
    private TextField nameField;
    private TextField priceField;
    private TextField resIdField;
    private TextField filterPriceField; 

    private Label statusLabel;

    public MenuItemUI(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        // ── TOP: Title + Back ─────────────────────────────────────
        Label title = new Label("MenuItem Table - CRUD Operations");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button backBtn = new Button("← Back to Menu");
        backBtn.setOnAction(e -> MainApp.showMainMenu(stage));

        HBox topBar = new HBox(20, backBtn, title);
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setPadding(new Insets(10));

        tableView = new TableView<MenuItemRow>();
        data = FXCollections.observableArrayList();
        tableView.setItems(data);

        TableColumn<MenuItemRow, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setPrefWidth(55);

        TableColumn<MenuItemRow, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setPrefWidth(140);

        TableColumn<MenuItemRow, String> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setPrefWidth(90);

        TableColumn<MenuItemRow, String> resIdCol = new TableColumn<>("ResID");
        resIdCol.setCellValueFactory(new PropertyValueFactory<>("resId"));
        resIdCol.setPrefWidth(70);

        tableView.getColumns().addAll(idCol, nameCol, priceCol, resIdCol);

        tableView.setOnMouseClicked(e -> {
            MenuItemRow selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                idField.setText(selected.getId());
                nameField.setText(selected.getName());
                priceField.setText(selected.getPrice());
                resIdField.setText(selected.getResId());
            }
        });

        Label idLbl    = new Label("ID:");
        Label nameLbl  = new Label("Name:");
        Label priceLbl = new Label("Price:");
        Label resLbl   = new Label("ResId:");

        idField    = new TextField(); idField.setPromptText("e.g. 111");
        nameField  = new TextField(); nameField.setPromptText("e.g. Dosa");
        priceField = new TextField(); priceField.setPromptText("e.g. 80.0");
        resIdField = new TextField(); resIdField.setPromptText("e.g. 1");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10));
        form.add(idLbl,    0, 0); form.add(idField,    1, 0);
        form.add(nameLbl,  0, 1); form.add(nameField,  1, 1);
        form.add(priceLbl, 0, 2); form.add(priceField, 1, 2);
        form.add(resLbl,   0, 3); form.add(resIdField, 1, 3);

        Button insertBtn = new Button("INSERT");
        Button selectBtn = new Button("SELECT ALL");
        Button updateBtn = new Button("UPDATE");
        Button deleteBtn = new Button("DELETE");
        Button clearBtn  = new Button("Clear Fields");

        insertBtn.setPrefWidth(130);
        selectBtn.setPrefWidth(130);
        updateBtn.setPrefWidth(130);
        deleteBtn.setPrefWidth(130);
        clearBtn.setPrefWidth(130);

        insertBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        selectBtn.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        updateBtn.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white;");
        deleteBtn.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

        Label filterLbl = new Label("Filter: Price ≤");
        filterPriceField = new TextField();
        filterPriceField.setPromptText("e.g. 100");
        filterPriceField.setPrefWidth(70);

        Button filterBtn = new Button("GO");
        filterBtn.setStyle("-fx-background-color: #9C27B0; -fx-text-fill: white;");

        HBox filterBox = new HBox(8, filterLbl, filterPriceField, filterBtn);
        filterBox.setAlignment(Pos.CENTER_LEFT);
        filterBox.setPadding(new Insets(5, 0, 0, 0));

        VBox buttonBox = new VBox(10, insertBtn, selectBtn, updateBtn, deleteBtn, clearBtn, filterBox);
        buttonBox.setPadding(new Insets(10));

        VBox rightPanel = new VBox(15, form, buttonBox);
        rightPanel.setPadding(new Insets(10));
        rightPanel.setPrefWidth(300);

        statusLabel = new Label("Ready. Click SELECT ALL to load data.");
        statusLabel.setStyle("-fx-padding: 8px; -fx-font-size: 13px;");

        insertBtn.setOnAction(e -> handleInsert());
        selectBtn.setOnAction(e -> handleSelectAll());
        updateBtn.setOnAction(e -> handleUpdate());
        deleteBtn.setOnAction(e -> handleDelete());
        filterBtn.setOnAction(e -> handleFilterByPrice());

        clearBtn.setOnAction(e -> {
            idField.clear(); nameField.clear();
            priceField.clear(); resIdField.clear();
            statusLabel.setText("Fields cleared.");
        });

        BorderPane root = new BorderPane();
        root.setTop(topBar);
        root.setCenter(tableView);
        root.setRight(rightPanel);
        root.setBottom(statusLabel);
        BorderPane.setMargin(tableView, new Insets(0, 10, 0, 10));

        Scene scene = new Scene(root, 820, 480);
        stage.setTitle("Manage Menu Items");
        stage.setScene(scene);
        stage.show();

        handleSelectAll();
    }

    private void handleInsert() {
        try {
            int    id    = Integer.parseInt(idField.getText().trim());
            String name  = nameField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int    resId = Integer.parseInt(resIdField.getText().trim());

            if (name.isEmpty()) {
                setStatus("Name cannot be empty.", "red");
                return;
            }

            RestaurantJDBC.insertMenuItem(MainApp.con, id, name, price, resId);
            setStatus("Inserted: " + name + " (Price: " + price + ")", "green");
            handleSelectAll();

        } catch (NumberFormatException e) {
            setStatus("ID, Price, ResId must be valid numbers.", "red");
        } catch (Exception e) {
            setStatus("Insert failed: " + e.getMessage(), "red");
        }
    }

    private void handleSelectAll() {
        try {
            data.clear();
            ArrayList<String[]> rows = RestaurantJDBC.getAllMenuItems(MainApp.con);

            for (String[] row : rows) {
                // row[0]=id, row[1]=name, row[2]=price, row[3]=resId
                data.add(new MenuItemRow(row[0], row[1], row[2], row[3]));
            }

            setStatus("Loaded " + rows.size() + " menu item(s).", "blue");

        } catch (Exception e) {
            setStatus("Select failed: " + e.getMessage(), "red");
        }
    }

    private void handleUpdate() {
        try {
            int    id    = Integer.parseInt(idField.getText().trim());
            String name  = nameField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int    resId = Integer.parseInt(resIdField.getText().trim());

            int rows = RestaurantJDBC.updateMenuItem(MainApp.con, id, name, price, resId);
            if (rows > 0) {
                setStatus("Updated MenuItem ID: " + id, "green");
                handleSelectAll();
            } else {
                setStatus("No item found with ID: " + id, "red");
            }

        } catch (NumberFormatException e) {
            setStatus("ID, Price, ResId must be valid numbers.", "red");
        } catch (Exception e) {
            setStatus("Update failed: " + e.getMessage(), "red");
        }
    }

    private void handleDelete() {
        try {
            int id = Integer.parseInt(idField.getText().trim());

            int rows = RestaurantJDBC.deleteMenuItem(MainApp.con, id);
            if (rows > 0) {
                setStatus("Deleted MenuItem ID: " + id, "green");
                handleSelectAll();
                idField.clear(); nameField.clear();
                priceField.clear(); resIdField.clear();
            } else {
                setStatus("No item found with ID: " + id, "red");
            }

        } catch (NumberFormatException e) {
            setStatus("ID must be a number.", "red");
        } catch (Exception e) {
            setStatus("Delete failed: " + e.getMessage(), "red");
        }
    }

    private void handleFilterByPrice() {
        try {
            double maxPrice = Double.parseDouble(filterPriceField.getText().trim());
            data.clear();

            ArrayList<String[]> rows = RestaurantJDBC.getMenuItemsByMaxPrice(MainApp.con, maxPrice);
            for (String[] row : rows) {
                data.add(new MenuItemRow(row[0], row[1], row[2], row[3]));
            }

            setStatus("Showing " + rows.size() + " item(s) with Price ≤ " + maxPrice, "purple");

        } catch (NumberFormatException e) {
            setStatus("Enter a valid price to filter.", "red");
        } catch (Exception e) {
            setStatus("Filter failed: " + e.getMessage(), "red");
        }
    }

    private void setStatus(String msg, String color) {
        statusLabel.setText(msg);
        statusLabel.setStyle("-fx-text-fill: " + color + "; -fx-padding: 8px; -fx-font-size: 13px;");
    }

    public static class MenuItemRow {
        private String id;
        private String name;
        private String price;
        private String resId;

        public MenuItemRow(String id, String name, String price, String resId) {
            this.id    = id;
            this.name  = name;
            this.price = price;
            this.resId = resId;
        }

        public String getId()    { return id; }
        public String getName()  { return name; }
        public String getPrice() { return price; }
        public String getResId() { return resId; }
    }
}
