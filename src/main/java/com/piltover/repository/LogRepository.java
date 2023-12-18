package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piltover.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

    @Query("SELECT l FROM Log l WHERE l.account.id = :accountId")
    List<Log> findLogsByAccountId(@Param("accountId") Long accountId);
}
