/**
 * @Description : 員工資料 Dao
 * @ClassName : EmployRepository.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/09, Frank
 *   1) First Release.
 */

package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.EmployEntity;

@Repository
public interface EmployRepository extends JpaRepository<EmployEntity, Long>{

}