package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult page(Integer page, Integer pageSize) {
        //1. 获取总记录数
       Long total = empMapper.count();
       //2. 获取分页查询结果列表
        Integer start = (page -1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);
        //3. 封装PageResult对象并返回
        return new PageResult(total, empList);
    }

}