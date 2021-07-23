package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.dao.RoomDao;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.RoomList;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    public RoomDao roomDao;
    Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

    @Override
    public void addRoom(String roomType, int capacity, int price, int hotelID) {
        logger.info("addRoom: "+roomType+", "+capacity+ ", "+price+", "+hotelID);
        roomDao.addRoom(roomType, capacity, price, hotelID);
    }

    @Override
    public RoomList getAllRooms() {
        logger.info("getAllRooms");
        return roomDao.getAllRooms();
    }

    @Override
    public void updateRoomPrice(int id, int price) {
        logger.info("updateRoomPrice id:"+id+", price:"+price);
        roomDao.updateRoomPrice(id, price);
    }

    @Override
    public void removeRoom(int id) {
        logger.info("removeRoom" +id);
        roomDao.removeRoom(id);
    }

    @Override
    public RoomList getFreeRooms() {
        logger.info("getFreeRooms");
        return roomDao.getFreeRooms();
    }

}
