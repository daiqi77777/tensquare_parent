package com.tensquare.service;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tensquare.dao.LabelDao;
import com.tensquare.pojo.Label;

import util.IdWorker;


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

	/**
	 * @param label
	 * @return
	 */
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
				return null;
			}
		});
	}
}