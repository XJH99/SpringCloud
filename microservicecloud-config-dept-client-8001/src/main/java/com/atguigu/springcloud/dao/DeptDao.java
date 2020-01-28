package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * dao层接口，Mapper注解非常的关键
 */
@Mapper
public interface DeptDao {

    public Boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
