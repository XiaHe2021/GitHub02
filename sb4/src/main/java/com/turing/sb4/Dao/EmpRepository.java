package com.turing.sb4.Dao;

import com.turing.sb4.entity.dept;
import com.turing.sb4.entity.emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//员工Dao层接口
public interface EmpRepository extends JpaRepository<emp,Integer> {

    @Query("select e from emp e where e.deptno=:#{d}")
    public List<emp> findBydeptno(@Param("d")  Integer d );
}
