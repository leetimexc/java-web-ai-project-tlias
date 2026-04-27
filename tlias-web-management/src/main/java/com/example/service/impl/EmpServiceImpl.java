package com.example.service.impl;

import com.example.mapper.EmpExprMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.*;
import com.example.service.EmpLogService;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    /**
     * 1. 原始分页查询
     */
    //    @Override
    //    public PageResult<Emp> page(Integer page, Integer pageSize) {
    //        // 1. 调用mapper接口，查询总记录数
    //        Long total = empMapper.count();
    //
    //        // 2. 调用mapper接口，查询分页数据
    //        Integer start = (page - 1) * pageSize;
    //        List<Emp> rows = empMapper.list(start, pageSize);
    //
    //        // 3. 封装结果 PageResult
    //        return new PageResult<Emp>(total, rows);
    //    }

    /**
     * 2. 引入PageHelper依赖实现分页查询
     * 使用PageHelper注意事项：
     * 1. 定义的SQL语句结尾不能加分号；
     * 2. PageHelper 仅仅能对紧跟在其后的第一个查询语句进行分页处理
     */
    /* @Override
    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        // 1. 设置分页参数（PageHelper）
        PageHelper.startPage(page, pageSize);

        // 2. 执行查询（PageHelper）
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        // tips: 这里对应上面的注意事项2，后面再加不会自动添加分页处理功能

        // 3. 解析查询结果，并封住
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    } */
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // 1. 设置分页参数（PageHelper）
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 2. 执行查询（PageHelper）
        List<Emp> empList = empMapper.list(empQueryParam);
        // tips: 这里对应上面的注意事项2，后面再加不会自动添加分页处理功能

        // 3. 解析查询结果，并封住
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Transactional // 添加事务注解 - 默认出现运行时异常RuntimeException时，事务才会生效 ,如果想全部生效，使用 @Transactional(roll)
    @Override
    public void save(Emp emp) {
        try {
            // 1. 保存员工基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setCreateTime(LocalDateTime.now());

            //2.保存员工基本信息
            empMapper.insert(emp);

            // int i = 1/0; // 异常测试事务
            /* if (true){
                throw new Exception("保存员工信息异常");
            }*/

            //3. 保存员工的工作经历信息 - 批量
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                // 遍历集合，为empId赋值
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // 记录操作日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工信息:"+emp);
            empLogService.insertLog(empLog);
        }

    }


}