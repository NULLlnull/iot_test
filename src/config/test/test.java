package config.test;

import com.mt.domain.DataConnection;
import com.mt.domain.Equipment;
import com.mt.mapper.EquipmentMapper;
import com.mt.mapper.impl.EquipmentMapperImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {
    SqlSession sqlSession = null;
    DataConnection dataConnection = new DataConnection();

    @Test
    public void TestDelete() {
        try {
            sqlSession = dataConnection.getSqlSession();
            Equipment bean = new Equipment();
//            bean.setId(1);
            bean.setMac("aa-bb-cc-dd-ee-ff-");
            bean.setType("test");
            List<Equipment> datas = new ArrayList<>();
            int i = sqlSession.insert("com.mt.mapper.EquipmentMapper.insertCreate", bean);
            System.out.println(i);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void TestImpl() {
        EquipmentMapper impl = new EquipmentMapperImpl();
        Equipment bean = new Equipment();
        bean.setMac("aa-bb-cc-dd-ee-ff-");
        bean.setType("test");
        System.out.println(impl.insertCreate(bean));
    }
}