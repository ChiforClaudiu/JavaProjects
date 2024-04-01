package repository;

import org.sqlite.SQLiteDataSource;
import java.sql.*;
import java.util.ArrayList;

import domain.Route;

public class Repository {

    ArrayList<Route> routes;
    private static final String JDBC_URL = "jdbc:sqlite:data/test_db.db";

    private static Connection conn = null;

    public Repository() {
        routes = new ArrayList<>();
        openConnection();
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM route");

            while (rs.next()) {
                routes.add(new Route(
                        rs.getString("source_city"),
                        rs.getString("destination_city"),
                        rs.getString("departure_time"),
                        rs.getString("arrival_time"),
                        rs.getInt("number_of_seats"),
                        rs.getFloat("ticket_price")
                ));
                ;
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        if (conn == null)
            openConnection();
        return conn;
    }

    private static void openConnection()
    {
        try
        {
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(JDBC_URL);
            if (conn == null || conn.isClosed())
                conn = ds.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection()
    {
        try
        {
            conn.close();
            conn = null;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public ArrayList<Route> getRoutes() {
        return routes;
    }
}
