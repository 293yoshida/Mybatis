package jp.cp.newdaysys.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import jp.cp.newdaysys.Interface.TestMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		FileInputStream fis;
		try {
			fis = new FileInputStream("config\\mybatis-config.xml");
		
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fis);
			SqlSession session = sqlSessionFactory.openSession(true);
			TestMapper mapper = session.getMapper(TestMapper.class);
		
			// id="select"
			Test t1 = mapper.select(1);
			System.out.println(t1.getId() + ":" + t1.getName());
		
			// id="insert"
			Test t2 = new Test();
			t2.setId(3);
			t2.setName("oro");
			mapper.insert(t2);
		
			// id="selectALL"
			List<Test> list = mapper.selectALL();
			for (Test t : list) {
				System.out.println(t.getId() + ":" + t.getName());
			}
		
			session.close();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
