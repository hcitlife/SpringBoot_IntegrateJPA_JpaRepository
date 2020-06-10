package com.hc.service;

import com.hc.bean.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptServiceTest {

    @Autowired
    private DeptService deptService;

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findByDname() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void insertWithTrans() {
    }

    @Test
    public void findByPage() {
        PageRequest pageRequest = PageRequest.of(0,2);
        for (Dept dept : deptService.findByPage(pageRequest)) {
            System.out.println(dept);
        }
    }
}