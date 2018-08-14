package com.lzf.springcloud.controller;

import com.lzf.springcloud.entity.Dept;
import com.lzf.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);
        if(dept == null){
            throw new RuntimeException("ID: " + id + " 找不到对应的记录");
        }
        return dept;
    }

    public Dept processHystrix_get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("找不到对应记录");
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.list();
    }
}
