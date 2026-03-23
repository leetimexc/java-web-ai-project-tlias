package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //  @RequestMapping(value = "/depts",method = RequestMethod.GET) // 这种有点繁琐
    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门 - delete http://localhost:8080/depts?id=1
     */
    @DeleteMapping("/depts")
    public Result delete(Integer id){
        System.out.println("删除部门：" + id);
        deptService.deleteById(id);
        return Result.success();
    }


}
