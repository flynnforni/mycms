package com.flynn.mycms.service.impl;

import com.flynn.mycms.dao.UserInfoDao;
import com.flynn.mycms.domain.UserInfo;
import com.flynn.mycms.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDao userInfoDao;
	
	public void insertUserInfo() {
		// TODO Auto-generated method stub

	}

	public UserInfo selectUserInfoByPin(String pin) {
		// TODO Auto-generated method stub
		UserInfo userInfo = null;
		userInfo = userInfoDao.selectUserInfoByPin(pin);
		return userInfo;
	}

	public boolean updateUserInfo(String pin) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUserInfo(String pin) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	
}
