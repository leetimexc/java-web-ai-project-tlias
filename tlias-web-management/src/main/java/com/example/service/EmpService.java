package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {
    /*
     * 分页查询
     * @param page
     * @param pageSize
     */
    /* PageResult<Emp> page(Integer page, Integer pageSize,
                         String name,
                         Integer gender,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ); */

    /*
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);
}