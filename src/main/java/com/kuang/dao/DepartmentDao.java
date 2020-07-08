package com.kuang.dao;

import com.kuang.pojo.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bingqiong.cbb
 * @date 2020-07-01 22:49
 * 部门dao
 **/

@Repository
public class DepartmentDao {
    //模拟数据库中的数据

    private static Map<Integer, Department> deparment=null;
    static{
        deparment = new HashMap<Integer, Department>();
        deparment.put(101, new Department(101,"教学部"));
        deparment.put(102, new Department(102,"市场部"));
        deparment.put(103, new Department(103,"教研部"));
        deparment.put(104, new Department(104,"运营部"));
        deparment.put(105, new Department(105,"后勤部"));
        deparment.put(106, new Department(106,"小卖部"));
    }

    //获得所有部门信息
    public Collection<Department> getAllDepartment(){
        return deparment.values();
    }

    //get department by id
    public Department getDepartmentbyId(Integer id){
        return deparment.get(id);

    }
}
