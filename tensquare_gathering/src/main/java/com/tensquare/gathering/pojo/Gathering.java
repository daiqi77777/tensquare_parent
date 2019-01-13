package com.tensquare.gathering.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_gathering")
@Getter
@Setter
public class Gathering implements Serializable{

	private static final long serialVersionUID = -6677308690237377063L;

	@Id
	private String id;//编号

	private String name;//活动名称
	
	private String summary;//大会简介
	
	private String detail;//详细说明
	
	private String sponsor;//主办方
	
	private String image;//活动图片
	
	private java.util.Date starttime;//开始时间
	
	private java.util.Date endtime;//截止时间
	
	private String address;//举办地点
	
	private java.util.Date enrolltime;//报名截止
	
	private String state;//是否可见
	
	private String city;//城市
}