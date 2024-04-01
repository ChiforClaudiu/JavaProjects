package service;

import domain.Route;
import repository.Repository;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Service {
    final private Repository repo;
    public Service(Repository repo) {
        this.repo = repo;
    }

    public ArrayList<Route> getRoutes() {
        return repo.getRoutes();
    }

    public ArrayList<String> getCities() {
        ArrayList<String> result = new ArrayList<>();
        for (Route r : repo.getRoutes()) {
            if (!result.contains(r.getSourceCity())) result.add(r.getSourceCity());
        }
        return result;
    }

    public ArrayList<Route> getFilteredRoutesBySourceCity(String source) {
        return (ArrayList<Route>) repo.getRoutes().stream().filter(r -> r.getSourceCity()==source).collect(Collectors.toList());
    }
}
