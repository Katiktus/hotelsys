package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.User;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.UserList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao{
    public UserDaoImpl(){
        super();
    }

    @Autowired
    public HotelsysDao hotelsysDao;
    private PreparedStatement preparedStatement = null;
    Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void addUser(String name, int managerId, int roleId, String phoneNum, int hotelId) {
        Connection connection = hotelsysDao.connect();
        try {
            String sql = "select LAB3_EP_USER_SEQUENCE.nextval from DUAL";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int id = 0;
            if(rs.next())
                id = rs.getInt(1);
            preparedStatement = connection.prepareStatement("INSERT INTO LAB3_EP_USER values (?,?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, roleId);
            preparedStatement.setInt(3, managerId);
            preparedStatement.setInt(4, id);
            preparedStatement.setString(5, phoneNum);
            preparedStatement.setInt(6, hotelId);
            preparedStatement.execute();
            logger.info("addUser: "+name+", "+managerId+ ", "+roleId+", "+phoneNum+", "+hotelId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
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
        logger.info("parseUser");
        return user;
    }

    @Override
    public UserList getAllUsers() {
        Connection connection = hotelsysDao.connect();
        UserList userList = new UserList();
        try {
            preparedStatement = connection.prepareStatement("select * from LAB3_EP_USER");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                userList.add(parseUser(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
        logger.info("getAllUsers");
        return userList;

    }

    @Override
    public void updateUserMgr(int id, int mgrId) {
        Connection connection = hotelsysDao.connect();
        try {
            preparedStatement = connection.prepareStatement("update LAB3_EP_USER set LAB3_EP_MGR_ID = ? where " +
                    "LAB3_EP_USER_ID = ? ");
            preparedStatement.setInt(1, mgrId);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            logger.info("updateUserMgr id:"+id+", mgrId:"+mgrId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }

    @Override
    public void updateUserRole(int id, int roleId) {
        Connection connection = hotelsysDao.connect();
        try {
            preparedStatement = connection.prepareStatement("update LAB3_EP_USER set LAB3_EP_ROLE_ID = ? where " +
                    "LAB3_EP_USER_ID = ? ");
            preparedStatement.setInt(1, roleId);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            logger.info("updateUserRole id:"+id+", roleId:"+roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }

    @Override
    public void updateUserPhone(int id, String phoneNum) {
        Connection connection = hotelsysDao.connect();
        try {
            preparedStatement = connection.prepareStatement("update LAB3_EP_USER set LAB3_EP_USER_PHONE_NUMBER = ? where " +
                    "LAB3_EP_USER_ID = ? ");
            preparedStatement.setString(1, phoneNum);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            logger.info("updateUserPhone id:"+id+", phoneNum:"+phoneNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }

    @Override
    public void removeUser(int id) {
        Connection connection = hotelsysDao.connect();
        try {
            preparedStatement = connection.prepareStatement("delete from LAB3_EP_USER where LAB3_EP_USER_ID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("removeUser" +id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
    }

    @Override
    public UserList getUsersByName(String name) {
        Connection connection = hotelsysDao.connect();
        UserList userList = new UserList();
        try {
            preparedStatement = connection.prepareStatement("select * from LAB3_EP_USER where LAB3_EP_USER_NAME LIKE upper(?)");
            preparedStatement.setString(1, name+'%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                userList.add(parseUser(resultSet));
            }
            logger.info("getUsersByName" +name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        hotelsysDao.disconnect(connection);
        return userList;
    }

}
