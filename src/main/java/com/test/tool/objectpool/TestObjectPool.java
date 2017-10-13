package com.test.tool.objectpool;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/9/13.
 */
public class TestObjectPool {

    public void testJDBCConnectionPool(){

        Pool<Connection> JDBCConnectionPool = new BoundedBlockingPool<Connection>(10,
                new JDBCConnectionValidator(),
                new JDBCConnectionFactory(
                        "org.postgresql.Driver",
                        "jdbc:postgresql://127.0.0.1:5432/mydb?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false",
                        "mmq",
                        "123456"));
        Connection connection = JDBCConnectionPool.get();
    }
}
