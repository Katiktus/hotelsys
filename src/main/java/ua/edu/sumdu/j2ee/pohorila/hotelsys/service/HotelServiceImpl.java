package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.dao.HotelsysDao;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.CustomerList;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.RoomList;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.UserList;

@Service
public class HotelServiceImpl implements HotelsysService{

    @Autowired
    public HotelsysDao hotelsysDao;

    /*public HotelServiceImpl() {
        super();
    }
*/

    @Override
    public void connect() {
        hotelsysDao.connect();
    }

    @Override
    public void disconnect() {
        hotelsysDao.disconnect();
    }

    @Override
    public void addCustomer(String name, String phoneNumber) {
        hotelsysDao.addCustomer(name, phoneNumber);
    }

    @Override
    public void addRoom(String roomType, int capacity, int price, int customerID, int hotelID) {
        hotelsysDao.addRoom(roomType, capacity, price, customerID, hotelID);
    }

    @Override
    public void addUser(String name, int managerId, int roleId, String phoneNum, int hotelId) {
        hotelsysDao.addUser(name, managerId, roleId, phoneNum, hotelId);
    }

    @Override
    public CustomerList getAllCustomer() {
        return hotelsysDao.getAllCustomer();
    }

    @Override
    public RoomList getAllRooms() {
        return hotelsysDao.getAllRooms();
    }

    @Override
    public UserList getAllUsers() {
        return hotelsysDao.getAllUsers();
    }

    @Override
    public void updateCustomerPhone(int id, String phone) {
        hotelsysDao.updateCustomerPhone(id, phone);
    }

    @Override
    public void updateRoomPrice(int id, int price) {
        hotelsysDao.updateRoomPrice(id, price);
    }

   /* @Override
    public void updateRoomCustomerId(int id, int customerId) {
        hotelsysDao.updateRoomCustomerId(id, customerId);
    }*/

    @Override
    public void updateUserMgr(int id, int mgrId) {
        hotelsysDao.updateUserMgr(id, mgrId);
    }

    @Override
    public void updateUserRole(int id, int roleId) {
        hotelsysDao.updateUserRole(id, roleId);
    }

    @Override
    public void updateUserPhone(int id, String phoneNum) {
        hotelsysDao.updateUserPhone(id, phoneNum);
    }

    @Override
    public void removeCustomer(int id) {
        hotelsysDao.removeCustomer(id);
    }

    @Override
    public void removeRoom(int id) {
        hotelsysDao.removeRoom(id);
    }

    @Override
    public void removeUser(int id) {
        hotelsysDao.removeUser(id);
    }
}
