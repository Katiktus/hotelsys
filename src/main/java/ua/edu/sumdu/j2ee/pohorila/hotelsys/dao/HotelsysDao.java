package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface HotelsysDao {
    HotelsysDao instance = new HotelsysDaoImpl();

    static HotelsysDao getInstance(){
        return instance;
    }

    void connect();
    void disconnect();
    void addCustomer(String name, String phoneNumber);
    void addRoom(int roomNumber, String roomType, int capacity, int price, int hotelID);
    void addUser(String name, int managerId, int roleId, String phoneNum, int hotelId);
    CustomerList getAllCustomer();
    RoomList getAllRooms();
    UserList getAllUsers();
    void updateCustomerPhone(int id, String phone);
    void updateRoomPrice(int id, int price);
    User parseUser(ResultSet resultSet) throws SQLException;
    Room parseRoom(ResultSet resultSet) throws SQLException;
    Customer parseCustomer(ResultSet resultSet) throws SQLException;
    void updateUserMgr(int id, int mgrId);
    void updateUserRole(int id, int roleId);
    void updateUserPhone(int id, String phoneNum);
    void removeCustomer(int id);
    void removeRoom(int id);
    void removeUser(int id);
}
