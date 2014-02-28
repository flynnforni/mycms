package com.flynn.mycms.dao.impl;


import com.flynn.mycms.base.BaseDao;
import com.flynn.mycms.dao.UserInfoDao;
import com.flynn.mycms.domain.UserInfo;

public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

	public void insertUserInfo() {
		// TODO Auto-generated method stub
		
	}
	
	public UserInfo selectUserInfoByPin(String pin) {
		// TODO Auto-generated method stub
		UserInfo userInfo = null;
		userInfo = (UserInfo) queryForObject("UserInfo.getUserInfoByPin",pin);
		return userInfo;
	}
	
	public boolean updateUserInfo(String pin){
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean deleteUserInfo(String pin){
		// TODO Auto-generated method stub
		return false;
	}

}
