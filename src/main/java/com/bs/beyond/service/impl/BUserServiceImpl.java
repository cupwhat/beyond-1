package com.bs.beyond.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.beyond.bo.BUserBO;
import com.bs.beyond.core.BsConst;
import com.bs.beyond.core.util.MessageUtil;
import com.bs.beyond.dao.BUserMapper;
import com.bs.beyond.entity.BUser;
import com.bs.beyond.service.BUserService;

@Transactional
@Service("BUserService")
public class BUserServiceImpl implements BUserService
{

	@Autowired
	private BUserMapper bUserMapper;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Override
	public BUserBO validateUser(BUserBO bUserBO)
	{
		String nUserId = bUserBO.getUserId();
		String sPassword = bUserBO.getPassword();
		
		BUser bUser = bUserMapper.selectByPrimaryKey(nUserId);

		BUserBO bo = new BUserBO();
		
		if (bUser == null)
		{
			bo.setBsResult(BsConst.ResultCode.FAIL);
			bo.setBsMessage(messageUtil.getMessage("error.beyond.login.user.not_exist"));
		}
		else if (!sPassword.equals(bUser.getPassword()))
		{
			bo.setBsResult(BsConst.ResultCode.FAIL);
			bo.setBsMessage(messageUtil.getMessage("error.beyond.login.user.password_wrong"));
		}
		else
		{
			bo.setBsResult(BsConst.ResultCode.SUCCESS);
			
			bo.setUserId(bUser.getUserId());
			bo.setUserName(bUser.getUserName());
			bo.setPassword(bUser.getPassword());
		}
		
		return bo;
	}

	@Override
	public void changePassword(BUserBO bUser)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(BUserBO bUser)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(BUserBO bUser)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(BUserBO bUser)
	{
		// TODO Auto-generated method stub
		
	}

}
