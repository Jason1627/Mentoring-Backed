package com.fjx.recruit.dao;


import com.fjx.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {
    /*
    * @Description: 推荐职位，按时间升序
    * @param [state]  
    * @Return: java.util.List<com.tensqure.recruit.pojo.Recruit>
    * @Author: Jason
    * @Date: 2020-04-15 10:22
    */
	public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state); // where state="?" orderby createtime
    
    /*
    * @Description: 最新职位 ，所以需要时间倒序排序
    * @param [state]
    * @Return: java.util.List<com.tensqure.recruit.pojo.Recruit>
    * @Author: Jason
    * @Date: 2020-04-15 10:23
    */
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);// where state !="?" orderby createtime
   
}
