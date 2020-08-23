package com.fjx.base.dao;/*
 * @program: tensquare_parent
 * @Date: 2020-04-14 10:35
 * @Author: Jason
 * @Description:
 */

import com.fjx.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface  LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
