package com.flynn.myblog.dao.impl;

import java.util.List;

import com.flynn.myblog.dao.TestMongoDao;
import com.flynn.mycms.domain.TestMongo;
import com.google.code.morphia.DAO;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.mongodb.ReadPreference;

public class TestMongoDaoImpl extends DAO<TestMongo,String> implements TestMongoDao {
	
	protected TestMongoDaoImpl(Datastore ds){
		super(ds);
	}
	
	public void insertTestMongo(TestMongo testMongo) {
		// TODO Auto-generated method stub

		super.save(testMongo);
	}

	public List<TestMongo> getAllTestMongoByPage() {
		// TODO Auto-generated method stub
		ds.getMongo().setReadPreference(ReadPreference.SECONDARY);
		Query<TestMongo> testMongoQuery = createQuery();
		return find(testMongoQuery).asList();
	}

	public void deleteTestMongoByUuid(String uuid) {
		// TODO Auto-generated method stub

	}

}
