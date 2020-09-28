package org.com.dao;


import java.util.Optional;

import javax.transaction.Transactional;

import org.com.model.WalletAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletAccountDao extends JpaRepository<WalletAccount, Integer>{
	
	@Query("from WalletAccount where accountId=:aid")
	public WalletAccount getWalletAccount(@Param("aid") int accountId);
}
