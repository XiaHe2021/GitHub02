package com.turing.sb4.controller;

import com.turing.sb4.Dao.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.turing.sb4.entity.dept;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//部門控制器
@Controller
@RequestMapping("/dept")
public class DeptController {

         @Autowired
         private DeptRepository deptRepository;

         //根據編號查詢部門
         @GetMapping("/{deptno}")
         @ResponseBody
         public List<dept> findBydeptno(@PathVariable("deptno") Integer deptno){
            return deptRepository.findBydeptno(deptno);
         }
         // 2.添加一个新的部门。
         @GetMapping("/add/{dname}/{loc}")
         @ResponseBody
         public dept addDept(@PathVariable("dname") String dname,@PathVariable("loc") String loc){
             dept d=new dept();
             d.setDname(dname);
             d.setLoc(loc);
             dept save = deptRepository.save(d);
//             d.setDname("銷售部");
//             d.setLoc("Logs");
            return save ;
         }

         //3.修改新增的部门名称。
        @GetMapping("/Update/{id}")
        @ResponseBody
        public dept Updatedept(@PathVariable("id") Integer id){
        dept  d=new dept();
        d.setDeptno(id);
        d.setDname("TIANBINGQIANG");
        d.setLoc("I LOVE YOU");
        dept save = deptRepository.save(d);
        return save;
    }
      //1.查询部门表中，部门编号大于等于30，部门名称中包含“T”关键字，并降序排列。
      @GetMapping("/findLike/{id}/{dname}")
      @ResponseBody
      public  List<dept> findAllLike(@PathVariable("id") Integer id,@PathVariable("dname") String dname){
          return  deptRepository.findeptno(id, dname);
      }


}
