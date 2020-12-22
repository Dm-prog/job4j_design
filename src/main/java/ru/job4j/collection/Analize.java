package ru.job4j.collection;

import java.util.*;

public class Analize {
    Info info = new Info();
    List<User> previous = new ArrayList<>();
    List<User> current = new ArrayList<>();

    public Info diff(List<User> previous, List<User> current) {
        Info rsl = new Info();
        Map<Integer, User> map = new HashMap<>();
        for (User user : current) {
            map.put(user.getId(), user);
        }
        for (User user : previous) {
            User cur = map.get(user.getId());
            if (cur == null) {
                info.add();
            } else if (!user.getName().equals(cur.getName())) {
                info.chang();
            }
        }
        int deleted = current.size() + info.deleted - previous.size();
        return new Info(info.added, info.changed, deleted);
    }

    public static class User {
        private final int id;
        private final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        public Info() {
        }

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setAdded(int added) {
            this.added = added;
        }

        public void setChanged(int changed) {
            this.changed = changed;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        public int add() {
            added++;
            return added;
        }

        public int chang() {
            changed++;
            return changed;
        }

        public int delete() {
            deleted++;
            return deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }

}
