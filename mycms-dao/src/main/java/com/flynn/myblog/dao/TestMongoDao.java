package com.flynn.myblog.dao;

import java.util.List;

import com.flynn.mycms.domain.TestMongo;

public interface TestMongoDao {

	public void insertTestMongo(TestMongo testMongo);
	
	public List<TestMongo> getAllTestMongoByPage();
	
	public void deleteTestMongoByUuid(String uuid);
	
}
