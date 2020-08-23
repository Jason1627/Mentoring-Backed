package com.fjx.spit.dao;/*
 * @program: tensquare_parent
 * @Date: 2020-04-16 11:39
 * @Author: Jason
 * @Description:
 */

import com.fjx.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpitDao extends MongoRepository<Spit,String> {

     Page<Spit> findByParentid(String parentid, Pageable pageable);

    void thumbup(String spitId);
}
