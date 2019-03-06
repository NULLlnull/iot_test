package com.mt.mapper.impl;

import com.mt.domain.DataConnection;
import com.mt.domain.Equipment;
import com.mt.domain.EquipmentExample;
import com.mt.mapper.EquipmentMapper;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class EquipmentMapperImpl implements EquipmentMapper {
    private static final int INSERT = 1, UPDATE = 2, DELETE = 3, SELECT_ONE = 4, SELECT = 5;
    private SqlSession sqlSession = null;
    private DataConnection dataConnection = null;

    public EquipmentMapperImpl() {
        dataConnection = new DataConnection();
    }

    @Override
    public long countByExample(EquipmentExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(EquipmentExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Equipment record) {
        return 0;
    }

    @Override
    public int insertSelective(Equipment record) {
        return 0;
    }

    @Override
    public int insertCreate(Equipment record) {
        return MyUtils(INSERT, "com.mt.mapper.EquipmentMapper.insertCreate", record);
    }

    @Override
    public int insertBase(Equipment record) {
        return 0;
    }

    @Override
    public List<Equipment> selectByClasss(String classs) {

        return null;
    }

    @Override
    public List<Equipment> selectByExample(EquipmentExample example) {
        ResultHandler handler = new ResultHandler() {
            @Override
            public void handleResult(ResultContext resultContext) {
            }
        };
        return null;
    }

    @Override
    public Equipment selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Equipment record, EquipmentExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Equipment record, EquipmentExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Equipment record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Equipment record) {
        return 0;
    }

    private int MyUtils(int type, String mapper, Object bean) {
        int resultNum = 0;
        try {
            sqlSession = dataConnection.getSqlSession();
            switch (type) {
                case INSERT:
                    resultNum = sqlSession.insert(mapper, bean);
                    break;
                case SELECT_ONE:
                    resultNum = sqlSession.selectOne(mapper, bean);
                    break;
                case UPDATE:
                    resultNum = sqlSession.update(mapper, bean);
                    break;
                case DELETE:
                    resultNum = sqlSession.delete(mapper, bean);
                    break;
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return resultNum;
    }
}
