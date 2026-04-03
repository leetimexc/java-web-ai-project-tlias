package com.example.service;

import com.example.pojo.PageResult;

public interface EmpService {
    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     */
    PageResult page(Integer page, Integer pageSize);
}
