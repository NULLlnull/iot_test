package com.mt.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DataConnection {
    private String resource = "com/mt/mapper/config.xml";
    private String test = "com/mt/mapper/EquipmentMapper.xml";
    private SqlSessionFactory factory;
    private SqlSession sqlSession;

    public SqlSession getSqlSession() throws IOException {
        InputStream is = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入MyBatis配置文件信息
        factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
        return sqlSession;
    }
}
