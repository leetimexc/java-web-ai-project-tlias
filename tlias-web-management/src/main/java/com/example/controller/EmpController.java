package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工管理Controller
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /*
    * 分页查询
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        // 比较繁琐 ， 推荐使用 springboot的 注解 @RequestParam
        // if (page == null || page <= 0){
        //  page = 1;
        // }
        log.info("分页查询，参数：page={}，pageSize={}",page,pageSize);
        PageResult<Emp> pageResult = empService.page(page,pageSize);
        return Result.success(pageResult);
    }

}