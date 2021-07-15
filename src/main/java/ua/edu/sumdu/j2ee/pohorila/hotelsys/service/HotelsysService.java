package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public interface HotelsysService {
    HotelsysService instance = new HotelServiceImpl();

    static HotelsysService getInstance(){
        return instance;
    }

   // void connect();
  //  void disconnect();
    void addCustomer(String name, String phoneNumber);
    void addRoom(int roomNumber, String roomType, int capacity, int price, int hotelID);
    void addUser(String name, int managerId, int roleId, int userId, String phoneNum, int hotelId);
    CustomerList getAllCustomer();
    RoomList getAllRooms();
    UserList getAllUsers();
    void updateCustomerPhone(int id, String phone);
    void updateRoomPrice(int id, int price);
    void updateUserMgr(int id, int mgrId);
    void updateUserRole(int id, int roleId);
    void updateUserPhone(int id, String phoneNum);
    void removeCustomer(int id);
    void removeRoom(int id);
    void removeUser(int id);

    void addOrder(int id, int customerId, int roomNum);
    OrderList getAllOrders();
    Order parseOrder(ResultSet resultSet) throws SQLException;
    void removeOrder(int id);

}
