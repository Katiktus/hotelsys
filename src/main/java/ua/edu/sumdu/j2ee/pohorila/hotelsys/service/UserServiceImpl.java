package ua.edu.sumdu.j2ee.pohorila.hotelsys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.dao.UserDao;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.UserList;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserDao userDao;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void addUser(String name, int managerId, int roleId, String phoneNum, int hotelId) {
        logger.info("addUser: "+name+", "+managerId+ ", "+roleId+", "+phoneNum+", "+hotelId);
        userDao.addUser(name, managerId, roleId, phoneNum, hotelId);
    }


    @Override
    public UserList getAllUsers() {
        logger.info("getAllUsers");
        return userDao.getAllUsers();
    }


    @Override
    public void updateUserMgr(int id, int mgrId) {
        logger.info("updateUserMgr id:"+id+", mgrId:"+mgrId);
        userDao.updateUserMgr(id, mgrId);
    }

    @Override
    public void updateUserRole(int id, int roleId) {
        logger.info("updateUserRole id:"+id+", roleId:"+roleId);
        userDao.updateUserRole(id, roleId);
    }

    @Override
    public void updateUserPhone(int id, String phoneNum) {
        logger.info("updateUserPhone id:"+id+", phoneNum:"+phoneNum);
        userDao.updateUserPhone(id, phoneNum);
    }
    @Override
    public void removeUser(int id) {
        logger.info("removeUser" +id);
        userDao.removeUser(id);
    }
    @Override
    public UserList getUsersByName(String name) {
        logger.info("getUsersByName" +name);
        return userDao.getUsersByName(name);
    }
}
