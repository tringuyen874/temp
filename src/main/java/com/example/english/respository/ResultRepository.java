package com.example.english.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.english.model.Result;

public interface ResultRepository extends JpaRepository<Result, Integer>{
    @Query(value = "SELECT u.us_fullname FROM user u WHERE u.us_id = (SELECT user_id FROM result where rs_id = ?1)"
, nativeQuery = true)
    String findUserFromResult(@PathVariable Integer id);
}
