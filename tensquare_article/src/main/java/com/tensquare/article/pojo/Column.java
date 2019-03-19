package com.tensquare.article.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_column")
@Getter
@Setter
public class Column implements Serializable{

	private static final long serialVersionUID = -4883453133454844776L;

	@Id
	private String id;//ID

	private String name;//专栏名称

	private String summary;//专栏简介

	private String userid;//用户ID

	private Date createtime;//申请日期

	private Date checktime;//审核日期

	private String state;//状态
}