package config.test;

import com.mt.domain.DataConnection;
import com.mt.domain.Equipment;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class test {
    SqlSession sqlSession = null;
    DataConnection dataConnection = new DataConnection();

    @Test
    public void TestDelete() {
        try {
            sqlSession = dataConnection.getSqlSession();
            Equipment bean = new Equipment();
            bean.setId(1);
            bean.setMac("aa-bb-cc-dd-ee-ff");
            bean.setType("test");
            sqlSession.insert("com.mt.mapper.EquipmentMapper.insert", bean);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}