package com.flynn.myblog.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.flynn.myblog.dao.BCMsgSubscribeDao;
import com.flynn.mycms.domain.BCMsgSubscribe;
import com.google.code.morphia.DAO;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

import com.mongodb.ReadPreference;

public class BCMsgSubscribeDaoImpl extends DAO<BCMsgSubscribe, String> implements BCMsgSubscribeDao {
    private static final Log log = LogFactory.getLog(BCMsgSubscribeDaoImpl.class);
	protected BCMsgSubscribeDaoImpl(Datastore ds) {
		super(ds);
	}
  
    /**
	 * 删除全部订阅测试环境用
	 */
	public void deleteBcSubscribe() {
	       ds.delete(ds.createQuery(BCMsgSubscribe.class).filter("type", "20"));
	}

}
