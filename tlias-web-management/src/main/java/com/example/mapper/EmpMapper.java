package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {

    // ------------------------------------- 1. 原始分页查询实现
    /**
     * 查询员工数量
     */
    // @Select("select count(*) from emp e left join dept d on e.dept_id = d.id;")
    // public long count();

    /**
     * 分页查询
     */
    //  @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
    //     "order by e.update_time desc limit #{start},#{pageSize};")
    //  public List<Emp> list(Integer start, Integer pageSize);

    // ------------------------------------- 2. 使用PageHelper依赖
    // @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
    // public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 条件查询员工信息
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工基本信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "id") // mybatis自动生成id,获取到生成的主键 -- 主键返回
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 根据ID批量删除员工信息
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID查询员工信息以及工作经历信息
     */
    Emp getById(Integer id);

    /**
     * 根据ID更新员工基本信息
     */
    void updateById(Emp emp);

    
}
