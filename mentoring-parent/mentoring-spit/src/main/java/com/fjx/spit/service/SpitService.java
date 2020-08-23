package com.fjx.spit.service;/*
 * @program: tensquare_parent
 * @Date: 2020-04-16 11:40
 * @Author: Jason
 * @Description:
 */


import com.fjx.spit.dao.SpitDao;
import com.fjx.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import until.IdWorker;

import javax.management.Query;
import java.util.Date;
import java.util.List;

@Service
public class SpitService {
    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Spit> findAll() {

        return spitDao.findAll();
    }

    public Spit findById(String SpitId) {

        return spitDao.findById(SpitId).get();
    }

    public void add(Spit spit) {

        spit.setId(idWorker.nextId() + "");
        // 给其它属性初始化值
        spit.setPublishtime(new Date());
        spit.setVisits(0);
        spit.setShare(0);
        spit.setThumbup(0);
        spit.setComment(0);
        spit.setVisits(0);
        spit.setState("1");
        //  如果发布吐槽，查看是否有父节点，有，则父节点回复数加一
        if (spit.getParentid() != null && !"".equals(spit.getParentid())) {
            //如果存在上级ID,评论             
            Query query = new Query();
            //query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            //mongoTemplate.updateFirst(query, update, "spit");
        }

        spitDao.save(spit);
    }

    public void deleteById(String spit) {
        spitDao.deleteById(spit);
    }

    public void update(Spit Spit) {
        spitDao.save(Spit);
    }

    public Page<Spit> findByParentid(String parentid, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
//        PageRequest pageRequest= PageRequest.of(page-1,size);
        return spitDao.findByParentid(parentid, pageRequest);

    }

    public void thumbup(String spitId) {
        // 效率太低
        /*
        Spit spit = spitDao.findById(spitId).get();
        spit.setThumbup((spit.getThumbup() == null ? 0 : +spit.getThumbup()) + 1);
        spitDao.save(spit);
        */

        // 使用mongo命令实现自增 db.spit.update({"  _id":"1"},{$inc:{thumbup:NumberInt(1)})}

        Query query = new Query();
        //query.addCriteria(Criteria.where("_id").is(spitId));

        Update update = new Update();
        update.inc("thumbup", 1);

        //mongoTemplate.updateFirst(query, update, "spit");

    }
}
