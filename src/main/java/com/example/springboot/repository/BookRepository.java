/**
 * @Description : 書本 Dao
 * @ClassName : BookRepository.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/02/06, frankchang
 *   1) First Release.
 */

package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{

}
