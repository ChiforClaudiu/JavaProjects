package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Activity {
    private String date;
    private  int nbOfSteps;
    private double hoursOfSleep;
    private String physicalActivities;

    public Activity(String date, int nbOfSteps, double hoursOfSleep, String physicalActivities) {
        this.date = date;
        this.nbOfSteps = nbOfSteps;
        this.hoursOfSleep = hoursOfSleep;
        this.physicalActivities = physicalActivities;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNbOfSteps() {
        return nbOfSteps;
    }

    public void setNbOfSteps(int nbOfSteps) {
        this.nbOfSteps = nbOfSteps;
    }

    public double getHoursOfSleep() {
        return hoursOfSleep;
    }

    public void setHoursOfSleep(double hoursOfSleep) {
        this.hoursOfSleep = hoursOfSleep;
    }

    public String getPhysicalActivities() {
        return physicalActivities;
    }

    public void setPhysicalActivities(String physicalActivities) {
        this.physicalActivities = physicalActivities;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "date='" + date + '\'' +
                ", nbOfSteps=" + nbOfSteps +
                ", hoursOfSleep=" + hoursOfSleep +
                ", physicalActivities='" + physicalActivities + '\'' +
                '}';
    }

}
