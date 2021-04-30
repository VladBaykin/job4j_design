package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analyze {

    public static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        if (previous.size() > 0 && current.size() == 0) {
            info.deleted = previous.size();
            return info;
        }
        if (current.size() > 0 && previous.size() == 0) {
            info.added = current.size();
            return info;
        }
        Map<Integer, String> currentMap = new HashMap<>();
        for (User user : current) {
            currentMap.put(user.id, user.name);
        }
        for (User user : previous) {
            if (currentMap.containsKey(user.id)) {
                if (!Objects.equals(user.name, currentMap.get(user.id))){
                    info.changed++;
                }
            } else {
                info.deleted++;
            }
        }
        info.added = current.size() - previous.size() + info.deleted;
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
