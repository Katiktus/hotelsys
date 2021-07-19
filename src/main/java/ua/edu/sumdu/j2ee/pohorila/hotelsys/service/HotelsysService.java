package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.*;

@Service
public interface HotelsysService {
    HotelsysService instance = new HotelServiceImpl();

    static HotelsysService getInstance(){
        return instance;
    }

    void addCustomer(String name, String phoneNumber);
    void addRoom(String roomType, int capacity, int price, int hotelID);
    void addUser(String name, int managerId, int roleId, String phoneNum, int hotelId);
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

    void addOrder(int customerId, int roomNum);
    OrderList getAllOrders();
    void removeOrder(int id);


    UserList getUsersByName(String name);
    RoomList getFreeRooms();

}
