package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tensquare.article.pojo.Article;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{
	
	@Modifying
	@Query(value="UPDATE tb_article SET state=1 WHERE id=?",nativeQuery=true)
	void updateState(String id);
	
	@Modifying
	@Query(value="UPDATE tb_article SET thumbup=thumbup+1 WHERE id=?",nativeQuery=true)
	void addThumbup(String id);
}
