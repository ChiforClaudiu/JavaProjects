package repository;

import domain.Activity;
import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;

public class Repository {
    private ArrayList<Activity> activities;
    private static final String JDBC_URL = "jdbc:sqlite:data/test_db.db";

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null)
            openConnection();
        return conn;
    }

    public Repository() {
        activities = new ArrayList<>();
        openConnection();
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Activity");

            while (rs.next()) {
                String date = rs.getString("date");
                Integer nbOfSteps = rs.getInt("number_of_steps");
                Double hoursOfSleep = rs.getDouble("hours_of_sleep");
                String physicalActivities = rs.getString("physical_activities");
                activities.add(new Activity(date,nbOfSteps,hoursOfSleep,physicalActivities));
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void openConnection() {
        try {
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(JDBC_URL);
            if (conn == null || conn.isClosed())
                conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Activity> getActivities() {
        return this.activities;
    }


}
