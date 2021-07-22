package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomList roomList = (RoomList) o;
        return Objects.equals(rooms, roomList.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms);
    }

    @Override
    public String toString() {
        return "RoomList{" +
                "rooms=" + rooms +
                '}';
    }
}
