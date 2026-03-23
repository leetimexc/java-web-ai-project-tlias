package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门信息
     */
    // 方法一：手动映射字段 @Results及@Result
    //    @Results({
    //            @Result(property = "createTime", column = "create_time"),
    //            @Result(property = "updateTime", column = "update_time")
    //    })
    //    @Select("select id,name,create_time,update_time from dept order by update_time desc")

    // 方法二：起别名 create_time createTime
    //    @Select("select id,name,create_time createTime,update_time updateTime from dept order by update_time desc")

    // 方法三（终极方案）：开启驼峰命名 mybatis.configuration.map-underscore-to-camel-case=true
    @Select("select id,name,create_time,update_time from dept order by update_time desc")
    List<Dept> findAll();
}
