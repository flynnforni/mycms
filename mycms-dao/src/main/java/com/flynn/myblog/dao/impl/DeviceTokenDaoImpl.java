package com.flynn.myblog.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;

import com.flynn.myblog.dao.DeviceTokenDao;
import com.flynn.mycms.domain.DeviceToken;
import com.google.code.morphia.DAO;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;
import com.google.code.morphia.query.UpdateOperations;
import com.mongodb.ReadPreference;

public class DeviceTokenDaoImpl extends DAO<DeviceToken,Long> implements DeviceTokenDao {
    protected DeviceTokenDaoImpl(Datastore ds) {
        super(ds);
    }


	
	/**
	 * 删除全部注册设备测试环境用
	 */
	public void deleteAllDeviceToken() {
	       ds.delete(ds.createQuery(DeviceToken.class).filter("appname", "jdapp"));
	}
	
	/*
	 * 测试获取devicetoken
	 */
	public List<DeviceToken> selectDevicetoken(){
		ds.getMongo().setReadPreference(ReadPreference.SECONDARY);
		Query<DeviceToken> query = createQuery();
		query.field("clientVersion").greaterThan("2.4.0");
		return query.asList();
	}
    private static final Log log =LogFactory.getLog(DeviceTokenDaoImpl.class);

}
