package ua.edu.sumdu.j2ee.pohorila.hotelsys.model;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

public class Room {
    int roomNumber;
    String roomType;
    int capacity;
    int price;
    int hotelID;

    public Room(int roomNumber, String roomType, int capacity, int price, int hotelID) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.capacity = capacity;
        this.price = price;
        this.hotelID = hotelID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber && capacity == room.capacity && price == room.price && Objects.equals(roomType, room.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomType, capacity, price);
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public static Comparator<Room> roomNumComparator = new Comparator<Room>() {
        @Override
        public int compare(Room o1, Room o2) {
            int first = o1.getRoomNumber();
            int second = o2.getRoomNumber();
            return first-second;
        }
    };

    public static Comparator<Room> roomTypeComparator = new Comparator<Room>() {
        @Override
        public int compare(Room o1, Room o2) {
            String first = o1.getRoomType().toUpperCase(Locale.ROOT);
            String second = o2.getRoomType().toUpperCase(Locale.ROOT);
            return first.compareTo(second);
        }
    };

    public static Comparator<Room> capacityComparator = new Comparator<Room>() {
        @Override
        public int compare(Room o1, Room o2) {
            int first = o1.getCapacity();
            int second = o2.getCapacity();
            return first-second;
        }
    };

    public static Comparator<Room> priceComparator = new Comparator<Room>() {
        @Override
        public int compare(Room o1, Room o2) {
            int first = o1.getPrice();
            int second = o2.getPrice();
            return first-second;
        }
    };

    public static Comparator<Room> hotelIdComparator = new Comparator<Room>() {
        @Override
        public int compare(Room o1, Room o2) {
            int first = o1.getHotelID();
            int second = o2.getHotelID();
            return first-second;
        }
    };

}
