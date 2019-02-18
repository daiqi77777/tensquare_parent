package com.tensquare.service;


import com.tensquare.dao.LabelDao;
import com.tensquare.pojo.Label;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class LabelService {

	@Autowired
	private LabelDao labelDao;

	@Autowired
	private IdWorker idWorker;

	public List<Label> findAll() {
		return labelDao.findAll();
	}

	public Label findById(String labelId) {
		return labelDao.findById(labelId).get();
	}

	public void save(Label label) {
		label.setId(idWorker.nextId()+"");
		labelDao.save(label);
	}

	public void update(Label label) {
		labelDao.save(label);
	}

	public void deleteById(String labelId) {
		labelDao.deleteById(labelId);
	}

	public List<Label> findSearch(Label label) {
		return labelDao.findAll(new Specification<Label>() {

			private static final long serialVersionUID = 1L;

			/**
			 * @param root 根对象,也就是要把条件封装到哪个对象中(where 类名=label.getId)
			 * @param query 封装的都是查询的关键字(order by group by 等)
			 * @param cb 用来封装条件对象的
			 */
			@Override
			public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList=new ArrayList<>();
				if(StringUtils.isNotEmpty(label.getLabelname())){
					predicateList.add(cb.like(root.get("labelname").as(String.class), "%"+label.getLabelname()+"%" ) );
				}
				if(StringUtils.isNotEmpty(label.getState())){
					predicateList.add(cb.equal(root.get("state").as(String.class),label.getState()));
				}
				if(StringUtils.isNotEmpty(label.getRecommend())){
					predicateList.add(cb.equal(root.get("recommend").as(String.class),label.getRecommend()) );
				}
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
			}
		});
	}

	public Page<Label> searchPage(Label label,int page,int size) {
		if(page<=0) {
			page = 1;
		}
		Pageable Pageable = PageRequest.of(page-1, size);
		return labelDao.findAll(new Specification<Label>() {

			private static final long serialVersionUID = 1L;

			/**
			 * @param root 根对象,也就是要把条件封装到哪个对象中(where 类名=label.getId)
			 * @param query 封装的都是查询的关键字(order by group by 等)
			 * @param cb 用来封装条件对象的
			 */
			@Override
			public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList=new ArrayList<>();
				if(StringUtils.isNotEmpty(label.getLabelname())){
					predicateList.add(cb.like(root.get("labelname").as(String.class), "%"+label.getLabelname()+"%" ) );
				}
				if(StringUtils.isNotEmpty(label.getState())){
					predicateList.add(cb.equal(root.get("state").as(String.class),label.getState()));
				}
				if(StringUtils.isNotEmpty(label.getRecommend())){
					predicateList.add(cb.equal(root.get("recommend").as(String.class),label.getRecommend()) );
				}
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
			}
		},Pageable);
	}
}