package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门信息
     * @return
     */
     List<Dept> findAll();
}
