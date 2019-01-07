package com.tensquare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.pojo.Label;

public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label>{
}