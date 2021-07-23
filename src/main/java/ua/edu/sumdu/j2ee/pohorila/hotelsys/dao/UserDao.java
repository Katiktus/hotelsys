package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.User;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.UserList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {
    UserDao instance = new UserDaoImpl();

    static UserDao getInstance(){
        return instance;
    }

    void addUser(String name, int managerId, int roleId, String phoneNum, int hotelId);
    UserList getAllUsers();
    User parseUser(ResultSet resultSet) throws SQLException;
    void updateUserMgr(int id, int mgrId);
    void updateUserRole(int id, int roleId);
    void updateUserPhone(int id, String phoneNum);
    void removeUser(int id);
    UserList getUsersByName(String name);
}
