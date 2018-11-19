package com.aaa.ssm.service;

import com.aaa.ssm.dao.EmpDao;
import com.aaa.ssm.entitys.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> getList(Map map) {
        map.put("sort",map.get("sort")==null?"empno":map.get("sort"));
        map.put("order",map.get("order")==null?"desc":map.get("order"));
        return empDao.getList(map);
    }

    @Override
    public int addEmp(Emp emp) {
        return empDao.addEmp(emp);
    }

    @Override
    public int deleteEmp(Integer empno) {
        return empDao.deleteEmp(empno);
    }

    @Override
    public List<Emp> byIdgetList(Integer newsid) {
        return empDao.byIdgetList(newsid);
    }

    @Override
    public int empUpdate(Emp emp) {
        return empDao.empUpdate(emp);
    }

    @Override
    public List<Map> userLogin(Map map) {
        return empDao.userLogin(map);
    }

    @Override
    public List<Emp> getProListByDeptNo(int deptNo) {
        Map map = new HashMap();
        map.put("deptNo",deptNo);
        //调用了根据存储过程获取列表方法之后
        empDao.getProListByDeptNo(map);
        //调用返回结果
        List<Emp> csrEmp = (List<Emp>) map.get("csrEmp");
        return csrEmp;
    }

    @Override
    public int addId(Map map) {
         int a =empDao.addId(map);
        System.out.println("返回的主键："+map.get("empNo"));
        return a;
    }
}