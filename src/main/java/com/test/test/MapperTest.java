package com.test.test;

import com.test.entity.BlzImgEntity;
import com.test.mapper.BlzImgMapper;
import com.test.tool.objectpool.BoundedBlockingPool;
import com.test.tool.objectpool.JDBCConnectionFactory;
import com.test.tool.objectpool.JDBCConnectionValidator;
import com.test.tool.objectpool.Pool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {


    @Autowired
    private BlzImgMapper blzImgMapper;

    @Test
    public void testQuery() throws Exception{

        List<BlzImgEntity> blzImgEntityList = blzImgMapper.getAll();

        System.out.println(blzImgEntityList.size());

        Pool<Connection> JDBCConnectionPool = new BoundedBlockingPool<Connection>(10,
                new JDBCConnectionValidator(),
                new JDBCConnectionFactory(
                        "org.postgresql.Driver",
                        "jdbc:postgresql://127.0.0.1:5432/mydb?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false",
                        "mmq",
                        "123456"));
        Connection connection = JDBCConnectionPool.get();

        System.out.println(connection.getSchema());
    }
}
