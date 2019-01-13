package com.tensquare.article.pojo;

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
@Table(name="tb_channel")
@Getter
@Setter
public class Channel implements Serializable{

	private static final long serialVersionUID = 137861156971098453L;

	@Id
	private String id;//ID
	
	private String name;//频道名称
	
	private String state;//状态
}