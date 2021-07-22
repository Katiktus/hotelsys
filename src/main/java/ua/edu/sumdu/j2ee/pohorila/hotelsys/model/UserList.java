package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.ArrayList;
import java.util.Objects;

public class UserList {
    ArrayList<User> users;

    public UserList() {
        this.users = new ArrayList<User>();
    }

    public void add(User user) {
        users.add(user);
    }

    public ArrayList<User> getArr(){
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserList userList = (UserList) o;
        return Objects.equals(users, userList.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "UserList{" +
                "users=" + users +
                '}';
    }
}
