package com.flynn.myblog.dao;

import java.util.Date;
import java.util.List;

import com.flynn.mycms.domain.DeviceToken;

/**
 * �豸ע����ص�curd����
 * User: gaotianlin
 * Date: 12-6-19
 * Time: ����6:52
 */
public interface DeviceTokenDao {

	/*
	 * ����ɾ��devicetoken
	 */
	public void deleteAllDeviceToken();
	
	/*
	 * ���Ի�ȡdevicetoken
	 */
	public List<DeviceToken> selectDevicetoken();
	
}
