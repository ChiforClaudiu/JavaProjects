package service;

import domain.Activity;
import repository.Repository;
import utils.Utils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private Repository repo;

    public Service(Repository repo) {
        this.repo = repo;
    }

    public List<Activity> getActivitiesSortedByDate(){
        return this.repo.getActivities().stream()
                .sorted(Comparator.comparing(Activity::getDate))
                .collect(Collectors.toList());
    }
/*
    public void getMinutes(){
        this.repo.getActivities().stream()
                .map(a->a.getPhysicalActivities())
                .map(ph->{
                    return Utils.getInteger(ph).get(0);
                }).collect(Collectors.toList());
    }

    public List<Activity> getActivitesBetweenAGivenIntervalAndACertainActivity(Integer lowerBound, Integer upperBound, String text){
        return this.repo.getActivities().stream()
                .filter( activity -> activity.getPhysicalActivities().contains(text)).filter(activity -> {
                    // Assuming there's a method like getMinutes() in the Activity class
                    int minutes = activity.getMinutes();
                    return minutes >= lowerBound && minutes <= upperBound;
                })
                .collect(Collectors.toList());

    }


*/
}
