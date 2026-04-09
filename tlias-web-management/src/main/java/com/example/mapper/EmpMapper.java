package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
    public Long count();

    /**
     * 查询所有的员工及其对应的部门名称
     */
    //    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id limit #{start}, #{pageSize}")
    //    public List<Emp> list(Integer start , Integer pageSize);
    /**
     * 查询所有的员工及其对应的部门名称
     * 使用pagehelper插件
     */
//    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id")
//    public List<Emp> list();
    /**
     * 查询所有的员工及其对应的部门名称
     */
    // public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    /**
     * 根据查询条件查询员工
     */
    List<Emp> list(EmpQueryParam empQueryParam);
}
