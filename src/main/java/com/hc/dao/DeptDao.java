package com.hc.dao;

import com.hc.bean.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by HC on 2018/4/18.
 */
public interface DeptDao extends JpaRepository<Dept, Integer> {
    List<Dept> findByDname(String dname);
    List<Dept> findByLocNotNull();
    List<Dept> findByDnameIgnoreCase(String dname);
}
