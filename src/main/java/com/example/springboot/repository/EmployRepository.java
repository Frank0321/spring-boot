/**
 * @Description : 員工資料 Dao
 * @ClassName : EmployRepository.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/09, Frank
 *   1) First Release.
 */

package com.example.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.EmployEntity;

@Repository
public interface EmployRepository extends JpaRepository<EmployEntity, Long>{

	/**
	 * @param empNo
	 * @return
	 */
	Optional<EmployEntity> findByEmpNo(String empNo);

	/**
	 * @param list
	 * @return
	 */
	@Query(value = "select * from Employ_Entity where emp_No in (?1)", nativeQuery = true)
	List<EmployEntity> findList(List<String> list);

}
