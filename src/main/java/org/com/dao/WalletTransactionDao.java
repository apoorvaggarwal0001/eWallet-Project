package org.com.dao;

import java.util.List;

import org.com.model.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionDao extends JpaRepository <WalletTransaction, Integer>{

}
