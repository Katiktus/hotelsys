package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.dao.HotelsysDao;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.*;

@Service
public class HotelServiceImpl implements HotelsysService{

    @Autowired
    public HotelsysDao hotelsysDao;
    Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    @Override
    public void addCustomer(String name, String phoneNumber) {
        logger.info("addCustomer: "+name+", "+phoneNumber);
        hotelsysDao.addCustomer(name, phoneNumber);
    }

    @Override
    public void addRoom(String roomType, int capacity, int price, int hotelID) {
        logger.info("addRoom: "+roomType+", "+capacity+ ", "+price+", "+hotelID);
        hotelsysDao.addRoom(roomType, capacity, price, hotelID);
    }

    @Override
    public void addUser(String name, int managerId, int roleId, String phoneNum, int hotelId) {
        logger.info("addUser: "+name+", "+managerId+ ", "+roleId+", "+phoneNum+", "+hotelId);
        hotelsysDao.addUser(name, managerId, roleId, phoneNum, hotelId);
    }

    @Override
    public CustomerList getAllCustomer() {
        logger.info("getAllCustomers");
        return hotelsysDao.getAllCustomer();
    }

    @Override
    public RoomList getAllRooms() {
        logger.info("getAllRooms");
        return hotelsysDao.getAllRooms();
    }

    @Override
    public UserList getAllUsers() {
        logger.info("getAllUsers");
        return hotelsysDao.getAllUsers();
    }

    @Override
    public void updateCustomerPhone(int id, String phone) {
        logger.info("updateCustomerPhone id:"+id+", phone:"+phone);
        hotelsysDao.updateCustomerPhone(id, phone);
    }

    @Override
    public void updateRoomPrice(int id, int price) {
        logger.info("updateRoomPrice id:"+id+", price:"+price);
        hotelsysDao.updateRoomPrice(id, price);
    }

    @Override
    public void updateUserMgr(int id, int mgrId) {
        logger.info("updateUserMgr id:"+id+", mgrId:"+mgrId);
        hotelsysDao.updateUserMgr(id, mgrId);
    }

    @Override
    public void updateUserRole(int id, int roleId) {
        logger.info("updateUserRole id:"+id+", roleId:"+roleId);
        hotelsysDao.updateUserRole(id, roleId);
    }

    @Override
    public void updateUserPhone(int id, String phoneNum) {
        logger.info("updateUserPhone id:"+id+", phoneNum:"+phoneNum);
        hotelsysDao.updateUserPhone(id, phoneNum);
    }

    @Override
    public void removeCustomer(int id) {
        logger.info("removeCustomer" +id);
        hotelsysDao.removeCustomer(id);
    }

    @Override
    public void removeRoom(int id) {
        logger.info("removeRoom" +id);
        hotelsysDao.removeRoom(id);
    }

    @Override
    public void removeUser(int id) {
        logger.info("removeUser" +id);
        hotelsysDao.removeUser(id);
    }

    @Override
    public void addOrder(int customerId, int roomNum) {
        logger.info("addOrder: "+customerId+", "+roomNum);
        hotelsysDao.addOrder(customerId, roomNum);
    }

    @Override
    public OrderList getAllOrders() {
        logger.info("getAllOrders");
        return hotelsysDao.getAllOrders();
    }

    @Override
    public void removeOrder(int id) {
        logger.info("removeOrder "+id);
        hotelsysDao.removeOrder(id);
    }

    @Override
    public UserList getUsersByName(String name) {
        logger.info("getUsersByName" +name);
        return hotelsysDao.getUsersByName(name);
    }

    @Override
    public RoomList getFreeRooms() {
        logger.info("getFreeRooms");
        return hotelsysDao.getFreeRooms();
    }
}
