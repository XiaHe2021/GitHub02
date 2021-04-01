package com.turing.sb4.entity;

import lombok.Data;

import javax.persistence.*;

//部门实体类
@Entity
@Table(name = "dept")
@Data
public class dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键
    private Integer deptno;
    private String dname;
    private String loc;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
