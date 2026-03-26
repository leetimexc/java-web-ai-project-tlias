package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门信息
     * @return
     */
     List<Dept> findAll();

    /**
     * 根据id删除部门
     */
    void deleteById(Integer id);

    /**
     * 新增部门
     */
    void save(Dept dept);

    /**
     * 根据id查询部门
     */
    Dept getById(Integer id);
}
