package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Room;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.RoomList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RoomDao {
    RoomDao instance = new RoomDaoImpl();

    static RoomDao getInstance(){
        return instance;
    }
    void addRoom(String roomType, int capacity, int price, int hotelID);
    RoomList getAllRooms();
    Room parseRoom(ResultSet resultSet) throws SQLException;
    void updateRoomPrice(int id, int price);
    void removeRoom(int id);
    RoomList getFreeRooms();
}
