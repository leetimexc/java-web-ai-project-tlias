package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门信息
     * @return
     */
    @Select("select id,name,create_time,update_time from dept order by update_time desc")
    List<Dept> findAll();
}
