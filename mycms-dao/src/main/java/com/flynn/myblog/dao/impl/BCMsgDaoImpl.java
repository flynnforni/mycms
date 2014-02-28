package com.flynn.myblog.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;

import com.flynn.myblog.dao.BCMsgDao;
import com.flynn.mycms.domain.BCMsg;
import com.google.code.morphia.DAO;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;
import com.mongodb.ReadPreference;

public class BCMsgDaoImpl extends DAO<BCMsg, ObjectId> implements BCMsgDao {
    private static final Log log = LogFactory.getLog(BCMsgDaoImpl.class);
	
	protected BCMsgDaoImpl(Datastore ds) {
		super(ds);
	}
    
	public void deleteBCMsg(){
		ds.delete(ds.createQuery(BCMsg.class).filter("flag", "1"));
	}

}
