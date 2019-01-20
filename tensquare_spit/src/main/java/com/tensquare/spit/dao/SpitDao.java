package com.tensquare.spit.dao;

import com.tensquare.spit.pojp.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 冯彧
 * @date 2019/1/20 20:29
 * @description
 */
public interface SpitDao extends MongoRepository<Spit,String> {

    Page<Spit> findByParentid(String parenrtid, Pageable pageable);

}
