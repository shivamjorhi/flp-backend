package com.cg.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.User1;
@Repository

public interface UserDAO extends JpaRepository<User1,Integer>{
	@Query("select u from User1 u where u.emailid=?1")
	public User1 existsByEmail(String emailId);
	
	
	 @Transactional
	  @Modifying
	@Query("update User1 u set u.password=?2 where u.emailid=?1")
	public void updatepassword(String email,String password);
	
}
