package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.ArrayList;

public class RoomList {
    ArrayList<Room> rooms;

    public RoomList() {
        this.rooms = new ArrayList<Room>();
    }

    public void add(Room room) {
        rooms.add(room);
    }

    public ArrayList<Room> getArr(){
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
