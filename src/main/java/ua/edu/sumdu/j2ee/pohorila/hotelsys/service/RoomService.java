package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.RoomList;

@Service
public interface RoomService {
    RoomService instance = new RoomServiceImpl();

    void addRoom(String roomType, int capacity, int price, int hotelID);
    RoomList getAllRooms();
    void updateRoomPrice(int id, int price);
    void removeRoom(int id);
    RoomList getFreeRooms();
}
