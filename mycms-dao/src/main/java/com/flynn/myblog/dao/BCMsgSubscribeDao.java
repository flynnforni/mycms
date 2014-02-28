package com.flynn.myblog.dao;

import java.io.Serializable;

import com.flynn.mycms.domain.BCMsgSubscribe;

public interface BCMsgSubscribeDao extends Serializable {
    
    /**
	 * 删除全部订阅测试环境用
	 */
	public void deleteBcSubscribe();
}
