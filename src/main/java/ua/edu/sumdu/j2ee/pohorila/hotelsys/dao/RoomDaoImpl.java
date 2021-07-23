package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Room;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.RoomList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RoomDaoImpl implements RoomDao{
    public RoomDaoImpl(){
        super();
    }

    @Autowired
    public HotelsysDao hotelsysDao;
    private PreparedStatement preparedStatement = null;
    Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Override
    public void addRoom(String roomType, int capacity, int price, int hotelID) {
        Connection connection = hotelsysDao.connect();
        try {
            String sql = "select LAB3_EP_ROOM_SEQUENCE.nextval from DUAL";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int id = 0;
            if(rs.next())
                id = rs.getInt(1);
            preparedStatement = connection.prepareStatement("insert into LAB3_EP_ROOM values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, roomType);
            preparedStatement.setInt(3, capacity);
            preparedStatement.setInt(4, price);
            preparedStatement.setInt(5, hotelID);
            preparedStatement.execute();
            logger.info("addRoom: "+roomType+", "+capacity+ ", "+price+", "+hotelID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }

    @Override
    public Room parseRoom(ResultSet resultSet) throws SQLException {
        int roomNumber = resultSet.getInt("LAB3_EP_ROOM_NUMBER");
        String roomType = resultSet.getString("LAB3_EP_ROOM_TYPE");
        int capacity = resultSet.getInt("LAB3_EP_ROOM_CAPACITY");
        int price = resultSet.getInt("LAB3_EP_ROOM_PRICE");
        int hotel_id = resultSet.getInt("LAB3_EP_ROOM_HOTEL_ID");
        Room room = new Room(roomNumber,roomType, capacity, price, hotel_id);
        logger.info("parseRoom");
        return room;
    }

    @Override
    public RoomList getAllRooms() {
        Connection connection = hotelsysDao.connect();
        RoomList roomList = new RoomList();
        try {
            preparedStatement = connection.prepareStatement("select * from LAB3_EP_ROOM");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                roomList.add(parseRoom(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
        logger.info("getAllRooms");
        return roomList;
    }

    @Override
    public void updateRoomPrice(int id, int price) {
        Connection connection = hotelsysDao.connect();
        try {
            preparedStatement = connection.prepareStatement("update LAB3_EP_ROOM set LAB3_EP_ROOM_PRICE = ? where " +
                    "LAB3_EP_ROOM_NUMBER = ? ");
            preparedStatement.setInt(1, price);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            logger.info("updateRoomPrice id:"+id+", price:"+price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }

    @Override
    public void removeRoom(int id) {
        Connection connection = hotelsysDao.connect();
        try {
            preparedStatement = connection.prepareStatement("delete from LAB3_EP_ROOM where LAB3_EP_ROOM_NUMBER = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("removeRoom" +id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }

    @Override
    public RoomList getFreeRooms() {
        Connection connection = hotelsysDao.connect();
        RoomList roomList = new RoomList();
        try {
            preparedStatement = connection.prepareStatement("SELECT DISTINCT * FROM LAB3_EP_ROOM rooms WHERE LAB3_EP_ROOM_NUMBER != all(select LAB3_EP_ROOM_NUMBER from LAB3_EP_ORDER)");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                roomList.add(parseRoom(resultSet));
            }
            logger.info("getFreeRooms");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
        return roomList;
    }

}
