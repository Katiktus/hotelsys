package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import org.springframework.stereotype.Repository;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

@Repository
public class HotelsysDaoImpl implements HotelsysDao{

    public HotelsysDaoImpl(){
        super();
    }

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private DataSource dataSource;
    private Context context;
    private Hashtable hashtable = new Hashtable();

    @Override
    public void connect(){
        try{
            hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
            hashtable.put(Context.PROVIDER_URL, "t3://localhost:7001");
            context = new InitialContext(hashtable);
            dataSource = (DataSource) context.lookup("DataSourceHotel");
            connection = dataSource.getConnection();
            if(!connection.isClosed()){
                System.out.println("Connection successful...");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect(){
        try{
            if(connection != null)
                connection.close();
            if(context != null)
                context.close();
        } catch (SQLException | NamingException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addCustomer(String name, String phoneNumber) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("insert into LAB3_EP_CUSTOMER values (null, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public void addRoom(int roomNumber, String roomType, int capacity, int price, int hotelID) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("insert into LAB3_EP_ROOM values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, roomNumber);
            preparedStatement.setString(2, roomType);
            preparedStatement.setInt(3, capacity);
            preparedStatement.setInt(4, price);
            preparedStatement.setInt(5, hotelID);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();

    }

    @Override
    public void addUser(String name, int managerId, int roleId, int userId, String phoneNum, int hotelId) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO LAB3_EP_USER values (?,?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, roleId);
            preparedStatement.setInt(3, managerId);
            preparedStatement.setInt(4, userId);
            preparedStatement.setString(5, phoneNum);
            preparedStatement.setInt(6, hotelId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public CustomerList getAllCustomer() {
        connect();
        CustomerList customerList = new CustomerList();
        try {
            preparedStatement = connection.prepareStatement("select * from LAB3_EP_CUSTOMER");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                customerList.add(parseCustomer(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        disconnect();
        return customerList;
    }

    @Override
    public Customer parseCustomer(ResultSet resultSet) throws SQLException {
        int customerid = resultSet.getInt("LAB3_EP_CUSTOMER_ID");
        String name = resultSet.getString("LAB3_EP_CUSTOMER_NAME");
        String phoneNumber = resultSet.getString("LAB3_EP_CUSTOMER_PHONE_NUMBER");
        Customer customer = new Customer(customerid, name, phoneNumber);
        return customer;
    }

    @Override
    public Room parseRoom(ResultSet resultSet) throws SQLException {
        int roomNumber = resultSet.getInt("LAB3_EP_ROOM_NUMBER");
        String roomType = resultSet.getString("LAB3_EP_ROOM_TYPE");
        int capacity = resultSet.getInt("LAB3_EP_ROOM_CAPACITY");
        int price = resultSet.getInt("LAB3_EP_ROOM_PRICE");
        int hotel_id = resultSet.getInt("LAB3_EP_ROOM_HOTEL_ID");
        Room room = new Room(roomNumber,roomType, capacity, price, hotel_id);
        return room;
    }

    @Override
    public User parseUser(ResultSet resultSet) throws SQLException {
        int managerid = resultSet.getInt("LAB3_EP_MGR_ID");
        String name = resultSet.getString("LAB3_EP_USER_NAME");
        int userid = resultSet.getInt("LAB3_EP_USER_ID");
        int roleid = resultSet.getInt("LAB3_EP_ROLE_ID");
        String phoneNumber = resultSet.getString("LAB3_EP_USER_PHONE_NUMBER");
        int hotelid = resultSet.getInt("LAB3_EP_USER_HOTEL_ID");
        User user = new User(name, managerid, userid, roleid, phoneNumber, hotelid);
        return user;
    }

    @Override
    public RoomList getAllRooms() {
        connect();
        RoomList roomList = new RoomList();
        try {
            preparedStatement = connection.prepareStatement("select * from LAB3_EP_ROOM");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                roomList.add(parseRoom(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        disconnect();
        return roomList;
    }

    @Override
    public UserList getAllUsers() {
        connect();
        UserList userList = new UserList();
        try {
            preparedStatement = connection.prepareStatement("select * from LAB3_EP_USER");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                userList.add(parseUser(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        disconnect();
        return userList;

    }

    @Override
    public void updateCustomerPhone(int id, String phone) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("update LAB3_EP_CUSTOMER set LAB3_EP_CUSTOMER_PHONE_NUMBER = ? where " +
                    "LAB3_EP_CUSTOMER_ID = ? ");
            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public void updateRoomPrice(int id, int price) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("update LAB3_EP_ROOM set LAB3_EP_ROOM_PRICE = ? where " +
                    "LAB3_EP_ROOM_NUMBER = ? ");
            preparedStatement.setInt(1, price);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public void updateUserMgr(int id, int mgrId) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("update LAB3_EP_USER set LAB3_EP_MGR_ID = ? where " +
                    "LAB3_EP_USER_ID = ? ");
            preparedStatement.setInt(1, mgrId);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public void updateUserRole(int id, int roleId) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("update LAB3_EP_USER set LAB3_EP_ROLE_ID = ? where " +
                    "LAB3_EP_USER_ID = ? ");
            preparedStatement.setInt(1, roleId);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public void updateUserPhone(int id, String phoneNum) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("update LAB3_EP_USER set LAB3_EP_USER_PHONE_NUMBER = ? where " +
                    "LAB3_EP_USER_ID = ? ");
            preparedStatement.setString(1, phoneNum);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public void removeCustomer(int id) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("delete from LAB3_EP_CUSTOMER where LAB3_EP_CUSTOMER_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public void removeRoom(int id) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("delete from LAB3_EP_ROOM where LAB3_EP_ROOM_NUMBER = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public void removeUser(int id) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("delete from LAB3_EP_USER where LAB3_EP_USER_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public void addOrder(int id, int customerId, int roomNum) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("insert into LAB3_EP_ORDER values (?, ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, customerId);
            preparedStatement.setInt(3, roomNum);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public OrderList getAllOrders() {
        connect();
        OrderList orderList = new OrderList();
        try {
            preparedStatement = connection.prepareStatement("select * from LAB3_EP_ORDER");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                orderList.add(parseOrder(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        disconnect();
        return orderList;
    }

    @Override
    public Order parseOrder(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("LAB3_EP_ORDER_ID");
        int customerId = resultSet.getInt("LAB3_EP_ORDER_CUSTOMER_ID");
        int roomNumber = resultSet.getInt("LAB3_EP_ROOM_NUMBER");
        Order order = new Order(id, customerId, roomNumber);
        return order;
    }

    @Override
    public void removeOrder(int id) {
        connect();
        try {
            preparedStatement = connection.prepareStatement("delete from LAB3_EP_ORDER where LAB3_EP_ORDER_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }
}
