package com.cg.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Merchant;
import com.cg.entities.User1;
@Repository
public interface MerchantDAO extends JpaRepository<Merchant,Integer> {
	@Query("select u from Merchant u where u.emailid=?1")
	public Merchant existsByEmail(String emailId);
	 @Transactional
	  @Modifying
	@Query("update Merchant u set u.password=?2 where u.emailid=?1")
	public void updatepassword(String email,String password);

}
