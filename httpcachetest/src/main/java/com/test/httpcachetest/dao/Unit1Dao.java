package com.test.httpcachetest.dao;

import com.test.httpcachetest.model.Unit1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Unit1Dao extends JpaRepository<Unit1,Integer> {
}
