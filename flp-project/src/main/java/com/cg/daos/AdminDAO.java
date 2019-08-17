package com.cg.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Admin;
import com.cg.entities.User1;
@Repository
public interface AdminDAO extends JpaRepository< Admin,Integer> {
	@Query("select u from Admin u where u.emailid=?1")
	public Admin existsByEmail(String emailId);
	 @Transactional
	  @Modifying
	@Query("update Admin u set u.password=?2 where u.emailid=?1")
	public void updatepassword(String email,String password);

}
