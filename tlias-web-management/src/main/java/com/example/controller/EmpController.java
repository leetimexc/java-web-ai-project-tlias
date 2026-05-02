package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
    /* @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end ){
        // 比较繁琐 ， 推荐使用 springboot的 注解 @RequestParam
        // if (page == null || page <= 0){
        //  page = 1;
        // }
        log.info(
                "分页查询，参数：page={}，pageSize={}, name={}, gender={},begin={},end={}",
                page,pageSize,name,gender,begin,end
        );
        PageResult<Emp> pageResult = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageResult);
    }*/

    /*
     * 分页查询
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询，参数：{}",empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 新增员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 方式一： 通过数组来接收
     * 员工删除 - 数组
     */
    /*
    @DeleteMapping
    public Result delete(Integer[] ids){
        log.info("员工删除，参数：{}", Arrays.toString(ids));
        return Result.success();
    }
    */

    /**
     * 方式二： 通过集合来接收
     * 员工删除 - List
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("员工删除，参数：{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 根据ID查询员工信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("员工回显，参数：{}", id);
        Emp emp =empService.getInfo(id);
        return Result.success(emp);
    }
}