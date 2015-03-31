package jp.cp.newdaysys.Interface;

import java.util.List;

import jp.cp.newdaysys.sample.Test;

public interface TestMapper {
	Test select(int id);
	List<Test> selectALL();
	void insert(Test t);
}
