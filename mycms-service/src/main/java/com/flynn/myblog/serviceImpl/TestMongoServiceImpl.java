package com.flynn.myblog.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.flynn.myblog.dao.BCMsgDao;
import com.flynn.myblog.dao.BCMsgSubscribeDao;
import com.flynn.myblog.dao.DeviceTokenDao;
import com.flynn.myblog.dao.TestMongoDao;
import com.flynn.myblog.service.TestMongoService;
import com.flynn.mycms.domain.DeviceToken;
import com.flynn.mycms.domain.TestMongo;

public class TestMongoServiceImpl implements TestMongoService {
	
	private final static Log log = LogFactory.getLog(TestMongoServiceImpl.class);
	
	private TestMongoDao testMongoDao;
	
	private BCMsgSubscribeDao bCMsgSubscribeDao;
	private DeviceTokenDao deviceTokenDao;
	private BCMsgDao bCMsgDao;
	
	public void insertTestMongo(TestMongo testMongo){
		testMongo = new TestMongo();
		testMongo.setPin("nifei");
		testMongo.setPassword("123456");
		testMongo.setUuid("nifei_123456");
		testMongoDao.insertTestMongo(testMongo);
	}
	
	public List<TestMongo> getAllTestMongoByPage(){
		List<TestMongo> testMongoList = new ArrayList<TestMongo>();
		testMongoList = testMongoDao.getAllTestMongoByPage();
		log.info("看看打出来的日志");
		return testMongoList;
	}
	
	public void deleteTestMongoByUuid(){
//		bCMsgSubscribeDao.deleteBcSubscribe();
//		deviceTokenDao.deleteAllDeviceToken();
//		bCMsgDao.deleteBCMsg();
//		log.info("删除成功");
		List<DeviceToken> list = new ArrayList<DeviceToken>();
		list = deviceTokenDao.selectDevicetoken();
		log.info("test");
	}
	

	public TestMongoDao getTestMongoDao() {
		return testMongoDao;
	}

	public void setTestMongoDao(TestMongoDao testMongoDao) {
		this.testMongoDao = testMongoDao;
	}

	public BCMsgSubscribeDao getbCMsgSubscribeDao() {
		return bCMsgSubscribeDao;
	}

	public void setbCMsgSubscribeDao(BCMsgSubscribeDao bCMsgSubscribeDao) {
		this.bCMsgSubscribeDao = bCMsgSubscribeDao;
	}

	public DeviceTokenDao getDeviceTokenDao() {
		return deviceTokenDao;
	}

	public void setDeviceTokenDao(DeviceTokenDao deviceTokenDao) {
		this.deviceTokenDao = deviceTokenDao;
	}

	public BCMsgDao getbCMsgDao() {
		return bCMsgDao;
	}

	public void setbCMsgDao(BCMsgDao bCMsgDao) {
		this.bCMsgDao = bCMsgDao;
	}
	
	
}
