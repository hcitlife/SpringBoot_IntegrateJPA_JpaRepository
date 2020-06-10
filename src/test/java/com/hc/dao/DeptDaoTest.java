package com.hc.dao;

import com.hc.bean.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptDaoTest {

    @Autowired
    private  DeptDao deptDao;

    @Test
    public void findByDname() {
        List<Dept> depts = deptDao.findByDname("4511-b4ec");
        depts.forEach(System.out::println);
    }

    @Test
    public void findByLocNotNull() {
        List<Dept> deptList = deptDao.findByLocNotNull();
        for (Dept dept : deptList) {
            System.out.println(dept);
        }
    }

    @Test
    public void findByDnameIgnoreCase(){
        List<Dept> deptList = deptDao.findByDnameIgnoreCase("4511-b4EC");
        deptList.forEach(dept-> System.out.println(dept));
    }

}