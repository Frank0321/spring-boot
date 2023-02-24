/**
 * @Description : 員工的工作時數 Dao
 * @ClassName : EmployWorkTimeRepository.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/02/23, frankchang
 *   1) First Release.
 */

package com.example.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.EmployWorkTimeEntity;

@Repository
public interface EmployWorkTimeRepository extends JpaRepository<EmployWorkTimeEntity, Integer>{

	/**
	 * @param id
	 * @return
	 */
	List<EmployWorkTimeEntity> findByEmpId(long id);

}
