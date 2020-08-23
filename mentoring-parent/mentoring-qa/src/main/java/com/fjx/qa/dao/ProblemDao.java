package com.fjx.qa.dao;


import com.fjx.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {

    /**
     * @Description:  最新回答
     * @param [labelid, pageable]
     * @Return: java.util.List<com.tensqure.qa.pojo.Problem>
     * @Author: Jason
     * @Date: 2020-04-15 19:16
     */
    @Query(value = "SELECT * FROM  tb_problem,tb_pl WHERE id=problemid AND labelid=?1 ORDER BY replytime DESC",nativeQuery = true)
    public Page<Problem> newList(String labelid, org.springframework.data.domain.Pageable pageable);

    /**
     * @Description: 热门回答
     * @param [labelid, pageable]
     * @Return: java.util.List<com.tensqure.qa.pojo.Problem>
     * @Author: Jason
     * @Date: 2020-04-15 19:16
     */
    @Query(value = "SELECT * FROM  tb_problem,tb_pl WHERE id=problemid AND labelid=? ORDER BY reply DESC",
            nativeQuery = true)
    public Page<Problem> hotList(String labelid, org.springframework.data.domain.Pageable pageable);

    /**
     * @Description: 等待回答
     * @param [labelid, pageable]
     * @Return: java.util.List<com.tensqure.qa.pojo.Problem>
     * @Author: Jason
     * @Date: 2020-04-15 19:17
     */
    @Query(value = "SELECT * FROM  tb_problem,tb_pl WHERE id=problemid AND labelid=?1 AND reply=0 ORDER BY " +
            "createtime DESC",nativeQuery = true)
    public Page<Problem> waitList(String labelid, org.springframework.data.domain.Pageable pageable);

}
