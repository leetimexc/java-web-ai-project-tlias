package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

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

    /*
     * 新增员工信息
     */
    void save(Emp emp);

    /*
     * 批量删除员工信息
     */
    void delete(List<Integer> ids);
}