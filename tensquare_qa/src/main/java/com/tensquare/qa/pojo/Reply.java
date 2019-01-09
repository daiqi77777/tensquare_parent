package com.tensquare.qa.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_reply")
@Getter
@Setter
public class Reply implements Serializable{

	private static final long serialVersionUID = 427449608145194954L;
	
	@Id
	private String id;//编号
	
	private String problemid;//问题ID
	
	private String content;//回答内容
	
	private Date createtime;//创建日期
	
	private Date updatetime;//更新日期
	
	private String userid;//回答人ID
	
	private String nickname;//回答人昵称

}