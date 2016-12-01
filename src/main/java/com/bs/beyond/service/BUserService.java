package com.bs.beyond.service;

import com.bs.beyond.bo.BUserBO;

public interface BUserService
{
	public BUserBO validateUser(BUserBO bUserBO);
	
	public void changePassword(BUserBO bUserBO);

	public void addUser(BUserBO bUserBO);
	
	public void updateUser(BUserBO bUserBO);

	public void deleteUser(BUserBO bUserBO);
}
