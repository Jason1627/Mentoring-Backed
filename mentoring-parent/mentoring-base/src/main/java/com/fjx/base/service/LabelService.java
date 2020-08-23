package com.fjx.base.service;/*
 * @program: tensquare_parent
 * @Date: 2020-04-14 10:36
 * @Author: Jason
 * @Description:
 */

import com.fjx.base.dao.LabelDao;
import com.fjx.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import until.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /*
     * @Description: 查询全部标签
     * @param []
     * @Return: java.util.List<com.tensqure.base.pojo.Label>
     * @Author: Jason
     * @Date: 2020-04-14 11:01
     */
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /*
     * @Description: 根据ID查询标签
     * @param [id]
     * @Return: com.tensqure.base.pojo.Label
     * @Author: Jason
     * @Date: 2020-04-14 11:01
     */
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /*
     * @Description: 增加标签
     * @param [label]
     * @Return: void
     * @Author: Jason
     * @Date: 2020-04-14 11:02
     */
    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);

    }

    /*
     * @Description: 更新标签
     * @param [label]
     * @Return: void
     * @Author: Jason
     * @Date: 2020-04-14 11:03
     */
    public void update(Label label) {
        labelDao.save(label);

    }

    /*
     * @Description: 根据ID 删除标签
     * @param [id]
     * @Return: void
     * @Author: Jason
     * @Date: 2020-04-14 11:03
     */
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    /*
     * @Description:
     * @param [label]
     * @Return: java.util.List<com.tensqure.base.pojo.Label>
     * @Author: Jason
     * @Date: 2020-04-14 16:24
     */
    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {

            /*
             * @Description:
             * @param [root, 根对象，也就是说吧条件封装到哪个对象当中 where 类名=label.getid
             * criteriaQuery, 封装的是查询的关键字 比如 group by  order by
             *  cb,  用来封装条件对象的，如果直接返回null，表示不需要任何条件
             * ]
             * @Return: javax.persistence.criteria.Predicate
             * @Author: Jason
             * @Date: 2020-04-14 16:28
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {

                List<Predicate> list = new ArrayList<>();

                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("lablename").as(String.class),
                            "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }

                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }

                // new 一个数组作为最终返回值条件
                Predicate[] parr = new Predicate[list.size()];
                // list 转数组
                parr = list.toArray(parr);
                return criteriaBuilder.and(parr);
            }
        });

    }

    /*
     * @Description: 分页查询标签
     * @param [label, page, size]
     * @Return: org.springframework.data.domain.Page<com.tensqure.base.pojo.Label>
     * @Author: Jason
     * @Date: 2020-04-15 8:21
     */
    public Page<Label> pageQuery(Label label, int page, int size) {

        Pageable pageable = PageRequest.of(page - 1, size);
        return labelDao.findAll(new Specification<Label>() {

            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {

                List<Predicate> list = new ArrayList<>();

                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("lablename").as(String.class),
                            "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }

                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }

                // new 一个数组作为最终返回值条件
                Predicate[] parr = new Predicate[list.size()];
                // list 转数组
                parr = list.toArray(parr);
                return criteriaBuilder.and(parr);
            }
        }, pageable);
    }

}
