package com.test.tool.objectpool;

import com.test.tool.objectpool.ObjectFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/9/8.
 */
public class JDBCConnectionFactory implements ObjectFactory<Connection> {

    String connectionURL;
    String userName;
    String password;

    public JDBCConnectionFactory(String driver, String connectionURL,
                                 String userName, String password){

        super();
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            throw new IllegalArgumentException("unable to find driver in classpath", e);
        }
        this.connectionURL = connectionURL;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Connection createNew() {

        try{

            return DriverManager.getConnection(connectionURL, userName, password);

        }catch (SQLException e){
            throw new IllegalArgumentException("unable to create new connection", e);
        }
    }

}
