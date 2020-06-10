package com.hc.service.impl;

import com.hc.bean.Dept;
import com.hc.dao.DeptDao;
import com.hc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HC on 2018/4/18.
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    @Override
    public Dept save(Dept dept) {
        return deptDao.save(dept);
    }

    @Override
    public Dept findById(Integer deptno) {
        return deptDao.findById(deptno).get();
    }

    @Override
    public List<Dept> findByDname(String dname) {
        return deptDao.findByDname(dname);
    }

    @Override
    public void deleteById(Integer deptno) {
        deptDao.deleteById(deptno);
    }

    @Override
    public void insertWithTrans() {
        Dept dept1 = new Dept("11", "11");
        deptDao.save(dept1);
        Dept dept2 = new Dept("222222222222222222222222222222222222222222", "22");//长度超出限制，特意出错
        deptDao.save(dept2);
    }

    @Override
    public Page<Dept> findByPage(Pageable pageable) {
        return deptDao.findAll(pageable);
    }
}
