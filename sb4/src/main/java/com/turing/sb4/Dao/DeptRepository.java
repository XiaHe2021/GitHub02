package com.turing.sb4.Dao;
import com.turing.sb4.entity.dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeptRepository extends JpaRepository <dept ,Integer> {

     @Query("select  d from dept d where d.deptno=:deptno")
      public List<dept> findBydeptno(@Param("deptno") Integer deptno);

     //1.查询部门表中，部门编号大于等于30，部门名称中包含“T”关键字，并降序排列。
    @Query("select d from dept d where d.deptno>=:deptno and d.dname LIKE concat('%',:dname,'%') order by d.deptno desc")
    public List<dept> findeptno(@Param("deptno") Integer deptno ,@Param("dname") String dname);
}
