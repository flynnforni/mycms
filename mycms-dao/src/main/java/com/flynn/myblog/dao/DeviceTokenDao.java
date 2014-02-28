package com.flynn.myblog.dao;

import java.util.Date;
import java.util.List;

import com.flynn.mycms.domain.DeviceToken;

/**
 * 设备注册相关的curd操作
 * User: gaotianlin
 * Date: 12-6-19
 * Time: 下午6:52
 */
public interface DeviceTokenDao {

	/*
	 * 测试删除devicetoken
	 */
	public void deleteAllDeviceToken();
	
	/*
	 * 测试获取devicetoken
	 */
	public List<DeviceToken> selectDevicetoken();
	
}
