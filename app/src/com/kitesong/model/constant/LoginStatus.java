package com.kitesong.model.constant;

public interface LoginStatus {

	int USER_NOT_EXIST = 0x1;
	
	int PASSWORD_NOT_CORRECT = 0X2;
	
	int LOGIN_OK = 0x4;
	
	int CONNECT_FAIL = 0x8;
}
