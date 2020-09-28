package org.com.dao;

import javax.transaction.Transactional;

import org.com.model.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CardDetailsDao  extends JpaRepository<CardDetails, Integer>

{	

}
