package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.ArrayList;

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
}
