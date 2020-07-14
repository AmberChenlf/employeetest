package com.kuang.dao;

import com.kuang.dao.DepartmentDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bingqiong.cbb
 * @date 2020-07-01 22:56
 **/

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees=null;
    @Autowired
    public DepartmentDao departmentDao;
    static{
        employees = new HashMap<>();
        employees.put(101, new Employee(101,"教学", "qq.com",0,new Department(101,"教学部"),new Date()));
        employees.put(102, new Employee(102,"市场", "qq.com",0,new Department(101,"教学部"),new Date()));
        employees.put(103, new Employee(103,"教研", "qq.com",0,new Department(101,"教学部"),new Date()));
        employees.put(104, new Employee(104,"运营", "qq.com",0,new Department(101,"教学部"),new Date()));
        employees.put(105, new Employee(105,"后勤", "qq.com",0,new Department(101,"教学部"),new Date()));
        employees.put(106, new Employee(106,"小卖", "qq.com",0,new Department(101,"教学部"),new Date()));
    }
    //主键自增
    private Integer initId = 1006;

    public EmployeeDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    //增加员工
    public void add(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentbyId(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);


    }

    public Collection<Employee> getAllEmployee(){
        return employees.values();

    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delelte(Integer id){
        employees.remove(id);
    }
}
