package com.flynn.myblog.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.flynn.mycms.domain.BCMsg;

/**
 * 广播消息的dao接口 提供了对广播消息记录的增删改查操作
 */
public interface BCMsgDao {
	
   /**
    * 根据广播消息id删除该条消息
    * */
   public void deleteBCMsg();

    
}
