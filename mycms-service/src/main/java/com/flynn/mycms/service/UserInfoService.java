package com.flynn.mycms.service;

import com.flynn.mycms.domain.UserInfo;

public interface UserInfoService {
	
	public void insertUserInfo();
	
	public UserInfo selectUserInfoByPin(String pin);
	
	public boolean updateUserInfo(String pin);
	
	public boolean deleteUserInfo(String pin);
}
