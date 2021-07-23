package ua.edu.sumdu.j2ee.pohorila.hotelsys.dao;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
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
    Logger logger = LoggerFactory.getLogger(HotelsysDaoImpl.class);

    @Value( "${provider.url}" )
    private String providerUrl;
    @Value( "${initFactory.name}" )
    private String initFactory;
    @Value( "${datasource.name}" )
    private String dataSourceName;

    @Override
    public Connection connect(){
        try{
            hashtable.put(Context.INITIAL_CONTEXT_FACTORY, initFactory);
            hashtable.put(Context.PROVIDER_URL,providerUrl);
            context = new InitialContext(hashtable);
            dataSource = (DataSource) context.lookup(dataSourceName);
            connection = dataSource.getConnection();
            if(!connection.isClosed()){
                System.out.println("Connection successful...");
            }
            String[] tables = {"LAB3_EP_CUSTOMER", "LAB3_EP_HOTEL", "LAB3_EP_ORDER", "LAB3_EP_ROOM", "LAB3_EP_USER", "LAB3_EP_USER_ROLE"};
            DatabaseMetaData metadata = connection.getMetaData();

            for(int i=0; i< tables.length; i++) {
                ResultSet rs = metadata.getTables(null, null, tables[i], null);
                if(!rs.next()) {
                    ScriptRunner sr = new ScriptRunner(connection);
                    Reader reader = new BufferedReader(new FileReader("script.sql"));
                    sr.runScript(reader);
                }
            }
            logger.info("connect");
        } catch (SQLException | NamingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void disconnect(Connection connection){
        try{
            if(connection != null)
                connection.close();
            if(context != null)
                context.close();
            logger.info("disconnect");
        } catch (SQLException | NamingException throwables) {
            throwables.printStackTrace();
        }
    }

}
