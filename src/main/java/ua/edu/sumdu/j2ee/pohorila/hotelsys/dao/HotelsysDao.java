package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import java.sql.Connection;

public interface HotelsysDao {
    HotelsysDao instance = new HotelsysDaoImpl();

    static HotelsysDao getInstance(){
        return instance;
    }

    Connection connect();
    void disconnect(Connection connection);
}
