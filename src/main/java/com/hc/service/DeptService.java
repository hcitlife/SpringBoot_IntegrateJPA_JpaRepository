package com.hc.service;

import com.hc.bean.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by HC on 2018/4/18.
 */
public interface DeptService {
    //查询多个

    List<Dept> findAll();

    Dept save(Dept dept);

    Dept findById(Integer deptno);

    List<Dept> findByDname(String dname);

    void deleteById(Integer deptno);

    @Transactional
    void insertWithTrans();

    //分页
    Page<Dept> findByPage(Pageable pageable);
}
