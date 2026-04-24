import java.sql.*;
import java.util.ArrayList;

public class RestaurantJDBC {

    static final String URL  = "jdbc:mysql://localhost:3306/restaurant_db";
    static final String USER = "root";
    static final String PASS = "sit123"; 

    public static Connection getConnection() throws Exception {

        String serverUrl = "jdbc:mysql://localhost:3306/";
        try (Connection serverCon = DriverManager.getConnection(serverUrl, USER, PASS);
             Statement st = serverCon.createStatement()) {
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS restaurant_db");
        }

        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void createTables(Connection con) throws Exception {
        try (Statement st = con.createStatement()) {
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Restaurant (" +
                "Id INT PRIMARY KEY, " +
                "Name VARCHAR(255), " +
                "Address VARCHAR(255))"
            );
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS MenuItem (" +
                "Id INT PRIMARY KEY, " +
                "Name VARCHAR(255), " +
                "Price DOUBLE, " +
                "ResId INT, " +
                "FOREIGN KEY (ResId) REFERENCES Restaurant(Id))"
            );
        }
    }

    public static void insertRestaurant(Connection con, int id, String name, String address)
            throws Exception {
        String sql = "INSERT INTO Restaurant VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, address);
            ps.executeUpdate();
        }
    }

    public static ArrayList<String[]> getAllRestaurants(Connection con) throws Exception {
        ArrayList<String[]> list = new ArrayList<String[]>();
        String sql = "SELECT * FROM Restaurant";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String[] row = {
                    String.valueOf(rs.getInt("Id")),
                    rs.getString("Name"),
                    rs.getString("Address")
                };
                list.add(row);
            }
        }
        return list;
    }

    // UPDATE Restaurant
    public static int updateRestaurant(Connection con, int id, String name, String address)
            throws Exception {
        String sql = "UPDATE Restaurant SET Name=?, Address=? WHERE Id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setInt(3, id);
            return ps.executeUpdate(); // returns number of rows affected
        }
    }

    // DELETE Restaurant
    public static int deleteRestaurant(Connection con, int id) throws Exception {
        String sql = "DELETE FROM Restaurant WHERE Id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    public static void insertMenuItem(Connection con, int id, String name, double price, int resId)
            throws Exception {
        String sql = "INSERT INTO MenuItem VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, resId);
            ps.executeUpdate();
        }
    }

    public static ArrayList<String[]> getAllMenuItems(Connection con) throws Exception {
        ArrayList<String[]> list = new ArrayList<String[]>();
        String sql = "SELECT * FROM MenuItem";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String[] row = {
                    String.valueOf(rs.getInt("Id")),
                    rs.getString("Name"),
                    String.valueOf(rs.getDouble("Price")),
                    String.valueOf(rs.getInt("ResId"))
                };
                list.add(row);
            }
        }
        return list;
    }

    public static int updateMenuItem(Connection con, int id, String name, double price, int resId)
            throws Exception {
        String sql = "UPDATE MenuItem SET Name=?, Price=?, ResId=? WHERE Id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, resId);
            ps.setInt(4, id);
            return ps.executeUpdate();
        }
    }

    public static int deleteMenuItem(Connection con, int id) throws Exception {
        String sql = "DELETE FROM MenuItem WHERE Id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    public static ArrayList<String[]> getMenuItemsByMaxPrice(Connection con, double maxPrice)
            throws Exception {
        ArrayList<String[]> list = new ArrayList<String[]>();
        String sql = "SELECT * FROM MenuItem WHERE Price <= ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, maxPrice);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] row = {
                    String.valueOf(rs.getInt("Id")),
                    rs.getString("Name"),
                    String.valueOf(rs.getDouble("Price")),
                    String.valueOf(rs.getInt("ResId"))
                };
                list.add(row);
            }
        }
        return list;
    }
}
