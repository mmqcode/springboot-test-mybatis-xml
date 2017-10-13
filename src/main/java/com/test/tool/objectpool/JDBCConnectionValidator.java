package com.test.tool.objectpool;

import com.test.tool.objectpool.Pool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/9/7.
 */
public final class JDBCConnectionValidator implements Pool.Validator<Connection> {

    @Override
    public boolean isValid(Connection connection) {
        if(null == connection){
            return false;
        }
        try{
            return !connection.isClosed();
        }catch (SQLException e){

            return false;
        }
    }

    @Override
    public void inValidate(Connection connection) {
        try{
            connection.close();
        }catch (SQLException e){

        }
    }
}
