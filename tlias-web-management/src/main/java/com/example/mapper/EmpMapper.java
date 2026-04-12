package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {
    /**
     * 查询员工数量
     */
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id;")
    public long count();

}
