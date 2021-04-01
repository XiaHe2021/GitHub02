package com.turing.sb4.controller;

import com.turing.sb4.Dao.EmpRepository;
import com.turing.sb4.entity.dept;
import com.turing.sb4.entity.emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

//員工控制器
@Controller
@RequestMapping("/Emp")
public class EmpController {

     @Autowired
      private EmpRepository empRepository;

     @GetMapping("/{id}")
     @ResponseBody
     public emp findById(@PathVariable("id") Integer id){
         Optional<emp> op = empRepository.findById(id);
         emp Emp=null;
         if(op.isPresent()){
             Emp=op.get();
         }
         return Emp;
     }

     @GetMapping("/Dept/{deptno}")
     @ResponseBody
     public List<emp> findBydeptno(@PathVariable("deptno") Integer deptno){
         dept d=new dept();
         d.setDeptno(deptno);
         return  empRepository.findBydeptno(deptno);
     }

}
