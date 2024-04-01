package utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Integer> getInteger(String ph) {
        List<String> activities = List.of(ph.split(";"));
        List<Integer> minutes=new ArrayList<>();
        for (String token : activities) {
            List<String> tokens = List.of(token.split(" "));
            String activity = tokens.get(0);
            minutes.add(Integer.parseInt(tokens.get(1)));
        }
        return minutes;
    }
}
