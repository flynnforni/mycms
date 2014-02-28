package com.flynn.myblog.service;

import java.util.List;

import com.flynn.mycms.domain.TestMongo;

public interface TestMongoService {

	public void insertTestMongo(TestMongo testMongo);
	
	public List<TestMongo> getAllTestMongoByPage();
	
	public void deleteTestMongoByUuid();
}
