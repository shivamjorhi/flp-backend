package com.cg.service;

import java.security.MessageDigest;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.daos.AdminDAO;
import com.cg.daos.MerchantDAO;
import com.cg.daos.UserDAO;
import com.cg.entities.Admin;
import com.cg.entities.Merchant;
import com.cg.entities.PasswordEntity;
import com.cg.entities.User1;
@Service
public class passwordServiceImpl implements passwordService {
	private String secretKey="SomeSecretKey";
	@Autowired UserDAO userDao;
	@Autowired AdminDAO adminDao;
	@Autowired MerchantDAO merchantDao;
	
	@Override
	public PasswordEntity changepassword(PasswordEntity entity) {
		String type=entity.getCategory();
		if(type.equals("user"))
		{
			String uname=entity.getEmail();
			User1 userObject=userDao.existsByEmail(uname);
			if(userObject==null)
			{
				entity.setCategory("No record found for this user");
				return entity;
			}
			Cryptography c=new Cryptography();
			String encryptedOriginalPassword=userObject.getPassword();
			
			
			
			if(c.decrypt(encryptedOriginalPassword,secretKey).equals(entity.getOld_password()))
			{
				if(entity.getNew_password().equals(entity.getConfirm_password()))
				{String encryptPassword=c.encrypt(entity.getNew_password(),this.secretKey);
				  userDao.updatepassword(entity.getEmail(), encryptPassword);
				  entity.setCategory("password changed successfully");
				  return entity;
				}
				else
				{
					entity.setCategory("both passwords don't match");
					return entity;
				}
				
			}
			
			else
			{
				entity.setCategory("old password is incorrect");
				return entity;
			}
		}
		if(type.equals("merchant"))
		{
			String uname=entity.getEmail();
			Merchant merchantObject=merchantDao.existsByEmail(uname);
			if(merchantObject==null)
			{
				entity.setCategory("No record found for this merchant");
				return entity;
			}
			Cryptography c=new Cryptography();
			String encryptedOriginalPassword=merchantObject.getPassword();
			if(c.decrypt(encryptedOriginalPassword, secretKey).equals(entity.getOld_password()))
			{
				if(entity.getNew_password().equals(entity.getConfirm_password()))
				{
					merchantDao.updatepassword(entity.getEmail(), c.encrypt(entity.getNew_password(),this.secretKey));
					entity.setCategory("password changed successfully");
					return entity;
				}
				else
				{
					entity.setCategory("both passwords don't match");
					return entity;
				}
				
			}
			
			else
			{
				entity.setCategory("old password is incorrect");
				return entity;
			}
		}
		if(type.equals("admin"))
		{
			String uname=entity.getEmail();
			Admin adminObject=adminDao.existsByEmail(uname);
			if(adminObject==null)
			{
				entity.setCategory("No record found for this admin");
				return entity;
			}
			Cryptography c=new Cryptography();
			String encryptedOriginalPassword=adminObject.getPassword();
			if(c.decrypt(encryptedOriginalPassword,secretKey).equals(entity.getOld_password()))
			{
				if(entity.getNew_password().equals(entity.getConfirm_password()))
				{
					adminDao.updatepassword(entity.getEmail(), c.encrypt(entity.getNew_password(),this.secretKey));
					entity.setCategory("password changed successfully");
					return entity;
				}
				else
				{
					entity.setCategory("both passwords don't match");
					return entity;
				}
				
			}
			
			else
			{
				entity.setCategory("old password is incorrect");
				return entity;
			}
		}
		entity.setCategory("Sorry!! You are not an authorised person");
		return entity;
		
	}
	
	
	
	



}
