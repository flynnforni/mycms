package com.flynn.mycms.dao;

import com.flynn.mycms.domain.UserInfo;

public interface UserInfoDao {

	public void insertUserInfo();
	
	public UserInfo selectUserInfoByPin(String pin);
	
	public boolean updateUserInfo(String pin);
	
	public boolean deleteUserInfo(String pin);
}
