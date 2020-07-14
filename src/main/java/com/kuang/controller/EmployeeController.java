package com.kuang.controller;

import com.kuang.dao.DepartmentDao;
import com.kuang.dao.EmployeeDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/emps")
    public String getAllEmployee(Model model){
        Collection<Employee> employees = employeeDao.getAllEmployee();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @RequestMapping("/emp")
    public String addEmployee(Model model){
        Collection<Department> des = departmentDao.getAllDepartment();

        model.addAttribute("des", des);
        return "emp/add";

    }

    @RequestMapping("/emp2")
    public String add(Employee employee){
        System.out.println(employee);
        employeeDao.add(employee);
        return "redirect:/emps";

    }


}
