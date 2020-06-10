package com.hc.controller;

import com.hc.bean.Dept;
import com.hc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by HC on 2018/4/18.
 */
@RestController
@RequestMapping(value = "/jpa")
public class DeptController {

    @Autowired
    private DeptService deptService;

    //查询多个
    @GetMapping(value = "/list")
    public List<Dept> getList() {
        return deptService.findAll();
    }

    //http://localhost/helloworld/jpa/add/zhangsan/loc
    //添加
    @GetMapping(value = "/add/{dname}/{loc}")
    public Dept add1(@PathVariable("dname") String dname,
                     @PathVariable("loc") String loc
    ) {
        for(int i =0;i<200;i++){
            Dept dept = new Dept(UUID.randomUUID().toString().substring(0,12), UUID.randomUUID().toString().substring(0,12));
            deptService.save(dept);
        }
        Dept dept = new Dept(dname, loc);
        return deptService.save(dept);
    }

    //http://localhost/helloworld/jpa/add
    // zhangsan
    // loc
    //添加
    @PostMapping(value = "/add")
    public Dept add2(@RequestParam("dname") String dname,
                     @RequestParam("loc") String loc
    ) {
        Dept dept = new Dept(dname, loc);
        return deptService.save(dept);
    }

    //查询一个
    @GetMapping(value = "/find/{deptno}")
    public Dept find1(@PathVariable("deptno") Integer deptno) {
        return deptService.findById(deptno);
    }

    @GetMapping(value = "/find/dname/{dname}")
    public List<Dept> find2(@PathVariable("dname") String dname) {
        return deptService.findByDname(dname);
    }

    //更新
    @GetMapping(value = "/update/{deptno}")
    public Dept update1(@PathVariable("deptno") Integer deptno) {
        Dept dept = new Dept(1, "lisi", "china");
        return deptService.save(dept);
    }

    //更新  put方式要求采用x-www-form-urlencoded请求
    @PutMapping(value = "/update/{deptno}")
    public Dept update2(@PathVariable("deptno") Integer deptno,
                        @RequestParam("dname") String dname,
                        @RequestParam("loc") String loc) {
        Dept dept = new Dept(deptno, dname, loc);
        return deptService.save(dept);
    }

    //删除
    @GetMapping(value = "/delete/{deptno}")
    public void delete1(@PathVariable("deptno") int deptno) {
        deptService.deleteById(deptno);
    }

    //删除
    @DeleteMapping(value = "/delete/{deptno}")
    public void delete2(@PathVariable("deptno") int deptno) {
        deptService.deleteById(deptno);
    }

    //事务
    @GetMapping(value = "save/two")
    public void saveTrans(){
        deptService.insertWithTrans();
    }
}
