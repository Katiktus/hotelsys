package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.UserList;

@Service
public interface UserService {
    UserService instance = new UserServiceImpl();

    static UserService getInstance(){
        return instance;
    }
    void addUser(String name, int managerId, int roleId, String phoneNum, int hotelId);
    UserList getAllUsers();
    void updateUserMgr(int id, int mgrId);
    void updateUserRole(int id, int roleId);
    void updateUserPhone(int id, String phoneNum);
    UserList getUsersByName(String name);
    void removeUser(int id);

}
