package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.tensquare.qa.pojo.Problem;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
	
	//这个注解相当于告诉JPA用原生的sql进行查询
	@Query(value="SELECT * FROM `tb_problem` INNER  JOIN tb_pl ON id=problemid WHERE labelid=? ORDER BY replytime DESC",nativeQuery = true)
	Page<Problem> newList(String labelid,Pageable pageable);
	
	@Query(value="SELECT * FROM `tb_problem` INNER  JOIN tb_pl ON id=problemid WHERE labelid=? ORDER BY reply DESC",nativeQuery = true)
	Page<Problem> hotList(String labelid,Pageable pageable);
	
	@Query(value="SELECT * FROM `tb_problem` INNER  JOIN tb_pl ON id=problemid WHERE labelid=? AND reply=0 ORDER BY createtime DESC",nativeQuery = true)
	Page<Problem> waitList(String labelid,Pageable pageable);
	
}