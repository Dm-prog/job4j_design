package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Analize {
    Info info = new Info();
    List<User> previous = new ArrayList<>();
    List<User> current = new ArrayList<>();


    public Info diff(List<User> previous, List<User> current) {
        for (int i = 0; i < previous.size(); i++) {
            for (int j = 0; j < previous.size(); j++) {
                if (!previous.get(i).equals(current.get(j))) {
                    info.add();
                } else if (!previous.get(i).getName().equals(current.get(j).getName())) {
                    info.chang();
                } else if (!previous.contains(current)) {
                    info.delete();
                }
            }
        }
        return new Info();
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
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
